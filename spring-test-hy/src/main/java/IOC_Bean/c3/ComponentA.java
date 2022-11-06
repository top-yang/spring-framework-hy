package IOC_Bean.c3;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName: ComponentA
 * @Description:
 * @Author
 * @Date 2022/11/05
 * @Version 1.0
 */
public class ComponentA implements InitializingBean, BeanNameAware,hyIComponent{

	private String name;


	public ComponentA(){
		System.out.println("调用ComponentA的构造方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("定义了ComponentA初始化方法"+name);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("设置BeanName");
	}
}
