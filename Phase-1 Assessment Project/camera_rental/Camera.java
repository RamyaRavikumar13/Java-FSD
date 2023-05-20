package camera_rental;

public class Camera {

	
	    private int id;
	    private String brand;
	    private String model;
	    private double rentalPrice;
	    private boolean rented;

	    public Camera(int id, String brand, String model, double rentalPrice, boolean rented) {
	        this.id = id;
	        this.brand = brand;
	        this.model = model;
	        this.rentalPrice = rentalPrice;
	        this.rented = rented;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getBrand() {
	        return brand;
	    }

	    public String getModel() {
	        return model;
	    }

	    public double getRentalPrice() {
	        return rentalPrice;
	    }

	    public boolean isRented() {
	        return rented;
	    }

	    public void setRented(boolean rented) {
	        this.rented = rented;
	    }
	}


