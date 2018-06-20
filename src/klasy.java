import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class klasy {

	
	static void Dodajklase() throws IOException {
		Scanner sc = new Scanner(System.in);
		
		zbiorklas zk = new zbiorklas();
		zk.wczytajklasy();
		
		
		File zbior = new File("zbiorklas.txt");
		FileWriter fw = new FileWriter(zbior,true);
		
		
		System.out.println("Podaj klase, jaka chcesz dodac");
		String odp = sc.nextLine();
		if(!odp.contains(" ")) {
		zk.szereg(odp);
		
		File klasa = new File(odp+".txt");
		FileWriter fww = new FileWriter(klasa);
		fww.close();
		int liczbauczniow = zk.liczbauczniow;
		PrintWriter pw = new PrintWriter(fw);
		pw.println(odp+" "+liczbauczniow);
		pw.close();
		fw.close();
		System.out.println("Klasa zostala dodana");
		}
		else {
			System.out.println("nazwa klasy nie moze zawierac odstepow");
		}
	}
	
	static void Sprawdzklase() throws IOException {
		Scanner sc = new Scanner(System.in);
		
		zbiorklas zk = new zbiorklas();
		zk.wczytajklasy();
		
		System.out.println("ktora klase chcesz sprawdzic?");
		String odp = sc.nextLine();
		File zbior = new File("zbiorklas.txt");
		
		zk.szereg("zbiorklas");
		int liczbaklas = zk.liczbauczniow;
		
		Scanner in = new Scanner(zbior);
		String[][] klasy = new String[liczbaklas][2];
		for(int z=0;z<liczbaklas;z++) {
			klasy[z]=in.nextLine().split(" ");
		}
		in.close();
	    for(int z=0;z<klasy.length;z++) {
	    	if(klasy[z][0].equals(odp)) {
	    		System.out.println("klasa "+klasy[z][0]+"\nIlosc uczniow: "+klasy[z][1]);
	    		File klasa = new File(odp+".txt");
	    		Scanner inn = new Scanner(klasa);
	    		while(inn.hasNextLine()) {
	    			System.out.println(inn.nextLine());
	    		}
	    		inn.close();
	    	}
	    }
	}
	static void zaktualizujklasy(String odp) throws IOException {
		zbiorklas zk = new zbiorklas();
		String uczen = "zbiorklas";
		zk.szereg(uczen);
		
		File zbiorklas = new File(uczen+".txt");
		FileWriter fw = new FileWriter(zbiorklas, true);
		Scanner in = new Scanner(zbiorklas);
		int liczbaklas = zk.liczbauczniow;
		String[][] klasy = new String[liczbaklas][2];
		for(int z =0;z<liczbaklas;z++) {
			klasy[z]=in.nextLine().split(" ");
		}
		in.close();
		fw.close();
		for(int z =0;z<klasy.length;z++) {
			if(klasy[z][0].equals(odp)) {
				zk.szereg(odp);
				String liczbauczniow = Integer.toString(zk.liczbauczniow);
				klasy[z][1] = liczbauczniow;
			}
		}
		zk.koniecklas(liczbaklas, klasy);
		
	}
}
