package earthquakePract;

import java.util.ArrayList;
import java.util.Scanner;

import earthquakePract.Donation.DonType;
import earthquakePract.Earthquake.Options;
import earthquakePract.Volunteer.Branch;

public class Main {

	public static void main(String[] args) {
		Scanner scanInt = new Scanner(System.in);
		Scanner scanStr = new Scanner(System.in);
		Scanner scanDoub = new Scanner(System.in);
		// Create arraylists for total/volunteer/notice/donation options
		ArrayList<Earthquake> totalList = new ArrayList<Earthquake>();
		ArrayList<Volunteer> volList = new ArrayList<Volunteer>();
		ArrayList<Notice> notList = new ArrayList<Notice>();
		ArrayList<Donation> donList = new ArrayList<Donation>();
		
		while(true) {
			System.out.println("Deprem Gonulluluk/Ihbar/Bagis Programina Hosgeldiniz"
					+ "\nIslem tipini seciniz (Cikis (4)):");
			for(Options i: Options.values()) {
				System.out.println(i + " " + i.getId());
			}
			int op = scanInt.nextInt();
			Options cOp = null;
			for(Options i: Options.values()) {
				if(op == i.getId()) {
					cOp = i;
				}
			}
			if(op == Options.Cikis.getId()) {
				System.out.println("Desteginiz icin tesekkur ederiz.");
				System.out.println("Sistemden cikiliyor...");
				break;
				
			} else if(op == Options.Gonullu.getId()) {
				System.out.print("Isim giriniz: ");
				String name = scanStr.nextLine();
				System.out.print("Soyisim giriniz: ");
				String surname = scanStr.nextLine();
				System.out.println("Telefon giriniz: ");
				String phone = scanStr.nextLine();
				System.out.println("Adres giriniz: ");
				String address = scanStr.nextLine();
				System.out.println("Mail giriniz: ");
				String mail = scanStr.nextLine();
				System.out.println("Mesleginizi giriniz: ");
				String job = scanStr.nextLine();
				System.out.println("Hangi alanda calismak istiyorsunuz?: ");
				for(Branch b: Branch.values()) {
					System.out.println(b + " " + b.getId());
				}
				int branch = scanInt.nextInt();
				Branch cBranch = null;
				for(Branch b: Branch.values()) {
					if(branch == b.getId()) {
						cBranch = b;
					}
				}
				System.out.println("Sectiginiz alan ile ilgili sertifikaniz var mi? (evet/hayir): ");
				String isCertificated = scanStr.nextLine();
				Volunteer v = new Volunteer(cOp, name, surname, phone, address, mail, job, 
						(isCertificated.equals("evet")? true: false), cBranch);
				totalList.add(v);
				volList.add(v);
				
			} else if(op == Options.Ihbar.getId()) {
				System.out.print("Isim giriniz: ");
				String name = scanStr.nextLine();
				System.out.print("Soyisim giriniz: ");
				String surname = scanStr.nextLine();
				System.out.println("Telefon giriniz: ");
				String phone = scanStr.nextLine();
				System.out.println("Adres giriniz: ");
				String address = scanStr.nextLine();
				System.out.println("Mail giriniz: ");
				String mail = scanStr.nextLine();
				System.out.println("Yarali isim ve soyismini giriniz: ");
				String nSurname = scanStr.nextLine();
				System.out.println("Yarali durumunu giriniz: ");
				String injuredStat = scanStr.nextLine();
				System.out.println("Yarali lokasyonunu giriniz: ");
				String location = scanStr.nextLine();
				System.out.println("Son ulasim saati ve gununu giriniz: ");
				String lastAccess = scanStr.nextLine();
				System.out.println("Yarali telefon bilgisini giriniz: ");
				String injuredPh = scanStr.nextLine();
				Notice not = new Notice(cOp, name, surname, phone, address, mail, injuredStat, location,
						lastAccess, injuredPh, nSurname);
				totalList.add(not);
				notList.add(not);
			} else if(op == Options.Yardim.getId()) {
				System.out.print("Isim giriniz: ");
				String name = scanStr.nextLine();
				System.out.print("Soyisim giriniz: ");
				String surname = scanStr.nextLine();
				System.out.println("Telefon giriniz: ");
				String phone = scanStr.nextLine();
				System.out.println("Adres giriniz: ");
				String address = scanStr.nextLine();
				System.out.println("Mail giriniz: ");
				String mail = scanStr.nextLine();
				System.out.println("Yardim turunu seciniz: ");
				for(DonType d: DonType.values()) {
					System.out.println(d + " " + d.getId());
				}
				int don = scanInt.nextInt();
				DonType sDon = null;
				for(DonType d: DonType.values()) {
					if(don == d.getId()) {
						sDon = d;
					}
				}
				System.out.println("Miktari giriniz: ");
				double amount = scanDoub.nextDouble();
				System.out.println("Yardim detayini giriniz: ");
				String detail = scanStr.nextLine();
				Donation d = new Donation(cOp, name, surname, phone, address, mail, sDon, amount, detail);
				totalList.add(d);
				donList.add(d);
			} else {
				System.out.println("Gecersiz islem girdiniz!");
			}
		}

		System.out.println("--------------------");
		System.out.println("Toplam Liste:");
		for(Earthquake e: totalList) {
			if(totalList.isEmpty())
				break;
			e.showInfo();
		}
		System.out.println("--------------------");
		System.out.println("Gonullu listesi:");
		for(Volunteer v: volList) {
			if(volList.isEmpty()) {
				System.out.println("Liste bos!");
				break;
			}
			v.showInfo();
		}
		System.out.println("--------------------");
		System.out.println("Ihbar listesi:");
		for(Notice n: notList) {
			if(notList.isEmpty()) {
				System.out.println("Liste bos!");
				break;
			}
			n.showInfo();
		}
		System.out.println("--------------------");
		System.out.println("Yardim listesi:");
		for(Donation d: donList) {
			if(donList.isEmpty()) {
				System.out.println("Liste bos!");
				break;
			}
			d.showInfo();
		}
		

	}

}
