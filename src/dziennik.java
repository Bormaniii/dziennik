import java.io.IOException;
import java.util.Scanner;

public class dziennik {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
int koniec = 1;
while(koniec!=2) {
		System.out.println("==================\nDodaj ucznia [1]\nZnajdz ucznia [2]\nSprawdz klase [3]\nDodaj klase [4]\n==================");
		
		
		int odp = sc.nextInt();
		if(odp==1) {
			uczniowie.dodajucznia();
		}
		if(odp==2) {
			uczniowie.znajdzucznia();
		}
		if(odp==3) {
			klasy.Sprawdzklase();
		}
		if(odp==4) {
			klasy.Dodajklase();			
		}
		System.out.println("==================\nCzy chcesz przeprowadzic kolejna operacje?");
		System.out.println("tak [1]\nnie [2]");
		odp = sc.nextInt();
		koniec = odp;
	}
	}
}
