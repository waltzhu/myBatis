package mybatisInterceptPlugin.t3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
	private Object target;
    private Method method;
    private Object[] args;
    /*
     * 设置Private
    *将自己成员变量的操作尽量放到自己内部，不需要Interceptor获得自己的成员变量再去操作它们，
    *除非这样的操作需要Interceptor的其他支持。然而这儿不需要。
    */
    
    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }
   
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, args);
    }
    public Object getTarget() {
        return target;
    }
    public void setTarget(Object target) {
        this.target = target;
    }
    public Method getMethod() {
        return method;
    }
    public void setMethod(Method method) {
        this.method = method;
    }
    public Object[] getArgs() {
        return args;
    }
    public void setArgs(Object[] args) {
        this.args = args;
    }
}
