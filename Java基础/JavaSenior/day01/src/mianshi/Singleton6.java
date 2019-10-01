package mianshi;

/*
 * ���ڲ��౻���غͳ�ʼ��ʱ���Ŵ���INSTANCEʵ������
 * ��̬�ڲ��಻���Զ������ⲿ��ļ��غͳ�ʼ������ʼ��������Ҫ����ȥ���غͳ�ʼ���ġ�
 * ��Ϊ�����ڲ�����غͳ�ʼ��ʱ�������ģ�������̰߳�ȫ��
 */
public class Singleton6 {
	private Singleton6(){
		
	}
	private static class Inner{
		private static final Singleton6 INSTANCE = new Singleton6();
	}
	
	public static Singleton6 getInstance(){
		return Inner.INSTANCE;
	}
}
