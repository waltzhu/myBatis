package mybatisInterceptPlugin.t3;


@MethodName("execute")
public class myInterceptor implements Interceptor{

/*	@Override
	public void interceptor(Method method,Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("this is myInterceptor work......");
		System.out.println("Begin");
	}*/
	
	/*”≈ªØ∫Û
	 * |
	 * |
	 * |
	 * V
	 */
	
	@Override
	public Object interceptor(Invocation invocation) throws Exception  {
		// TODO Auto-generated method stub
		System.out.println("this is myInterceptor work......");
		System.out.println("Begin");
		return invocation.proceed();
	}

	@Override
	public Object register(Object target) {
		return TargetProxy.bind(target, this);
	}

}
