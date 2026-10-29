package vjezbe1;

public class PravoNaKolokvijum {

	public static void main(String[] args) {
		int prisustvo = 80;
		boolean prijavljen = true;

		if (prisustvo < 75 || !prijavljen) {
			System.out.println("Student nema pravo izlaska na kolokvijum");
		} else {
			System.out.println("Student ima pravo izlaska na kolokvijum");

		}
	}

}
