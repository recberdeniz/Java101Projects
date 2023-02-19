package earthquakePract;

public class Volunteer extends Earthquake{
	//Volunteer Branch Options
	public enum Branch{
		Health(1),
		Operator(2),
		Cook(3),
		Rescue(4),
		Logistic(5);
		
		private int branch;
		
		Branch(int branch){
			this.branch = branch;
		}
		public int getId() {
			return branch;
		}
		
	}
	private String job;
	private boolean isCertificated;
	private Branch branch;
	public Volunteer(Options op, String name, String surname, String phone, String address, String mail
			, String job, boolean isCertificated, Branch branch) {
		super(op, name, surname, phone, address, mail);
		this.job = job;
		this.isCertificated = isCertificated;
		this.branch = branch;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public boolean isCertificated() {
		return isCertificated;
	}
	public void setCertificated(boolean isCertificated) {
		this.isCertificated = isCertificated;
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
		System.out.println("Meslek: " + this.job);
		System.out.println("Brans: " + this.branch);
		System.out.println("Sertifika durumu: " + (this.isCertificated? "Sertifikali":"Sertifikasiz"));
		
	}
	

}
