import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class uczniowie {

	static void dodajucznia() throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Podaj nazwisko i imie ucznia");
		String odp = sc.nextLine();
		if(odp.contains(" ")) {
		zbiorklas zk = new zbiorklas();
		zk.wczytajklasy();
		
		System.out.println("do której klasy chcesz przypisac ucznia?");
		String uczen = sc.nextLine();
		
		
		zbiorklas.nowiuczniowie(uczen, odp);
		
		File klasa = new File(uczen+".txt");
		
		
		zk.szereg(uczen);
		int liczbauczniow = zk.liczbauczniow;
		
		Scanner inn = new Scanner(klasa);
		String[][] uczniowie = new String[liczbauczniow][3];
		for(int z=0;z<liczbauczniow;z++) {
			uczniowie[z]=inn.nextLine().split(" ");
		}
		inn.close();
		String[] posegrowaniuczniowie = new String[liczbauczniow];
		for(int z=0;z<liczbauczniow;z++) {
			posegrowaniuczniowie[z]=uczniowie[z][1]+" "+uczniowie[z][2];
		}
		Arrays.sort(posegrowaniuczniowie);
		klasy.zaktualizujklasy(uczen);
		zbiorklas.koniecuczniow(uczen, liczbauczniow, posegrowaniuczniowie);
		}
		else {
			System.out.println("Mialo zostac podane tylko imie i nazwisko");
		}
	}
	
	static void znajdzucznia() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj Nazwisko i imie ucznia");
		String uczen = sc.nextLine();
		
		File zbiorklas = new File("zbiorklas.txt");
		Scanner in = new Scanner(zbiorklas);
		zbiorklas zk = new zbiorklas();
		
		zk.szereg("zbiorklas");
		int liczbaklas = zk.liczbauczniow;
		String[][] klasy = new String[liczbaklas][2];
		
		for(int z=0;z<liczbaklas;z++) {
			klasy[z]=in.nextLine().split(" ");
		}
		in.close();
		String[] posegregowaneklasy = new String[liczbaklas];
		for(int z=0;z<liczbaklas;z++) {
			posegregowaneklasy[z]=klasy[z][0];
		}
		int szukanie = 0;
		String znaleziony = "nie";
		do {
			File klasa = new File(posegregowaneklasy[szukanie]+".txt");
			in = new Scanner(klasa);
			Scanner inn = new Scanner(klasa);
			while(in.hasNextLine()) {
				if(in.nextLine().contains(uczen)) {
					System.out.println(inn.nextLine() +" umieszczony w klasie "+posegregowaneklasy[szukanie]);
					szukanie=posegregowaneklasy.length;
					znaleziony = "tak";
				}
					
			}
			szukanie++;
			in.close();
			inn.close();
		}while(szukanie<posegregowaneklasy.length);
		if(znaleziony.equals("nie")) {
			System.out.println("Niestety nie posiadamy ucznia w systemie");
		}
	}
}
