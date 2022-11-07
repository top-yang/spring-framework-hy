package aop.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: B
 * @Description:
 * @Author
 * @Date 2022/11/07
 * @Version 1.0
 */
@Component
public class B {

	@Autowired
	Xxable a;//jdk动态代理生成的是接口类型 如果注入A类型会报错
	public void xx(){
		System.out.println("this is b xx");
	}
}
