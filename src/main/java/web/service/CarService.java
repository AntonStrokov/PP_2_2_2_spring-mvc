package web.service;

import web.dao.CarDao;
import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

	private final CarDao carDao;

	@Autowired
	public CarService(CarDao carDao) {
		this.carDao = carDao;
	}

	public List<Car> getCarsByCount(int count) {
		return carDao.getCarsByCount(count);
	}
}