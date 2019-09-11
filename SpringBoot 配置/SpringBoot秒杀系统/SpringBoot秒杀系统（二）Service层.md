## SpringBoot秒杀系统（二）Service层

项目地址：https://github.com/wannengdek/SpringBoot-Seckill

如果项目对您有所帮助，麻烦帮忙点亮小⭐⭐

Sservice层又称业务层，用来实现相关业务。需要将DAO层写好的数据操作在service 层中进行拼装。

对于秒杀，需要查询所有秒杀记录和单条秒记录，还有就是不能让用户提前知道秒杀地址，需要先输出一个秒杀地址。还有就是执行秒杀的操作接口。

### SeckillService：

```java
    /**
     * 获取所有的秒杀商品列表
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 获取某一条商品秒杀信息
     *
     * @param seckillId
     * @return
     */
    Seckill getById(Integer seckillId);

    /**
     * 秒杀开始时输出暴露秒杀的地址
     * 否者输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(Integer seckillId);

    /**
     * 执行秒杀的操作
     *  @param seckillId
     *
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(Integer seckillId, String userPhone, String md5)
     throws SeckillException, RepeatKillException, SeckillCloseException;
```

全部的实现代码放最下面，咱们来一个一个讲每个实现类的作用。

开启秒杀的地址，返回的是一个秒杀的中间类`Exposer`类，用来输出一些特定的信息。

### exportSeckillUrl 得到秒杀地址

```java
public Exposer exportSeckillUrl(Integer seckillId)
```

Exposer：

```java
@Data
public class Exposer {

    //是否开启秒杀
    private boolean exposed;

    //加密措施，避免用户通过抓包拿到秒杀地址
    private String md5;

    //ID
    private Integer seckillId;

    //系统当前时间（毫秒）
    private long now;

    //秒杀开启时间
    private long start;

    //秒杀结束时间
    private long end;
 }
```

#### 接口实现：

如果返回的是一个 true， 代表秒杀开启，并且得到一个 md5值和秒杀商品的id。

```java
public Exposer exportSeckillUrl(Integer seckillId) {
        Seckill seckill = seckillMapper.queryById(seckillId);
        if (seckill == null)
        {
            return  new Exposer(false,seckillId);
        }
        Date startTieme = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if(nowTime.getTime() < startTieme.getTime()
                || nowTime.getTime() >endTime.getTime())
        //第一个判断条件是 秒杀未开始  第二个是秒杀已结束
        {
            return new Exposer(false,seckillId,nowTime.getTime(),startTieme.getTime(),endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return  new Exposer(true,md5,seckillId);
    }

    //设置盐值字符串，随便定义，用于混淆MD5值
    private final String salt = "sjajahjgnm00982jrfm;sd";

    //生成MD5值
    private String getMD5(Integer seckillId) {
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        //生成md5
        return md5;
    }
```

#### 测试   exportSeckillUrl ：

**正常得到秒杀地址**

![1565280458452](https://ws3.sinaimg.cn/large/006nELAQly1g6td6k11xpj30yo0b8jsi.jpg)

因为当前测试时间是在秒杀开始时间   并且早于结束时间的 ，所以可以得到秒杀地址的md5值，

**早于开始秒杀时间**

![1565280662869](https://wx1.sinaimg.cn/large/006nELAQly1g6td75rw7ij30uz0dbwg5.jpg)



更改数据库时间之后发现无法的到秒杀地址。



### executeSeckill 进行秒杀操作

#### 秒杀操作

```java
 SeckillExecution executeSeckill(Integer seckillId, String userPhone, String md5)
     throws SeckillException, RepeatKillException, SeckillCloseException;
```

`SeckillExecution`类也是一个封装类，用来返回秒杀之后的一些操作

```java
@Data
public class SeckillExecution {

    private Integer seckillId;

    //秒杀执行结果状态
    private int state;

    //状态表示
    private String stateInfo;

    //秒杀成功的订单对象
    private SuccessKilled successKilled;
    
        public SeckillExecution(Integer seckillId, SeckillStatEnum state, String stateInfo, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state.getState();
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }

    public SeckillExecution(Integer seckillId, SeckillStatEnum state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state.getState();
        this.stateInfo = stateInfo;
    }

    public SeckillExecution(Integer seckillId, SeckillStatEnum state, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state.getState();
        this.successKilled = successKilled;
    }
}
```

`SeckillStatEnum` 是一个枚举类，用来封装返回的相关信息。

```java
public enum SeckillStatEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据串改");

    private int state;
    private String stateInfo;
}
```



#### 具体实现：

@Transactional 是开启事务的注解。

```java
/**
 * 使用注解式事务方法的有优点：开发团队达成了一致约定，明确标注事务方法的编程风格
 * 使用事务控制需要注意：
 * 1.保证事务方法的执行时间尽可能短，不要穿插其他网络操作PRC/HTTP请求（可以将这些请求剥离出来）
 * 2.不是所有的方法都需要事务控制，如只有一条修改的操作、只读操作等是不需要进行事务控制的
 *
 * Spring默认只对运行期异常进行事务的回滚操作，对于编译异常Spring是不进行回滚的，所以对于需要进行事务控制的方法尽可能将可能抛出的异常都转换成运行期异常
 */
```

```java
@Transactional
    public SeckillExecution executeSeckill(Integer seckillId, String userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑：1.减库存；2.储存秒杀订单
        Date nowTime = new Date();
        try {
            int updateCount = seckillMapper.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新记录，秒杀结束
                throw new SeckillCloseException("seckill is closed");
            } else {
                int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }
            }
        } catch (SeckillCloseException e) {
            throw e;
        } catch (RepeatKillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常，转换为运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
```

#### 实际测试：

```java
    @Test
    public void executeSeckill() {
        String md5 = "05fd17ce7b3fb01e5c9fb08e4f7004c8";
        SeckillExecution seckillExecution = seckillService.executeSeckill(1,"111",md5);
        System.out.println(seckillExecution.toString());
//再次使用相同的手机号去秒杀的时候会报错   com.example.demo3.exception.RepeatKillException: seckill repeated
    }
```

测试的md5值要用上面生成的。

##### 第一次购买

![1565281277853](https://ws3.sinaimg.cn/large/006nELAQly1g6td7sst3ej314a0jvadh.jpg)

##### 用同样的手机号第二次购买

![1565281322414](https://ws3.sinaimg.cn/large/006nELAQly1g6td8aju2gj314b0grdir.jpg)



会报错，且数据库中没有插入新的订单

##### 修改秒杀地址会报错

![1565315593123](https://wx1.sinaimg.cn/large/006nELAQly1g6td8rhrcdj31450ih775.jpg)

会报秒杀数据修改的错误。

##### 用不同的手机号购买

![1565281405827](https://wx2.sinaimg.cn/large/006nELAQly1g6td96qahhj312a0j10vk.jpg)

可以继续进行购买，且数据库可以得到对应的信息。



### 联合测试

实际业务中需要将暴露秒杀地址与执行秒杀操作融为一体，所以还需要将两个业务合并。

```java
    @Test
    public void testSeckillLogic() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1);
        if (exposer.isExposed()) {
            Integer id = exposer.getSeckillId();
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(1,"1221111222", md5);
                System.out.println("秒杀开启");
            } catch (SeckillCloseException e) {
                System.out.println(e.getMessage());
            } catch (RepeatKillException e1) {
                System.out.println(e1.getMessage());
            }
        } else {
            //秒杀未开启	
            System.out.println("秒杀wei开启");
        }
    }
```

#### 时间合适：

![1565315024505](https://wx1.sinaimg.cn/large/006nELAQly1g6td9nzqqgj311p0fldho.jpg)

#### 未到秒杀时间：

![1565315134925](https://wx4.sinaimg.cn/large/006nELAQly1g6td9zoh7oj30ys0eiq4j.jpg)

#### 修改开始时间之后重新测试：

![1565315239693](https://ws1.sinaimg.cn/large/006nELAQly1g6tdadkp8zj31030fjjtw.jpg)







全部实现的代码：

```java
package com.example.demo3.service.impl;

import com.example.demo3.bean.Seckill;
import com.example.demo3.bean.SuccessKilled;
import com.example.demo3.dto.Exposer;
import com.example.demo3.dto.SeckillExecution;
import com.example.demo3.enums.SeckillStatEnum;
import com.example.demo3.exception.RepeatKillException;
import com.example.demo3.exception.SeckillCloseException;
import com.example.demo3.exception.SeckillException;
import com.example.demo3.mapper.SeckillMapper;
import com.example.demo3.mapper.SuccessKilledMapper;
import com.example.demo3.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : dk
 * @date : 2019/8/8 16:28
 * @description :
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //设置盐值字符串，随便定义，用于混淆MD5值
    private final String salt = "sjajahjgnm00982jrfm;sd";

    //生成MD5值
    private String getMD5(Integer seckillId) {
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        //生成md5
        return md5;
    }


    @Autowired
    SeckillMapper seckillMapper;
    @Autowired
    SuccessKilledMapper successKilledMapper;


    @Override
    /**
     * 得到所有秒杀记录
     */
    public List<Seckill> getSeckillList() {
        return seckillMapper.queryAll(1,9999);
    }


    @Override
    public Seckill getById(Integer seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(Integer seckillId) {
        Seckill seckill = seckillMapper.queryById(seckillId);
        if (seckill == null)
        {
            return  new Exposer(false,seckillId);
        }
        Date startTieme = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if(nowTime.getTime() < startTieme.getTime()
                || nowTime.getTime() >endTime.getTime())
        //第一个判断条件是 秒杀未开始  第二个是秒杀已结束
        {
            return new Exposer(false,seckillId,nowTime.getTime(),startTieme.getTime(),endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return  new Exposer(true,md5,seckillId);
    }
    /**
     * 使用注解式事务方法的有优点：开发团队达成了一致约定，明确标注事务方法的编程风格
     * 使用事务控制需要注意：
     * 1.保证事务方法的执行时间尽可能短，不要穿插其他网络操作PRC/HTTP请求（可以将这些请求剥离出来）
     * 2.不是所有的方法都需要事务控制，如只有一条修改的操作、只读操作等是不需要进行事务控制的
     *
     * Spring默认只对运行期异常进行事务的回滚操作，对于编译异常Spring是不进行回滚的，所以对于需要进行事务控制的方法尽可能将可能抛出的异常都转换成运行期异常
     */
    @Override
    @Transactional
    public SeckillExecution executeSeckill(Integer seckillId, String userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑：1.减库存；2.储存秒杀订单
        Date nowTime = new Date();
        try {
            int updateCount = seckillMapper.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新记录，秒杀结束
                throw new SeckillCloseException("seckill is closed");
            } else {
                int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }
            }
        } catch (SeckillCloseException e) {
            throw e;
        } catch (RepeatKillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常，转换为运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }

}

```

