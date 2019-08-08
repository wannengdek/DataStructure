# 数据结构与算法

<a href="https://github.com/wannengdek/DataStructure/blob/master/左神算法/第一章/第一章.md">
  1、左神算法第一章 简单排序、荷兰国旗问题、随机快速排序</a>

<a href="https://github.com/wannengdek/DataStructure/blob/master/左神算法/第二章/2.md">2、左神算法第二章 桶排序、O（1）得到栈中最小元素</a>

<a href="https://github.com/wannengdek/DataStructure/blob/master/左神算法/第三章/第三章.md">3、左神算法第三章 “回”字形打印矩阵、“之字”形打印矩阵</a>

<a href="https://github.com/wannengdek/DataStructure/blob/master/%E5%B7%A6%E7%A5%9E%E7%AE%97%E6%B3%95/%E7%AC%AC%E5%9B%9B%E7%AB%A0/%E7%AC%AC%E5%9B%9B%E7%AB%A0.md">4、左神算法第四章  找到数据源的中位数、二叉树的三序遍历的非递归实现</a>

<a href="https://github.com/wannengdek/DataStructure/blob/master/左神算法/第五章/第五章.md">5、左神算法第五章 </a>

# Spring Boot

<a href="https://github.com/wannengdek/DataStructure/blob/master/SpringBoot%20%E9%85%8D%E7%BD%AE/SpringBoot%2BMybatis%2BDruid%E6%95%B4%E5%90%88.md">
  1、SpringBoot+Mybatis整合.mdSpringBoot+Mybatis整合</a>

[2、SpringBoot配置redis](https://github.com/wannengdek/DataStructure/blob/master/SpringBoot%20%E9%85%8D%E7%BD%AE/SpringBoot%E9%85%8D%E7%BD%AEredis/SpringBoot%E9%85%8D%E7%BD%AEredis.md)



# 数据库优化



# JVM调优

<a href="https://github.com/wannengdek/DataStructure/blob/master/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3JVM/%E7%AC%AC%E4%B8%80%E7%AB%A0/%E7%AC%AC%E4%B8%80%E7%AB%A0.md">
第一章</a>

[第二章](https://github.com/wannengdek/DataStructure/blob/master/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3JVM/%E7%AC%AC%E4%BA%8C%E7%AB%A0/%E7%AC%AC%E4%BA%8C%E7%AB%A0.md)





```
@Select("select * from seckill where seckill_id = #{seckillId}")
Seckill queryById(@Param("seckillId") Integer seckillId);

List<Seckill> queryAll(@Param("offet")Integer offet , @Param("limit")Integer limit);
```





```
SuccessKilled queryByIdWithSeckill();
```





```
<select id="queryById" resultType="springboot.seckill.bean.Seckill">
  select * from seckill where seckill_id = #{seckillId}
</select>

<select id="queryAll" resultType="springboot.seckill.bean.Seckill">
  select * from seckill
  order by create_time desc limit #{offset},#{limit}
</select>
```





```
  <insert id="insertSuccessKilled" >

    insert ignore into success_killed (seckill_id,user_phone)
    values (#{seckillId},#{userPhone})
  </insert>
<!--   主键冲突，报错   返回0 -->
  <select id="queryByIdWithSeckill" resultType="springboot.seckill.bean.SuccessKilled">
    select
        sk.seckill_id,
        sk.user_phone,
        sk.create_time,
        sk.state,
        s.seckill_id "seckill.seckill_id",
        s.name "seckill.name",
        s.number "seckill.number",
        s.start_time "seckill.start_time",
        s.end_time "seckill.end_time",
        s.create_time "seckill.create_time"
    from  success_killed sk
    inner join seckil s on sk.seckill_id = s.seckill_id
    where sk.seckill_id = #{seckillId}
  </select>
<!--  根据id 查询 SuccessKilled 并携带秒杀产品对象实体      -->
```

