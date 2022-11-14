package transaction.example.mapper;

import org.apache.ibatis.annotations.*;
import transaction.example.model.User;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description:
 * @Author
 * @Date 2022/11/09
 * @Version 1.0
 */

@Mapper
public interface UserMapper {

	@Select("select * from user where id = #{id}")
	User getUserById(@Param("id") Long id);

	@Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
	int insertUser(User user);

	@Update("update user set name = #{name},pwd = #{pwd} where id = #{id}")
	int updateUser(User user);

	@Delete("delete from user where id = #{id}")
	int deleteUser(User user);

	@Select("select * from user")
	List<User> selectAll();

}
