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

		Vehicle vehicle = new Vehicle("TempType", "TempRegNo", "TempColor");

		for (int i = 0; i < slots.size(); i++) {
			for (int j = 0; j < slots.size(); j++) {
				Slot slot = slots.get(i).get(j);
				if (slot.type == type && slot.vehicle == null) {
					slot.vehicle = vehicle;
					slot.ticketID = generateTicketId(i + 1, j + 1);
					return slot.ticketID;
				}
			}
		}
		System.out.println("NO slot available for given type");
		return null;
	}

	private String generateTicketId(int flr, int slno) {
		return parkingLotId + "_" + flr + "_" + slno;
	}
}
