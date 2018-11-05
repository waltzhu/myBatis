package mybatisInterceptPlugin.t1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

	
	private Object target;
    private TargetProxy(Object target) {
        this.target = target;
    }
    //生成一个目标对象的代理对象
    public static Object bind(Object target) {
        return Proxy.newProxyInstance(target.getClass() .getClassLoader(),
                					  target.getClass().getInterfaces(),
                					  new TargetProxy(target)
        							  );
    }
    //在执行目标对象方法前加上自己的拦截逻辑
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//备注： 拦截逻辑写死在代理类中，客户端无法灵活配置
		System.out.println("Begin");
        return method.invoke(target, args);
	}

}
 
