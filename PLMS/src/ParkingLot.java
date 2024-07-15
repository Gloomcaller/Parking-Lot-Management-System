import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	String parkingLotID;
	List<List<Slot>> slots;

	public ParkingLot(String parkingLotID, int nfloors, int noOfSlotsPerFlr) {
		this.parkingLotID = parkingLotID;
		slots = new ArrayList<>();
		for (int i = 0; i < nfloors; i++) {
			slots.add(new ArrayList<>());
			List<Slot> floorSlots = slots.get(i);
			floorSlots.add(new Slot("truck"));
			floorSlots.add(new Slot("bike"));
			floorSlots.add(new Slot("bike"));

			for (int j = 3; j < noOfSlotsPerFlr; j++) {
				floorSlots.add(new Slot("car"));
			}
		}
	}

	public String parkVehicle(String type, String regNO, String color) {
		Vehicle vehicle = new Vehicle(type, regNO, color);

		for (int i = 0; i < slots.size(); i++) {
			for (int j = 0; j < slots.get(i).size(); j++) {
				Slot slot = slots.get(i).get(j);
				if (slot.type.equals(type) && slot.vehicle == null) {
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
		return parkingLotID + "_" + flr + "_" + slno;
	}

	public void unPark(String ticketId) {
		String[] extract = ticketId.split("_");
		int flr_index, slot_index;
		try {
			flr_index = Integer.parseInt(extract[1]) - 1;
			slot_index = Integer.parseInt(extract[2]) - 1;
		} catch (Exception e) {
			System.out.println("Invalid ticket");
			return;
		}

		for (int i = 0; i < slots.size(); i++) {
			for (int j = 0; j < slots.size(); j++) {
				if (i == flr_index && j == slot_index) {
					Slot slot = slots.get(i).get(j);
					slot.vehicle = null;
					slot.ticketID = null;
					System.out.println("Unparked vehicle");
				}
			}
		}
	}

}
