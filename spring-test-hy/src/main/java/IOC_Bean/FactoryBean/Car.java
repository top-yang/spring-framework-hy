package IOC_Bean.FactoryBean;

/**
 * @ClassName: Car
 * @Description:
 * @Author
 * @Date 2022/11/06
 * @Version 1.0
 */
public class Car {
	private int maxSpeed;
	private String brand;
	private double price;

	public Car() {
		System.out.println("调用car的构造函数");
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
