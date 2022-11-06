package IOC_Bean.FactoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: CarFactoryBean
 * @Description: 工厂bean,针对复杂car创建所做的扩展
 * @Author
 * @Date 2022/11/06
 * @Version 1.0
 */
public class CarFactoryBean implements FactoryBean<Car> {

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	private String carInfo;

	@Override
	public Car getObject() throws Exception {
		System.out.println("调用CarFactoryBean的getObject方法");
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
