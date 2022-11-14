package transaction.service;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.example.model.User;
import transaction.example.service.IService;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName: Test
 * @Description:
 * @Author
 * @Date 2022/11/09
 * @Version 1.0
 */
public class Test {

	@org.junit.jupiter.api.Test
	public void testTransaction(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis-config.xml");
		IService service = (IService) context.getBean("serviceImpl");
		service.testNoTransaction();
	}



	@org.junit.jupiter.api.Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis-config.xml");
		IService service = (IService) context.getBean("serviceImpl");


		User userByid = service.getUserByid(1L);
		System.out.println(userByid.getName()+"----ps:"+userByid.getPwd());


		AllUSer(service);

		insert(service);

		AllUSer(service);

	}

	private int insert(IService service){
		User user = new User();
		user.setId((long) new Random().nextInt(100000));
		user.setName(String.valueOf(System.currentTimeMillis()));
		user.setPwd("123456");
		return service.insertUser(user);
	}

	private void AllUSer(IService service){
		List<User> users = service.selectAll();
		System.out.println(users);
	}
}
