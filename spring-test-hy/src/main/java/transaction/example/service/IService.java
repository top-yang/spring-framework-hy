package transaction.example.service;

import org.apache.ibatis.annotations.*;
import transaction.example.model.User;

import java.util.List;

public interface IService {
	User getUserByid(Long id);





	int insertUser(User user);


	int updateUser(User user);


	int deleteUser(User user);


	List<User> selectAll();


	void testNoTransaction();

	void AllUSer();
}
