// Miloš Petrović 24/151
// Nebojša Pješčić 23/001
// Imad Guberinić 24/135
// Almir Pelinković 23/133
package grupniprojekat;

public class Enemy extends GameObject {
	private String type;
	private int damage;
	
	
	
	public Enemy(int x, int y, int width, int height, String type, int damage) {
		super(x, y, width, height);
		this.type = type;
		this.damage = damage;
	}

	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		if (type != null && !type.trim().isEmpty()) {
            this.type = type.trim();
        }
	}



	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		if (damage < 0) {
			this.damage = 0;
		} else if (damage > 100) {
			this.damage = 100;
		} else {
			this.damage = damage;
		}
	}

	@Override
	public String toString() {
		return "Enemy [type=" + this.type + ", damage=" + this.damage + "]";
	}
	
}