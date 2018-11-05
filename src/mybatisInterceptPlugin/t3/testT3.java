package mybatisInterceptPlugin.t3;

public class testT3 {

	public static void main(String[] args) {
		//没有被拦截之前
	    Target target = new TargetImpl();
	    target.execute();  
	    
	    System.out.println("*******使用拦截器后：*******");
	    //拦截后
	   /* Interceptor interceptor =new myInterceptor();
	    target = (Target)TargetProxy.bind(target,interceptor);//客户端不需要和PROXY打交道，客户端只需要和拦截器打交道就行了，继续优化
	    target.execute();*/
	    
	    /*优化后
		 * |
		 * |
		 * |
		 * V
		 */
	    Interceptor interceptor =new myInterceptor();
	    target =(Target)interceptor.register(target);
	    System.out.println("*******使用拦截器拦截execute：*******");
	    target.execute();
	    System.out.println("*******使用拦截器拦截execute2*******");
	    target.execute2();
	    
	}
}
