package mybatisInterceptPlugin.t1;

public class testT1 {

	public static void main(String[] args) {
		//û�б�����֮ǰ
	    Target target = new TargetImpl();
	    target.execute();  
	    
	    System.out.println("**************");
	    //���غ�
	    target = (Target)TargetProxy.bind(target);
	    target.execute();
	}
}
