package earthquakePract;

public class Notice extends Earthquake{
	private String nSurname;
	private String injuredStat;
	private String location;
	private String lastAccess;
	private String injuredPh;
	public Notice(Options op, String name, String surname, String phone, String address, String mail,
			String injuredStat, String location, String lastAccess, String injuredPh, String nSurname) {
		super(op, name, surname, phone, address, mail);
		this.nSurname = nSurname;
		this.injuredStat = injuredStat;
		this.location = location;
		this.lastAccess = lastAccess;
		this.injuredPh = injuredPh;
	}
	public String getnSurname() {
		return nSurname;
	}
	public void setnSurname(String nSurname) {
		this.nSurname = nSurname;
	}
	public String getInjuredStat() {
		return injuredStat;
	}
	public void setInjuredStat(String injuredStat) {
		this.injuredStat = injuredStat;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}
	public String getInjuredPh() {
		return injuredPh;
	}
	public void setInjuredPh(String injuredPh) {
		this.injuredPh = injuredPh;
	}
	@Override
	public void showInfo() {
		System.out.println("=====================");
		System.out.println(op);
		System.out.println("=====================");
		System.out.println("Ad: " + this.name);
		System.out.println("Soyad: " + this.surname);
		System.out.println("Telefon: " + this.phone);
		System.out.println("Yarali isim/soyisim: " + this.nSurname);
		System.out.println("Yarali durumu: " + this.injuredStat);
		System.out.println("Lokasyon: " + this.location);
		System.out.println("Son ulasim gun ve saat bilgisi: " + this.lastAccess);
		System.out.println("Yarali telefon bilgisi: " + this.injuredPh);
		
		
	}
	

}
