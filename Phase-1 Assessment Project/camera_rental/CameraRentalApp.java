package camera_rental;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class CameraRentalApp {
	    private static User currentUser;
	    private static List<Camera> cameraList;

	    public static void main(String[] args) {
	        initialize();
	        showWelcomeScreen();
	        login();
	        showMainMenu();
	    }

	    private static void initialize() {
	        currentUser = null;
	        cameraList = new ArrayList<>();
	        cameraList.add(new Camera(1, "NIKON", "DSLR", 800.0, false));
	        cameraList.add(new Camera(2, "Sony", "DSLR12", 500.0, false));
	        cameraList.add(new Camera(3, "Samsung", "SM123", 900.0, false));
	        cameraList.add(new Camera(4, "LG", "L123", 600.0, false));
	        cameraList.add(new Camera(5, "Chroma", "CT", 700.0, false));

	    }

	    private static void showWelcomeScreen() {
	    	System.out.println("\n+----------------------------------+");
	        System.out.println("|   WELCOME TO CAMERA RENTAL APP   |");
	    	System.out.println("+----------------------------------+\n");
	        System.out.println("PLEASE LOGIN TO CONTINUE");
	    }

	    private static void login() {
	        Scanner scanner = new Scanner(System.in);
	        String username;
	        String password;

	        do {
	            System.out.print("USERNAME: ");
	            username = scanner.nextLine();
	            System.out.print("PASSWORD: ");
	            password = scanner.nextLine();
	        } while (!isValidLogin(username, password));

	        System.out.println("\nLogin Successful.");
	    }

	    private static boolean isValidLogin(String username, String password) {
	        if (username.equals("LR") && password.equals("2113")) {
	        	currentUser = new User(username, password);
	        	return true;
	        } 
	        else {
	        	System.out.println("\nInvalid username or password. Please try again.\n");
	        	return false;
	        }
	    }
	    private static void showMainMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	        	System.out.println("\n1. MY CAMERA");
	            System.out.println("2. RENT A CAMERA");
	            System.out.println("3. VIEW ALL CAMERAS");
	            System.out.println("4. MY WALLET");
	            System.out.println("5. EXIT");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    showMyCameraMenu();
	                    break;
	                case 2:
	                    rentCamera();
	                    break;
	                case 3:
	                    viewAllCameras();
	                    break;
	                case 4:
	                    showWalletMenu();
	                    break;
	                case 5:
	                    System.out.println("Thank you for using the Camera Rental App. Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (true);
	    }

	    private static void showMyCameraMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n1. ADD");
	            System.out.println("2. REMOVE");
	            System.out.println("3. VIEW MY CAMERAS");
	            System.out.println("4. GO TO PREVIOUS MENU");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    addCamera();
	                    break;
	                case 2:
	                    removeCamera();
	                    break;
	                case 3:
	                    viewMyCameras();
	                    break;
	                case 4:
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (true);
	    }

	    private static void addCamera() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("\nENTER THE CAMERA BRAND: ");
	        String brand = scanner.nextLine();
	        System.out.print("ENTER THE MODEL: ");
	        String model = scanner.nextLine();
	        System.out.print("ENTER THE PER DAY PRICE(INR): ");
	        double rentalPrice = scanner.nextDouble();

	        int nextId = cameraList.size() + 1;
	        Camera camera = new Camera(nextId, brand, model, rentalPrice, false);
	        cameraList.add(camera);

	        System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
	    }

	    private static void removeCamera() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("===============================================================================");
	        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
	        System.out.println("===============================================================================");
	        for (Camera camera : cameraList) {
	            System.out.println(camera.getId() + "\t\t" + 
	                               camera.getBrand() + "\t\t" +
	                               camera.getModel() + "\t\t" + 
	                               camera.getRentalPrice() + "\t\t" +
	                              (camera.isRented() ? "Rented" : "Available"));
	        }
	        System.out.println("===============================================================================");
	        System.out.print("\nENTER THE CAMERA ID TO REMOVE: ");
	        int cameraID=scanner.nextInt();
			scanner.nextLine();
			boolean removed = false;
			for(Camera camera: cameraList) {
				if(camera.getId()==cameraID) {
					cameraList.remove(camera);
					removed = true;
					break;
				}
			}
			if(removed) {
				System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
			}
			else {
				System.out.println("CAMERA NOT FOUND.");
			}
		}

	    private static void viewMyCameras() {
	        List<Camera> cameraList = currentUser.getCameraList();

	        System.out.println("\nMY CAMERAS");
	        System.out.println("===============================================================================");
	        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
	        System.out.println("===============================================================================");

	        boolean foundRentedCamera = false;
	        for (Camera camera : cameraList) {
	            if (camera.isRented()) {
	                System.out.println(camera.getId()+ "\t\t" + 
	                                   camera.getBrand()+ "\t\t" + 
	                		           camera.getModel()+ "\t\t" +
	                                  (camera.getRentalPrice()+ "\t\t" + "Rented"));
	                foundRentedCamera = true;
	            }
	        }

	        if (!foundRentedCamera) {
	            System.out.println("No rented cameras found.");
	        }

	        System.out.println("===============================================================================");
	    }
	    private static void rentCamera() {
	    	
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\nFollowing is the list of available cameras");
	        System.out.println("===============================================================================");
	        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
	        System.out.println("===============================================================================");
	        for (Camera camera : cameraList) {
	            if (!camera.isRented()) {
	                System.out.println(camera.getId() + "\t\t" + 
	                                   camera.getBrand() + "\t\t" +
	                                   camera.getModel() + "\t\t" + 
	                                   camera.getRentalPrice() + "\t\t" +
	                                  (camera.isRented() ? "Rented" : "Available"));
	            }
	        }
	        System.out.println("===============================================================================");

	        System.out.print("\nENTER THE CAMERA ID YOU WANT TO RENT: ");
	        int cameraId = scanner.nextInt();

	        Camera selectedCamera = null;
	        for (Camera camera : cameraList) {
	            if (camera.getId() == cameraId) {
	                selectedCamera = camera;
	                break;
	            }
	        }

	        if (selectedCamera != null && !selectedCamera.isRented()) {
	            if (currentUser.getWalletBalance() >= selectedCamera.getRentalPrice()) {
	                selectedCamera.setRented(true);
	                currentUser.getCameraList().add(selectedCamera);
	                currentUser.depositToWallet(-selectedCamera.getRentalPrice());
	                System.out.println("YOUR TRANSACTION FOR CAMERA - " + selectedCamera.getBrand() +
	                        " " + selectedCamera.getModel() + " with rent INR." +
	                        selectedCamera.getRentalPrice() + " HAS SUCCESSFULLY COMPLETED.");
	            } else {
	                System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. " +
	                        "PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
	            }
	        } else {
	            System.out.println("ERROR: INVALID CAMERA ID OR CAMERA IS ALREADY RENTED.");
	        }
	    }

	    private static void viewAllCameras() {
	    	System.out.println("===============================================================================");
	        System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(PER DAY)\tSTATUS");
	        System.out.println("===============================================================================");
	        for (Camera camera : cameraList) {
	            System.out.println(camera.getId() + "\t\t" + 
	                               camera.getBrand() + "\t\t" +
	                               camera.getModel() + "\t\t" + 
	                               camera.getRentalPrice() + "\t\t" +
	                              (camera.isRented() ? "Rented" : "Available"));
	        }
	        System.out.println("===============================================================================");
	    }

	    private static void showWalletMenu() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\nOUR CURRENT WALLET BALANCE IS INR." + currentUser.getWalletBalance());
	        System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? (1.YES 2.NO): ");
	        int choice = scanner.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.print("ENTER THE AMOUNT (INR): ");
	                double amount = scanner.nextDouble();
	                currentUser.depositToWallet(amount);
	                System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR." +
	                        currentUser.getWalletBalance());
	                break;
	            case 2:
	                break;
	            default:
	                System.out.println("Invalid choice. Going back to previous menu.");
	                break;
	        }
	    }

	    private static void exit() {
	        System.out.println("Thank you for using the Camera Rental App. Exiting...");
	        System.exit(0);
	    }
	}


