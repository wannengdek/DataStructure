package mianshi;

/*
 * ����ʽ��
 * 	�ӳٴ������ʵ������
 * 
 * (1)������˽�л�
 * (2)��һ����̬�����������Ψһ��ʵ��
 * (3)�ṩһ����̬��������ȡ���ʵ������
 */
public class Singleton4 {
	private static Singleton4 instance;
	private Singleton4(){
		
	}
	public static Singleton4 getInstance(){
		if(instance == null){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			instance = new Singleton4();
		}
		return instance;
	}
}
