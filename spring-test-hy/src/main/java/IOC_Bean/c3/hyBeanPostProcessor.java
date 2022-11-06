package IOC_Bean.c3;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @ClassName: hyBeanPostProcessor
 * @Description:
 * @Author
 * @Date 2022/11/05
 * @Version 1.0
 */
public class hyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {



	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if (beanName.equals("hhz"))
			System.out.println("<<<<<< 销毁之前执行, 如 @PreDestroy");
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		for (Class<?> anInterface : beanClass.getInterfaces()) {
			if(anInterface.equals(hyIComponent.class)){
				System.out.println(beanName+"<<<<<< 实例化之前执行, 这里返回的对象会替换掉原本的 bean");
			}
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if (beanName.equals("hhz")) {
			System.out.println("<<<<<< 实例化之后执行, 这里如果返回 false 会跳过依赖注入阶段");

		}
		return true;
	}


	/**
	 * 拓展较多
	 * @param pvs
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		if (beanName.equals("hhz"))
			System.out.println("<<<<<< 依赖注入阶段执行,(通常拓展该方法) 如 @Autowired、@Value、@Resource");
		return pvs;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("hhz"))
			System.out.println("<<<<<< 初始化之前执行, 这里返回的对象会替换掉原本的 bean, 如 @PostConstruct、@ConfigurationProperties");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("hhz"))
			System.out.println("<<<<<< 初始化之后执行, 这里返回的对象会替换掉原本的 bean, 如代理增强");
		return bean;
	}
}
