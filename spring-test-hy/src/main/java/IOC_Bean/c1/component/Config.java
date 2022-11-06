package IOC_Bean.c1.component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: Config
 * @Description:
 * @Author
 * @Date 2022/11/04
 * @Version 1.0
 */
@ComponentScan
@Configuration
public class Config implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println(name);
	}
}
