
public class Main {

	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot("PL123", 2, 5);
		String ticket = lot.parkVehicle("car", "ABC123", "Red");
		if (ticket != null) {
			System.out.println("Vehicle parked with ticket ID: " + ticket);
		} else {
			System.out.println("No available slot for the vehicle.");
		}

	}

}
