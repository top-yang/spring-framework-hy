package aop.a1;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.BeanFactoryAdvisorRetrievalHelper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName: mycontext
 * @Description:
 * @Author
 * @Date 2022/11/07
 * @Version 1.0
 */

public class mycontext extends AnnotationConfigApplicationContext {

	public mycontext(Class<config> configClass) {
		super(configClass);
	}

	@Override
	protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
//		beanFactory.addBeanPostProcessor(new AnnotationAwareAspectJAutoProxyCreator());
//		AnnotationAwareAspectJAutoProxyCreator creator = new AnnotationAwareAspectJAutoProxyCreator();
//		beanFactory.addEmbeddedValueResolver(new BeanFactoryAdvisorRetrievalHelper());

		super.prepareBeanFactory(beanFactory);
	}

}
