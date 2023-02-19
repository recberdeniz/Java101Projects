package earthquakePract;

public class Donation extends Earthquake{
	//Donation Options
	public enum DonType{
		Subsidy(1),
		Ware(2),
		Nutrition(3),
		Hygiene(4),
		Battery(5),
		Fuel(6),
		Medicine(7),
		Tent(8);
		
		private int donType;
		
		DonType(int donType){
			this.donType = donType;
		}
		
		public int getId() {
			return donType;
		}
	}
	private DonType donType;
	private double amount;
	private String detail;
	public Donation(Options op, String name, String surname, String phone, String address, String mail,
			DonType donType, double amount, String detail) {
		super(op, name, surname, phone, address, mail);
		this.donType = donType;
		this.amount = amount;
		this.detail = detail;
	}
	public DonType getDonType() {
		return donType;
	}
	public void setDonType(DonType donType) {
		this.donType = donType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public void showInfo() {
		System.out.println("=====================");
		System.out.println(op);
		System.out.println("=====================");
		System.out.println("Ad: " + this.name);
		System.out.println("Soyad: " + this.surname);
		System.out.println("Telefon: " + this.phone);
		System.out.println("Mail: " + this.mail);
		System.out.println("Adres: " + this.address);
		System.out.println("Bagis Turu: " + this.donType);
		System.out.println("Miktar: " + this.amount);
		System.out.println("Detay: " + this.detail);
		
		
		
	}

}
