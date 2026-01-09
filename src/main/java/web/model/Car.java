package web.model;

public class Car {
	private Long id;
	private String model;
	private int series;

	public Car(Long id, String model, int series) {
		this.id = id;
		this.model = model;
		this.series = series;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}
}