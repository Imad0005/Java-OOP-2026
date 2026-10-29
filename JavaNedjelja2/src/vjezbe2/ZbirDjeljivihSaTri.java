package vjezbe2;

public class ZbirDjeljivihSaTri {

	public static void main(String[] args) {
		int i = 1;
		int zbir = 0;
		while (i <= 30) {
			if (i % 3 == 0) {
				zbir = zbir + i;
			}
			i++;
		}
		System.out.println("Zbir je: " + zbir);
	}

}
