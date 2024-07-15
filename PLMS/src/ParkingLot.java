import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	String parkingLotID;
	List<List<Slot>> slots;

	public ParkingLot(String parkingLotID, int nfloors, int noOfSlotsOerFlr) {
		this.parkingLotID = parkingLotID;
		slots = new ArrayList<>();
		for (int i = 0; i < nfloors; i++) {
			slots.add(new ArrayList<>());
			List<Slot> floorSlots = slots.get(i);
			floorSlots.add(new Slot("truck"));
			floorSlots.add(new Slot("bike"));
			floorSlots.add(new Slot("bike"));

			for (int j = 3; j < noOfSlotsOerFlr; j++) {
				slots.get(i).add(new Slot("car"));
			}
		}
	}
	
	public String parkVehicle(String type, String regNO, String color) {
		   
		
		return "return";
	}
}
