package mianshi;

/*
 * 饿汉式：
 * 	在类初始化时直接创建实例对象，不管你是否需要这个对象都会创建
 *
 * （1）构造器私有化
 * （2）自行创建，并且用静态变量保存
 * （3）向外提供这个实例
 * （4）强调这是一个单例，我们可以用final修改
 */
public class Singleton1 {
	public static final Singleton1 INSTANCE = new Singleton1();
	private Singleton1(){
		
	}
	public static void test()
	{
		System.out.println("调用类名.方法时      系统在加载并初始化这个类时就加载了 static 常量，所以会直接调用 Sington1");
	}
}
