package aop.a1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: aspect
 * @Description:
 * @Author
 * @Date 2022/11/07
 * @Version 1.0
 */
@Component
@Aspect
public class aspect {

	@Pointcut("execution(* xx())")
	public void pointcut(){

	}

	@Before("pointcut()")
	public void before(){
		System.out.println("before...");
	}

	@After("pointcut()")
	public void after(){
		System.out.println("after");
	}



}
