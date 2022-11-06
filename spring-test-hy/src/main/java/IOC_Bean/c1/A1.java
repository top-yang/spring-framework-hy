package IOC_Bean.c1;

import IOC_Bean.c1.component.Config;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: A1
 * @Description:
 * @Author
 * @Date 2022/11/04
 * @Version 1.0
 */
public class A1 {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}


	}




}
