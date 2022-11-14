package transaction.example.model;

/**
 * @ClassName: User
 * @Description:
 * @Author
 * @Date 2022/11/09
 * @Version 1.0
 */
public class User {


	private Long id;

	private String name;

	private String pwd;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				'}';
	}
}
