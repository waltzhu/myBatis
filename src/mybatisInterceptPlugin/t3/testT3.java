package mybatisInterceptPlugin.t3;

public class testT3 {

	public static void main(String[] args) {
		//û�б�����֮ǰ
	    Target target = new TargetImpl();
	    target.execute();  
	    
	    System.out.println("*******ʹ����������*******");
	    //���غ�
	   /* Interceptor interceptor =new myInterceptor();
	    target = (Target)TargetProxy.bind(target,interceptor);//�ͻ��˲���Ҫ��PROXY�򽻵����ͻ���ֻ��Ҫ���������򽻵������ˣ������Ż�
	    target.execute();*/
	    
	    /*�Ż���
		 * |
		 * |
		 * |
		 * V
		 */
	    Interceptor interceptor =new myInterceptor();
	    target =(Target)interceptor.register(target);
	    System.out.println("*******ʹ������������execute��*******");
	    target.execute();
	    System.out.println("*******ʹ������������execute2*******");
	    target.execute2();
	    
	}
}
