import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class zbiorklas {
	String uczen;
	String odp;
	int liczbauczniow;
	
	zbiorklas(){}
	zbiorklas(String uczen, String odp){
		this.uczen=uczen;
		this.odp=odp;
	}
	
	void wczytajklasy() throws IOException {
		File zbior = new File("zbiorklas.txt");
		FileWriter fw = new FileWriter(zbior,true);
		Scanner in = new Scanner(zbior);
		
		if(in.hasNextLine()) {
			System.out.println("oto zbior klas, jakie sa wpisane");
		int liczbaklas = 0;
		while(in.hasNextLine() && in.nextLine()!="") {
			liczbaklas++;
		}
		in.close();
		in = new Scanner(zbior);
		String[][] klasy = new String[liczbaklas][2];
		for(int z=0;z<liczbaklas;z++) {
			klasy[z]=in.nextLine().split(" ");
		}
		in.close();
		  for(int z=0;z<klasy.length;z++) {
			  System.out.println(klasy[z][0]);
		  }
		}
		else if(!in.hasNextLine()) {
			System.out.println("W systemie nie ma zadnej klasy");
		}
	}
	
	static void nowiuczniowie(String uczen, String odp) throws IOException {
		File klasa = new File(uczen+".txt");
		FileWriter fw = new FileWriter(klasa, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println("nowy. "+odp);
		pw.close();
		fw.close();
	}
	void szereg(String uczen) throws IOException {
		File klasa = new File(uczen+".txt");
		FileWriter fw = new FileWriter(klasa, true);
		Scanner in = new Scanner(klasa);
		int liczbauczniow=0;
			while(in.hasNextLine() && in.nextLine()!="") {
				liczbauczniow++;
			}
		this.liczbauczniow=liczbauczniow;
		in.close();
		fw.close();
		
	}
	static void koniecuczniow(String uczen, int liczbauczniow, String[] uczniowie) throws IOException {

		File klasa = new File(uczen+".txt");
		FileWriter fww = new FileWriter(klasa, false);
		PrintWriter pw = new PrintWriter(fww);
		int c=0;
		for(int z=0;z<liczbauczniow;z++) {
			c++;
		pw.println(c+". "+ uczniowie[z]);
}
		pw.close();
		fww.close();
		System.out.println("uczen zostal dodany");
	}
	static void koniecklas(int liczbaklas,String klasy[][]) throws IOException {
		File zbiorklas = new File("zbiorklas.txt");
		FileWriter fw = new FileWriter(zbiorklas, false);
		PrintWriter pw = new PrintWriter(fw);
		for(int z=0;z<liczbaklas;z++) {
			pw.println(klasy[z][0]+" "+klasy[z][1]);
		}
		pw.close();
		fw.close();
	}
}
