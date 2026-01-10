package web.controller;

import web.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

	private final CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars")
	public String getCars(@RequestParam(value = "count", required = false, defaultValue = "5")
	                          int count, Model model) {
		model.addAttribute("cars", carService.getCarsByCount(count));
		return "cars";
	}
}