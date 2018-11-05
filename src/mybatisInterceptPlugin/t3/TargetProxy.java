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
		//���ѡ�񷽷���������
		MethodName methodName = this.interceptor.getClass().getAnnotation(MethodName.class);
		  String name = methodName.value();
	      if (name.equals(method.getName())){
	    	  //��һ���Ż�interceptor.interceptor(method,args);//Ϊ�˹���һЩ����������һЩ���������Դ���ȥ
	    	  return interceptor.interceptor(new Invocation(target, method, args));
	      }
		
		
		/*
		 * ��Ȼ�����߼��������˷���������������������Ծ���֯�������߼������Կ��԰���������ִ��Ҳ�ŵ������߼��
		 * ��Ϊ��������Ҳ�����ԭʼ����ִ��
		 * ��������Ҫ�ഫһ��target��ȥ�����Կ��Ƿ�װ��
		 * 
		 */
        return method.invoke(target, args);//��������
	}

}
 
