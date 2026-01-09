package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

	private List<Car> cars;

	public CarService() {
		cars = new ArrayList<>();
		cars.add(new Car(1L, "Toyota Camry", 50));
		cars.add(new Car(2L, "BMW X5", 30));
		cars.add(new Car(3L, "Audi A6", 40));
		cars.add(new Car(4L, "Mercedes-Benz C-Class", 60));
		cars.add(new Car(5L, "Ford Focus", 20));
	}

	public List<Car> getCars(int count) {
		if (count >= 5 || count <= 0) {
			return cars;
		}
		return cars.subList(0, count);
	}
}