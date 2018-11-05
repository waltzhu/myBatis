package mybatisInterceptPlugin.t1;

public class testT1 {

	public static void main(String[] args) {
		//没有被拦截之前
	    Target target = new TargetImpl();
	    target.execute();  
	    
	    System.out.println("**************");
	    //拦截后
	    target = (Target)TargetProxy.bind(target);
	    target.execute();
	}
}
