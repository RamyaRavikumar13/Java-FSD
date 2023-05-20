package camera_rental;



	import java.util.ArrayList;
	import java.util.List;

	 class User {
	    private String username;
	    private String password;
	    private List<Camera> cameraList;
	    private double walletBalance;

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	        this.cameraList = new ArrayList<>();
	        this.walletBalance = 400.0;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public List<Camera> getCameraList() {
	        return cameraList;
	    }

	    public double getWalletBalance() {
	        return walletBalance;
	    }

	    public void addCamera(Camera camera) {
	        cameraList.add(camera);
	    }

	    public void removeCamera(int cameraId) {
	        Camera camera = getCameraById(cameraId);
	        if (camera != null) {
	            cameraList.remove(camera);
	        }
	    }

	    public Camera getCameraById(int cameraId) {
	        for (Camera camera : cameraList) {
	            if (camera.getId() == cameraId) {
	                return camera;
	            }
	        }
	        return null;
	    }

	    public void depositToWallet(double amount) {
	        walletBalance += amount;
	    }
	}

