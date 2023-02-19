package earthquakePract;

public abstract class Earthquake {
	
	public enum Options {
		Gonullu(1),
		Ihbar(2),
		Yardim(3),
		Cikis(4);
		
		private int opId;
		Options(int opId){
			this.opId = opId;
		}
		public int getId() {
			return opId;
		}
	}
	protected String name;
	protected String surname;
	protected String phone;
	protected String address;
	protected String mail;
	protected Options op;
	
	public Earthquake(Options op, String name, String surname, String phone, String address, String mail) {

		this.op = op;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.mail = mail;
	}
	
	public abstract void showInfo();

	public Options getIslem() {
		return op;
	}

	public void setIslem(Options op) {
		this.op = op;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
