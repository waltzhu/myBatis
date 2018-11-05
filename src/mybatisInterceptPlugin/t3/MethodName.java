package mybatisInterceptPlugin.t3;
 
import java.lang.annotation.*;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MethodName {
	 public String value();
}
