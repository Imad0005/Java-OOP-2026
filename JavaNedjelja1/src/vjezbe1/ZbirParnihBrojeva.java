package vjezbe1;

public class ZbirParnihBrojeva {

	public static void main(String[] args) {

		int zbir = 0;

		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				zbir = zbir + i;
			}
		}
		System.out.println("Zbir parnih brojeva je: " + zbir);

	}

}
