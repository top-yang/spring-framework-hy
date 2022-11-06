package IOC_Bean.c1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ComponentA
 * @Description:
 * @Author
 * @Date 2022/11/04
 * @Version 1.0
 */
@Component
public class ComponentA {


	@Autowired
	ComponentB b;
}
