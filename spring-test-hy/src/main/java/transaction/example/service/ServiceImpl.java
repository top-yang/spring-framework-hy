package transaction.example.service;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import transaction.example.mapper.UserMapper;
import transaction.example.model.User;

import java.util.List;
import java.util.Random;

/**
 * @ClassName: ServiceImpl
 * @Description:
 * @Author
 * @Date 2022/11/09
 * @Version 1.0
 */
@Service
public class ServiceImpl implements IService {


	@Autowired
	IService service;

	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public User getUserByid(Long id){
		return userMapper.getUserById(id);
	}

	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return userMapper.deleteUser(user);
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	//没有事务的情况下，先插入正常id，再插入异常id，正常id插入成功
	//有事务的情况下，插入的正常id会回滚。
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void testNoTransaction(){
		System.out.println("插入正常id前:");
		AllUSer();//当AllUser传播级别为never时,会抛异常
		insert(null);
		AllUSer();//这种
		try {
			insert(Long.MAX_VALUE);
		} catch (Exception e) {
			System.out.println("异常被自行处理，不抛出");
			System.out.println(e.getMessage());
			throw e;
		}
		AllUSer();
	}




	public void insert(Long id){
		User user = new User();
		if(id != null){
			user.setId(id);
		}else {
			user.setId((long) new Random().nextInt(100000));
		}
		user.setName(String.valueOf(System.currentTimeMillis()));
		user.setPwd("123456");
		service.insertUser(user);
	}

	@Transactional(propagation = Propagation.NEVER)//当前存在事务时，抛出异常
	public void AllUSer(){
		List<User> users = service.selectAll();//用this事务会失效
		System.out.println(users);
	}

}
