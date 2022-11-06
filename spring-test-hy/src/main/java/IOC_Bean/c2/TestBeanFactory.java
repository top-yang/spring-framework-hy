package IOC_Bean.c2;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

/**
 * @ClassName: TestBeanFactory
 * @Description:
 * @Author
 * @Date 2022/10/26
 * @Version 1.0
 */
public class TestBeanFactory {

	protected static final Log logger = LogFactory.getLog(TestBeanFactory.class);

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        /*
        bean的定义
        class,scope,初始化，销毁
         */
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        beanFactory.registerBeanDefinition("config",beanDefinition);
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
		System.out.println("------注入BeanFactory后置处理器------");
		AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		System.out.println("------------");
		//getBeansOfType底层会初始化实现BeanFactoryPostProcessor的bean
		Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		beansOfType.values().forEach(
				beanFactoryPostProcessor -> {
					beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
				}
		);

		//注册BeanPostProcessor 触发, 使得@Autowired, @Resource等一些注解生效
		Map<String, BeanPostProcessor> beansOfType1 = beanFactory.getBeansOfType(BeanPostProcessor.class);


		beansOfType1.values().forEach(
				beanPostProcessor -> {
					System.out.println(">>>>"+beanPostProcessor);
					beanFactory.addBeanPostProcessor(beanPostProcessor);
				}
		);
		System.out.println("------注入Bean后置处理器------");
		for (BeanPostProcessor beanPostProcessor : beanFactory.getBeanPostProcessors()) {
			System.out.println(beanPostProcessor);
		}
		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		System.out.println("------------");
		System.out.println(beanFactory.getBean(Bean1.class).getBean2());

	}

    @Configuration
    static class Config{

        @Bean
        public Bean1 bean1(){
            return new Bean1();
        }


        @Bean
        public Bean2 bean2(){
            return new Bean2();
        }


        @Bean
        public Bean3 bean3() {
            return new Bean3();
        }

        @Bean
        public Bean4 bean4() {
            return new Bean4();
        }
    }

    interface Inter {

    }

    static class Bean3 implements Inter {

    }

    static class Bean4 implements Inter {

    }


    static class Bean1{
        public Bean1(){
            System.out.println("构造Bean1()");
        }

        @Autowired
        private Bean2 bean2;


        public Bean2 getBean2() {
            return bean2;
        }


        @Autowired
        private Inter bean3;

        public Inter getInter() {
            return bean3;
        }
    }

    static class Bean2{


        public Bean2(){
            System.out.println("构造Bean2()");
        }
    }



}
