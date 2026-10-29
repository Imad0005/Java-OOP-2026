package vjezbe1;

public class Temperatura {

	public static void main(String[] args) {
		int temperatura = 12;
		if (temperatura < 0) {
			System.out.println("Veoma hladno");
		} else if (temperatura <= 15) {
			System.out.println("Hladno");
		} else if (temperatura <= 30) {
			System.out.println("Prijatno");
		} else {
			System.out.println("Veoma toplo");
		}
	}
}
