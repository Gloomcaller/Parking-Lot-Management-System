# Parking Lot Management System

## Overview
This project implements a simple parking lot management system inspired by Kunal Nalawade guided project from FreeCodeCamp. It allows for the parking and unparking of vehicles, and provides details about available and occupied slots. The system is designed with basic object-oriented principles and includes encapsulation and exception handling.

## Features
- **Park a Vehicle:** Assign a vehicle to an available slot based on its type (car, bike, truck).
- **Unpark a Vehicle:** Remove a vehicle from its assigned slot using a ticket ID.
- **Display Slots:** Show all available and occupied slots for a specific vehicle type.
- **Get Number of Open Slots:** Retrieve the count of available slots for a specific vehicle type.

## Classes
- **Slot:** Represents a parking slot with a type, vehicle reference, and ticket ID.
- **Vehicle:** Represents a vehicle with a type, registration number, and color.
- **ParkingLot:** Manages parking lot operations including parking, unparking, and displaying slots.
- **Main:** The entry point of the application, demonstrating the usage of the ParkingLot class.

## How to Run
1. **Compile the Code:** Ensure you have Java installed. Compile the code using:
    ```sh
    javac Main.java ParkingLot.java Slot.java Vehicle.java
    ```

2. **Run the Application:** Execute the compiled code:
    ```sh
    java Main
    ```

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request on GitHub.

## Credits
- Special thanks to www.freecodecamp.org team and Kunal Nalawade.

## Contact
For any inquiries, please contact me via GitHub.
