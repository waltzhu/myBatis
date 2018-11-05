package mybatisInterceptPlugin.t2;

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
    //����һ��Ŀ�����Ĵ������
    public static Object bind(Object target,Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass() .getClassLoader(),
                					  target.getClass().getInterfaces(),
                					  new TargetProxy(target,interceptor)
        							  );
    }
    //��ִ��Ŀ����󷽷�ǰ�����Լ��������߼�
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		interceptor.interceptor();
        return method.invoke(target, args);
	}

}
 
