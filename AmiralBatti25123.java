package test;

import java.util.Random;
import java.util.Scanner;

public class AmiralBatti25123 {
	// Static variable first assignment
	static int battlefield[][] = new int[8][8];
	static String hidedBattleField[][] = new String[8][8];
	static String nextPlayer = "1";
	static int scoreUser = 0 , scoreUser2 = 0;
	static int scorePc = 0;
	static String choose;
	static int counter = 0;
	static String winner;
	// Static definition ended
	public static void main(String[] args) {
		Scanner inputString = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Single Player(SP)\nMulti Player(MP)\nMod seciniz: ");
		choose = inputString.nextLine();
		System.out.print("Kac gemili oynayacaginizi giriniz: ");
		counter = inputInt.nextInt();
		if((choose.equals("SP") || choose.equals("MP")) && (counter > 0 && counter <= 24)) {
			createTemplate();
			if(choose.equals("SP"))
				valueAssign();
			valuePlayer();
			//createTemplate();
			hideAssign();
			hidedTemplate();
			while(true) {
				boolean gameOver = isGameOver();
				if(gameOver) {
					if(choose.equals("SP")) {
						System.out.println("Kazanan: " + winner);
						System.out.println("Skor: " + scoreUser + " - " + scorePc);
						break;
					} else {
						System.out.println("Kazanan: " + winner);
						System.out.println("Skor: " + scoreUser + " - " + scoreUser2);
						break;
					}
				}
				if(choose.equals("SP")) {
					if(nextPlayer.equals("1")) {
						System.out.println("Oyuncu 1 icin hamlenizi giriniz:");
						String fpAttack = inputString.nextLine();
						if(fpAttack.equals("99")) {
							System.out.println("Oyun sonlandi...");
							break;
						}
						boolean isAttack = attackCheck(fpAttack);
						if(!isAttack) {
							System.out.println("Gecersiz hamle girildi!");
							continue;
						}
						attack(fpAttack);
						hidedTemplate();
						
					} else {
						System.out.println("Bilgisayar hamlesini giriyor...");
						int randRow = rand.nextInt(2);
						int randCol = rand.nextInt(8);
						//System.out.println(randRow + " " + randCol);
						pcAttack(randRow, randCol);
						hidedTemplate();
						
					}
				} else {
					if(nextPlayer.equals("1")) {
							System.out.println("Oyuncu 1 icin hamlenizi giriniz:");
							String fpAttack = inputString.nextLine();
							if(fpAttack.equals("99")) {
								System.out.println("Oyun sonlandi...");
								break;
							}
							boolean isAttack = attackCheck(fpAttack);
							if(!isAttack) {
								System.out.println("Gecersiz hamle girildi!");
								continue;
							}
							attack(fpAttack);
							hidedTemplate();	
					} else {
						System.out.println("Oyuncu 2 icin hamlenizi giriniz:");
						String fpAttack = inputString.nextLine();
						if(fpAttack.equals("99")) {
							System.out.println("Oyun sonlandi...");
							break;
						}
						boolean isAttack = attackCheck(fpAttack);
						if(!isAttack) {
							System.out.println("Gecersiz hamle girildi!");
							continue;
						}
						attack(fpAttack);
						hidedTemplate();
					}
				}
			}
			createTemplate();
			hidedTemplate();
		} else {
			System.out.println("Girilen parametreler yanlis, oyun baslatilamadi!");
		}
		
	}

	private static boolean isGameOver() {
		if(scoreUser == counter) {
			winner = "Oyuncu 1";
			return true;
		}
		else if(scoreUser2 == counter) {
			winner = "Oyuncu 2";
			return true;
		}
		else if(scorePc == counter) {
			winner = "PC";
			return true;
		}
		else
		return false;
	}

	private static void pcAttack(int randRow, int randCol) {
		if(battlefield[randRow][randCol] == 1) {
			battlefield[randRow][randCol] = 0;
			hidedBattleField[randRow][randCol] = "X";
			scorePc++;
		}
		nextPlayer = "1";
		
	}

	private static void attack(String fpAttack) {
		if(choose.equals("SP")) {
			char column = fpAttack.charAt(0);
			int col = converter(column);
			char row = fpAttack.charAt(1);
			int arow = Character.getNumericValue(row);
			if(battlefield[arow][col] == 2) {
				battlefield[arow][col] = 0;
				hidedBattleField[arow][col] = "X";
				scoreUser++;
			}
			nextPlayer = "2";
		} else {
			if(nextPlayer.equals("1")) {
				char column = fpAttack.charAt(0);
				int col = converter(column);
				char row = fpAttack.charAt(1);
				int arow = Character.getNumericValue(row);
				if(battlefield[arow][col] == 2) {
					battlefield[arow][col] = 0;
					hidedBattleField[arow][col] = "X";
					scoreUser++;
				} nextPlayer = "2";
			} else {
				char column = fpAttack.charAt(0);
				int col = converter(column);
				char row = fpAttack.charAt(1);
				int arow = Character.getNumericValue(row);
				if(battlefield[arow][col] == 1) {
					battlefield[arow][col] = 0;
					hidedBattleField[arow][col] = "X";
					scoreUser2++;
				} nextPlayer = "1";
			}
		}
		
	}

	private static boolean attackCheck(String fpAttack) {
		if(choose.equals("SP")) {
			char column = fpAttack.charAt(0);
			int col = converter(column);
			char row = fpAttack.charAt(1);
			int arow = Character.getNumericValue(row);
			if((arow > 7 || arow < 5) || (col > 7 || col < 0)) {
				return false;
			} else {
				return true;
			}
		}else {
			if(nextPlayer.equals("1")) {
				char column = fpAttack.charAt(0);
				int col = converter(column);
				char row = fpAttack.charAt(1);
				int arow = Character.getNumericValue(row);
				if((arow > 7 || arow < 5) || (col > 7 || col < 0)) {
					return false;
				} else {
					return true;
				}
			} else {
				char column = fpAttack.charAt(0);
				int col = converter(column);
				char row = fpAttack.charAt(1);
				int arow = Character.getNumericValue(row);
				if((arow > 2 || arow < 0) || (col > 7 || col < 0)) {
					return false;
				} else {
					return true;
				}
			}
		}
	}

	private static void hideAssign() {
		for(int i=0 ; i<8;i++) {
			hidedBattleField[0][i]="?";
			hidedBattleField[1][i]="?";
			hidedBattleField[2][i]="?";
			hidedBattleField[3][i]="?";
			hidedBattleField[4][i]="?";
			hidedBattleField[5][i]="?";
			hidedBattleField[6][i]="?";
			hidedBattleField[7][i]="?";

		}
		
	}

	private static void hidedTemplate() {
		System.out.println();
		System.out.println("  a b c d e f g h");
		for(int i = 0; i < hidedBattleField.length; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < hidedBattleField[i].length; j++) {
				System.out.print(hidedBattleField[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void valuePlayer() {
		Scanner input = new Scanner(System.in);
		if(choose.equals("MP")) {
			int count1 = 0;
			int count2 = 0;
			while(count1 < counter) {
				System.out.print("1. Oyuncu\nGeminizi yerlestirmek icin lokasyon giriniz: ");
				String location = input.nextLine();
				char column = location.charAt(0);
				int col = converter(column);
				char row = location.charAt(1);
				int arow = Character.getNumericValue(row);
				if((arow > 2 || arow <= -1) || col >= 8) {
					System.out.println("Hatali deger girildi!");
					continue;
				}			
				else if(battlefield[arow][col] == 1) {
					System.out.println("Hatali deger girildi");
					continue;
				} else {
					battlefield[arow][col] = 1;
					count1++;
				}
			}
			while(count2 < counter) {
				System.out.print("2. Oyuncu\nGeminizi yerlestirmek icin lokasyon giriniz: ");
				String location = input.nextLine();
				char column = location.charAt(0);
				int col = converter(column);
				char row = location.charAt(1);
				int arow = Character.getNumericValue(row);
				if((arow < 5 || arow > 7) || col >= 8) {
					System.out.println("Hatali deger girildi!");
					continue;
				}			
				else if(battlefield[arow][col] == 2) {
					System.out.println("Hatali deger girildi");
					continue;
				} else {
					battlefield[arow][col] = 2;
					count2++;
				}
			}
		} else {
			int count = 0;
			while(count < counter) {
				System.out.print("Geminizi yerlestirmek icin lokasyon giriniz: ");
				String location = input.nextLine();
				char column = location.charAt(0);
				int col = converter(column);
				char row = location.charAt(1);
				int arow = Character.getNumericValue(row);
				if((arow > 2 || arow <= -1) || col >= 8) {
					System.out.println("Hatali deger girildi!");
					continue;
				}			
				else if(battlefield[arow][col] == 1) {
					System.out.println("Hatali deger girildi");
					continue;
				} else {
					battlefield[arow][col] = 1;
					count++;
				}
			}
		}
		
	}

	private static int converter(char column) {
		switch (column) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
			
		}
		return 8;
	}

	private static void valueAssign() {
		Random rand = new Random();
		int count = 0;
		while(count < counter) {
			int random = rand.nextInt(3)+5;
			for(int i = 0; i < battlefield[random].length; i++) {
				int nRand = rand.nextInt(battlefield[random].length);
				if(battlefield[random][nRand] == 2) {
					continue;
				}
				battlefield[random][nRand] = 2;
				break;
			}
			count++;
		}
	}

	private static void createTemplate() {
		System.out.println();
		System.out.println("  a b c d e f g h");
		for(int i = 0; i < battlefield.length; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < battlefield[i].length; j++) {
				System.out.print(battlefield[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
