package mybatisInterceptPlugin.t2;

public class testT2 {

	public static void main(String[] args) {
		//û�б�����֮ǰ
	    Target target = new TargetImpl();
	    target.execute();  
	    
	    System.out.println("**************");
	    //���غ�
	    Interceptor interceptor =new myInterceptor();
	    target = (Target)TargetProxy.bind(target,interceptor);
	    target.execute();
	}
}
