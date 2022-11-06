package IOC_Bean.c3;

import IOC_Bean.c2.TestBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName: A3
 * @Description:
 * @Author
 * @Date 2022/11/05
 * @Version 1.0
 */
public class A3 {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.addBeanPostProcessor(new hyBeanPostProcessor());
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(ComponentA.class).setScope("singleton").getBeanDefinition();
		beanFactory.registerBeanDefinition("hhz",beanDefinition);
		AbstractBeanDefinition beanDefinitionB = BeanDefinitionBuilder.genericBeanDefinition(ComponentB.class).setScope("singleton").getBeanDefinition();
		beanFactory.registerBeanDefinition("hhz2",beanDefinitionB);
		new hyBeanFactoryPostProcessor().postProcessBeanFactory(beanFactory);
		ComponentA bean = beanFactory.getBean(ComponentA.class);
		ComponentB beanB = beanFactory.getBean(ComponentB.class);
		System.out.println(bean);
	}
}
