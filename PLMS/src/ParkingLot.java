import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private String parkingLotId;
	private List<List<Slot>> slots;

	public ParkingLot(String parkingLotId, int nFloors, int noOfSlotsPerFloor) {
		this.parkingLotId = parkingLotId;
		this.slots = new ArrayList<>();
		for (int i = 0; i < nFloors; i++) {
			slots.add(new ArrayList<>());
			List<Slot> floorSlots = slots.get(i);
			floorSlots.add(new Slot("truck"));
			floorSlots.add(new Slot("bike"));
			floorSlots.add(new Slot("bike"));

			for (int j = 3; j < noOfSlotsPerFloor; j++) {
				slots.get(i).add(new Slot("car"));
			}
		}
	}

	public String parkVehicle(String type, String regNo, String color) {
		Vehicle vehicle = new Vehicle(type, regNo, color);

		for (List<Slot> floorSlots : slots) {
			for (Slot slot : floorSlots) {
				if (slot.getType().equals(type) && slot.getVehicle() == null) {
					slot.setVehicle(vehicle);
					String ticketId = generateTicketId(slots.indexOf(floorSlots) + 1, floorSlots.indexOf(slot) + 1);
					slot.setTicketId(ticketId);
					return ticketId;
				}
			}
		}

		throw new IllegalArgumentException("No slot available for given type");
	}

	public void unPark(String ticketId) {
		String[] extract = ticketId.split("_");
		int flrIdx;
		int slotIdx;

		try {
			flrIdx = Integer.parseInt(extract[1]) - 1;
			slotIdx = Integer.parseInt(extract[2]) - 1;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid ticket");
		}

		if (flrIdx < 0 || flrIdx >= slots.size() || slotIdx < 0 || slotIdx >= slots.get(flrIdx).size()) {
			throw new IllegalArgumentException("Invalid ticket");
		}

		Slot slot = slots.get(flrIdx).get(slotIdx);
		if (slot.getVehicle() == null) {
			throw new IllegalStateException("Slot already empty");
		} else {
			slot.setVehicle(null);
			slot.setTicketId(null);
			System.out.println("Unparked vehicle");
		}
	}

	private String generateTicketId(int floor, int slotNumber) {
		return parkingLotId + "_" + floor + "_" + slotNumber;
	}

	public int getNoOfOpenSlots(String type) {
		int count = 0;
		for (List<Slot> floor : slots) {
			for (Slot slot : floor) {
				if (slot.getVehicle() == null && slot.getType().equals(type)) {
					count++;
				}
			}
		}
		return count;
	}

	public void displayOpenSlots(String type) {
		System.out.println("Available slots for " + type);
		for (int i = 0; i < slots.size(); i++) {
			for (int j = 0; j < slots.get(i).size(); j++) {
				Slot slot = slots.get(i).get(j);
				if (slot.getVehicle() == null && slot.getType().equals(type)) {
					System.out.println("Floor " + (i + 1) + " slot " + (j + 1));
				}
			}
		}
	}

	public void displayOccupiedSlots(String type) {
		System.out.println("Occupied slots for " + type);
		for (int i = 0; i < slots.size(); i++) {
			for (int j = 0; j < slots.get(i).size(); j++) {
				Slot slot = slots.get(i).get(j);
				if (slot.getVehicle() != null && slot.getType().equals(type)) {
					System.out.println("Floor " + (i + 1) + " slot " + (j + 1));
				}
			}
		}
	}
}
