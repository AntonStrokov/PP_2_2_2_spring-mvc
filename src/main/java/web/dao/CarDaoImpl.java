package web.dao;

import web.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

	private final List<Car> cars;

	public CarDaoImpl() {
		cars = new ArrayList<>();
		cars.add(new Car(1L, "Toyota Camry", 50));
		cars.add(new Car(2L, "BMW X5", 30));
		cars.add(new Car(3L, "Audi A6", 40));
		cars.add(new Car(4L, "Mercedes-Benz C-Class", 60));
		cars.add(new Car(5L, "Ford Focus", 20));
	}

	@Override
	public List<Car> getAllCars() {
		return new ArrayList<>(cars);
	}

	@Override
	public List<Car> getCarsByCount(int count) {
		if (count <= 0) {
			return new ArrayList<>();
		}

		return cars.stream()
				.limit(count)
				.collect(Collectors.toList());
	}
}