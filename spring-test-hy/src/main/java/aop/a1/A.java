package aop.a1;

import org.springframework.stereotype.Component;

/**
 * @ClassName: A
 * @Description:
 * @Author
 * @Date 2022/11/07
 * @Version 1.0
 */
@Component
public class A implements Xxable{
	@Override
	public void xx() {
		System.out.println("this is a xx");
	}
}
