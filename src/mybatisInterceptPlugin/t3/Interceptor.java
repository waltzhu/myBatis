package mybatisInterceptPlugin.t3;

import java.lang.annotation.Retention;
import java.lang.reflect.Method;

public interface Interceptor {
    //��һ���Ż�public void interceptor(Method method,Object[] args);
	public Object interceptor(Invocation invocation) throws Exception;
	
	public Object register(Object target);
}
