package aop.a1;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName: a1
 * @Description:
 * @Author
 * @Date 2022/11/07
 * @Version 1.0
 */
public class a1 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		Xxable a = (Xxable) context.getBean("a");
		B b = (B) context.getBean("b");
		a.xx();
		b.xx();
	}
}
