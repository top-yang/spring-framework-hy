package IOC_Bean.c3;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @ClassName: ComponentB
 * @Description:
 * @Author
 * @Date 2022/11/05
 * @Version 1.0
 */
public class ComponentB implements hyIComponent, BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("ComponentB aware;");
	}
}
