package mybatisInterceptPlugin.t1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

	
	private Object target;
    private TargetProxy(Object target) {
        this.target = target;
    }
    //����һ��Ŀ�����Ĵ������
    public static Object bind(Object target) {
        return Proxy.newProxyInstance(target.getClass() .getClassLoader(),
                					  target.getClass().getInterfaces(),
                					  new TargetProxy(target)
        							  );
    }
    //��ִ��Ŀ����󷽷�ǰ�����Լ��������߼�
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//��ע�� �����߼�д���ڴ������У��ͻ����޷��������
		System.out.println("Begin");
        return method.invoke(target, args);
	}

}
 
