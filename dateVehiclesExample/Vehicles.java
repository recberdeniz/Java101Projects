package dateVehiclesExample;

import java.time.LocalDate;
// Vehicle Abstract Class
// Type Choosing operation created with enum
public abstract class Vehicles {
	public enum TypeOption{
		Car(1), Truck(2), Motocycle(3);
		private int id;
		TypeOption(int id){
			this.id = id;
		}
		public int getId() {
			return id;
		}
	}
	protected TypeOption type; 
	protected LocalDate year; 
	protected String model;
	protected int km;
	protected LocalDate inspectionDate;
	protected LocalDate maintenanceDate;
	protected int lastHundredKm;
	public Vehicles(TypeOption type, LocalDate year, String model, int km, LocalDate inspectionDate, 
			LocalDate maintenanceDate, int lastHundredKm) {
		this.type = type;
		this.year = year;
		this.model = model;
		this.km = km;
		this.inspectionDate = inspectionDate;
		this.maintenanceDate = maintenanceDate;
		this.lastHundredKm = lastHundredKm;
	}
	
	public abstract boolean annualCareIsPass();
	public abstract int remainingTimeNextAnnualCare();
	public abstract boolean inspectionDateIsPass();
	public abstract int remainingTimeNextInspection();
	public abstract void kmIncrement(int incrementAmount);
	public abstract boolean hundredMaintenanceIsPass();
	public abstract int remainingKmHundredMaintenance();
	public abstract boolean isSalvage();
	public abstract boolean isClassic();
	public abstract void doAnnualCare();
	public abstract void doHundredMaintenance();
	public abstract void doInspection();
	public abstract void vehicleInfo();

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public LocalDate getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(LocalDate maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public int getLastHundredKm() {
		return lastHundredKm;
	}

	public void setLastHundredKm(int lastHundredKm) {
		this.lastHundredKm = lastHundredKm;
	}
	

}
