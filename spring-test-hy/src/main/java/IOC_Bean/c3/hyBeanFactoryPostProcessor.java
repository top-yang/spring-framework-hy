package IOC_Bean.c3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * @ClassName: hyBeanFactoryPostProcessor
 * @Description:
 * @Author
 * @Date 2022/11/06
 * @Version 1.0
 */
public class hyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
			if(beanDefinition instanceof AbstractBeanDefinition){
				System.out.println("BeanFactoryProcessor在beanFactory加载完BeanDefinition后，可以修改bd"+beanDefinition);
			}
		}
	}
}
