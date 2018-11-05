package mybatisInterceptPlugin.t2;

public class testT2 {

	public static void main(String[] args) {
		//没有被拦截之前
	    Target target = new TargetImpl();
	    target.execute();  
	    
	    System.out.println("**************");
	    //拦截后
	    Interceptor interceptor =new myInterceptor();
	    target = (Target)TargetProxy.bind(target,interceptor);
	    target.execute();
	}
}
