package mybatisInterceptPlugin.t3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

	
	private Object target;
	private Interceptor interceptor;
    private TargetProxy(Object target,Interceptor interceptor) {
        this.target = target;
        this.interceptor=interceptor;
    }
    //生成一个目标对象的代理对象
    public static Object bind(Object target,Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass() .getClassLoader(),
                					  target.getClass().getInterfaces(),
                					  new TargetProxy(target,interceptor)
        							  );
    }
    //在执行目标对象方法前加上自己的拦截逻辑
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//添加选择方法过滤拦截
		MethodName methodName = this.interceptor.getClass().getAnnotation(MethodName.class);
		  String name = methodName.value();
	      if (name.equals(method.getName())){
	    	  //进一步优化interceptor.interceptor(method,args);//为了过滤一些方法，传递一些参数，所以传进去
	    	  return interceptor.interceptor(new Invocation(target, method, args));
	      }
		
		
		/*
		 * 既然拦截逻辑，关联了方法，参数，而代理类初衷就是织入拦截逻辑，所以可以把真正方法执行也放到拦截逻辑里。
		 * 因为：代理类也不想管原始方法执行
		 * 操作：需要多传一个target进去，所以考虑封装类
		 * 
		 */
        return method.invoke(target, args);//正常调用
	}

}
 
