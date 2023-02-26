package dateVehiclesExample;

import java.time.LocalDate;
import java.util.Scanner;

import dateVehiclesExample.Vehicles.TypeOption;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Vehicles vehicle = null;
		for(TypeOption t: TypeOption.values())
			System.out.println(t.getId() + " " + t);
		
		System.out.println("Choose your vehicle option: ");
		int option = scan.nextInt();
		
		switch(option) {
		case 1:
			vehicle = createCar(scan, option);
			break;
			
		case 2:
			vehicle = createTruck(scan, option);
			break;
		case 3:
			vehicle = createMotocycle(scan, option);
			break;
		default:
			System.out.println("Incorrect choice...");
		}
		
		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("1-Check that the annual maintenance date is pass:\n"
					+ "2-Check that is next annual maintenance date:\n"
					+ "3-Check that the inspection date is pass:\n"
					+ "4-Check that is next inspection date:\n"
					+ "5-Update the km:\n"
					+ "6-Check that the 100.000 Km is pass:\n"
					+ "7-Check that is next 100.000 Km maintenance remaining km:\n"
					+ "8-Check that the car is salvage:\n"
					+ "9-Check that the car is classic:\n"
					+ "10-Do annual maintenance:\n"
					+ "11-Do 100.000 Km maintenance:\n"
					+ "12-Do vehicle inspection:\n"
					+ "13-Show vehicle info:\n"
					+ "99-Exit:");
			System.out.println("-----------------------------------------");
			System.out.print("Select the operation: ");
			int operation = scan.nextInt();
			if(99 == operation) {
				System.out.println("System closing...");
				break;
			} else if(1 == operation) {
				boolean control = vehicle.annualCareIsPass();
				System.out.println(control? "Yes, you should do the annual maintenance!": "No");
				System.out.println("Last annual maintenance date: " + vehicle.getMaintenanceDate());
			} else if(2 == operation) {
				System.out.println("Your have " + vehicle.remainingTimeNextAnnualCare() + 
						" days to next annual maintenance.");
			} else if(3 == operation) {
				boolean control = vehicle.inspectionDateIsPass();
				System.out.println(control? "Yes, you must do the vehicle inspection!": "No");
				System.out.println("Last annual maintenance date: " + vehicle.getInspectionDate());
			} else if(4 == operation) {
				System.out.println("You have " + vehicle.remainingTimeNextInspection() + 
						" days to next annual maintenance.");
			} else if(5 == operation) {
				System.out.print("Insert a km: ");
				int upKm = scan.nextInt();
				vehicle.kmIncrement(upKm);
			} else if(6 == operation) {
				boolean control = vehicle.hundredMaintenanceIsPass();
				System.out.println(control? "Yes, you should do the 100.000 Km maintenance!": "No");
				System.out.println("Last 100.000 Km maintenance: " + vehicle.getLastHundredKm());
			} else if(7 == operation) {
				System.out.println("Your have " + vehicle.remainingKmHundredMaintenance() + 
						" km to next 100.000 Km maintenance.");
			} else if(8 == operation) {
				boolean control = vehicle.isSalvage();
				System.out.println(control? "Your car is salvage.":"No");
			} else if(9 == operation) {
				boolean control = vehicle.isClassic();
				System.out.println(control? "Your car is classic.":"No");
			} else if(10 == operation) {
				vehicle.doAnnualCare();
			} else if(11 == operation) {
				vehicle.doHundredMaintenance();
			} else if(12 == operation) {
				vehicle.doInspection();
			} else if(13 == operation) {
				vehicle.vehicleInfo();
			}
			
		}

	}

	private static Vehicles createMotocycle(Scanner scan, int option) {
		TypeOption type = null;
		for(TypeOption t: TypeOption.values()) {
			if(t.getId() == option) {
				type = t;
				break;
			}
		}
		System.out.println("Insert a year (YYYY-MM-DD):");
		String year = scan.next();
		LocalDate carYear = LocalDate.parse(year);
		System.out.println("Insert a model: ");
		String model = scan.next();
		System.out.println("Insert a km: ");
		int km = scan.nextInt();
		System.out.println("Insert an Inspection Date (YYYY-MM-DD):");
		String insDate = scan.next();
		LocalDate inspection = LocalDate.parse(insDate);
		System.out.println("Insert a Maintenance Date (YYYY-MM-DD):");
		String mDate = scan.next();
		LocalDate maintenance = LocalDate.parse(mDate);
		System.out.println("Insert a Last 100.000 Km: ");
		int lastHundredKm = scan.nextInt();
		Motocycle moto = new Motocycle(type, carYear, model, km, inspection, maintenance, lastHundredKm);
		return moto;
	}

	private static Vehicles createTruck(Scanner scan, int option) {
		TypeOption type = null;
		for(TypeOption t: TypeOption.values()) {
			if(t.getId() == option) {
				type = t;
				break;
			}
		}
		System.out.println("Insert a year (YYYY-MM-DD):");
		String year = scan.next();
		LocalDate carYear = LocalDate.parse(year);
		System.out.println("Insert a model: ");
		String model = scan.next();
		System.out.println("Insert a km: ");
		int km = scan.nextInt();
		System.out.println("Insert an Inspection Date (YYYY-MM-DD):");
		String insDate = scan.next();
		LocalDate inspection = LocalDate.parse(insDate);
		System.out.println("Insert a Maintenance Date (YYYY-MM-DD):");
		String mDate = scan.next();
		LocalDate maintenance = LocalDate.parse(mDate);
		System.out.println("Insert a Last 100.000 Km: ");
		int lastHundredKm = scan.nextInt();
		Truck truck = new Truck(type, carYear, model, km, inspection, maintenance, lastHundredKm);
		return truck;
	}

	private static Vehicles createCar(Scanner scan, int option) {
		TypeOption type = null;
		for(TypeOption t: TypeOption.values()) {
			if(t.getId() == option) {
				type = t;
				break;
			}
		}
		System.out.println("Insert a year (YYYY-MM-DD):");
		String year = scan.next();
		LocalDate carYear = LocalDate.parse(year);
		System.out.println("Insert a model: ");
		String model = scan.next();
		System.out.println("Insert a km: ");
		int km = scan.nextInt();
		System.out.println("Insert an Inspection Date (YYYY-MM-DD):");
		String insDate = scan.next();
		LocalDate inspection = LocalDate.parse(insDate);
		System.out.println("Insert a Maintenance Date (YYYY-MM-DD):");
		String mDate = scan.next();
		LocalDate maintenance = LocalDate.parse(mDate);
		System.out.println("Insert a Last 100.000 Km: ");
		int lastHundredKm = scan.nextInt();
		Automobile car = new Automobile(type, carYear, model, km, inspection, maintenance, lastHundredKm);
		return car;
	}

}
