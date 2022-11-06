package IOC_Bean.c1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ComponentB
 * @Description:
 * @Author
 * @Date 2022/11/04
 * @Version 1.0
 */
@Component
public class ComponentB {


	@Autowired
	ComponentA componentA;
}
