package dateVehiclesExample;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Motocycle extends Vehicles{

	public Motocycle(TypeOption type, LocalDate year, String model, int km, LocalDate inspectionDate,
			LocalDate maintenanceDate, int lastHundredKm) {
		super(type, year, model, km, inspectionDate, maintenanceDate, lastHundredKm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean annualCareIsPass() {
		boolean check = LocalDate.now().isAfter(maintenanceDate.plusYears(1));
		return check;
	}

	@Override
	public int remainingTimeNextAnnualCare() {
		boolean check = LocalDate.now().isAfter(maintenanceDate.plusYears(1));
		if(!check) {
			int remainingTime = (int) LocalDate.now().until(maintenanceDate.plusYears(1), ChronoUnit.DAYS);
			return remainingTime;
		} else {
			return 0;
		}
	}

	@Override
	public boolean inspectionDateIsPass() {
		boolean check = LocalDate.now().isAfter(inspectionDate.plusYears(1));
		return check;
	}

	@Override
	public int remainingTimeNextInspection() {
		boolean check = LocalDate.now().isAfter(inspectionDate.plusYears(2));
		if(!check) {
			int remainingTime = (int) LocalDate.now().until(inspectionDate.plusYears(2), ChronoUnit.DAYS);
			return remainingTime;
		} else {
			return 0;
		}
	}

	@Override
	public void kmIncrement(int incrementAmount) {
		this.km += incrementAmount;
		
	}

	@Override
	public boolean hundredMaintenanceIsPass() {
		if(this.km > this.lastHundredKm + 100000)
			return true;
		else
			return false;
	}

	@Override
	public int remainingKmHundredMaintenance() {
		if(this.km > this.lastHundredKm + 100000)
			return 0;
		else
			return this.lastHundredKm + 100000 - this.km;
	}

	@Override
	public boolean isSalvage() {
		if(LocalDate.now().until(year, ChronoUnit.YEARS) > 25 && LocalDate.now().until(year, ChronoUnit.YEARS) < 45)
			return true;
		else
			return false;
	}

	@Override
	public boolean isClassic() {
		if(LocalDate.now().until(year, ChronoUnit.YEARS) >= 45)
			return true;
		else
			return false;
	}

	@Override
	public void doAnnualCare() {
		if(annualCareIsPass()) {
			this.maintenanceDate = LocalDate.now();
			System.out.println("Your information were updated!");
		}
		else
			System.out.println("You have " + remainingTimeNextAnnualCare() + " day to next annual maintenance.");
		
	}

	@Override
	public void doHundredMaintenance() {
		if(hundredMaintenanceIsPass()) {
			this.lastHundredKm = this.km;
			System.out.println("Your information were updated!");
		}
		else
			System.out.println("You have " + remainingKmHundredMaintenance() + " km to next 100.000 maintenance.");
		
	}

	@Override
	public void doInspection() {
		if(inspectionDateIsPass()) {
			this.inspectionDate = LocalDate.now();
			System.out.println("Your information were updated!");
		}
		else
			System.out.println("You have " + remainingTimeNextInspection() + " day to next truck inspection.");
		
	}

	@Override
	public void vehicleInfo() {
		System.out.println("--------------");
		System.out.println(this.type);
		System.out.println("--------------");
		System.out.println("Model: " + this.model);
		System.out.println("Year: " + this.year);
		System.out.println("Km: " + this.km);
		System.out.println("Inspection Date: " + this.inspectionDate);
		System.out.println("Annual Maintenance Date: " + this.maintenanceDate);
		System.out.println("Is salvage: " + (isSalvage()? "Yes":"No"));
		System.out.println("Is classic: " + (isClassic()? "Yes":"No"));
		
	}

}
