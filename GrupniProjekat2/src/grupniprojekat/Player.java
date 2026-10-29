// Miloš Petrović 24/151
// Nebojša Pješčić 23/001
// Imad Guberinić 24/135
// Almir Pelinković 23/133
package grupniprojekat;

public class Player extends GameObject {
	private String name;
    private int health;
	
    
    public Player(int x, int y, int width, int height, String name, int health) {
		super(x, y, width, height);
		this.name = name;
		this.health = health;
	}
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
	     }

	       name = name.trim().replaceAll("\\s+", " ");

	       String[] rijeci = name.split(" ");
	       String novoIme = "";

	       for (String rijec : rijeci) {
	          novoIme += rijec.substring(0, 1).toUpperCase()
	                + rijec.substring(1).toLowerCase() + " ";
	        }

	        this.name = novoIme.trim();
	        
    }

	public String getName() {
		return name;
	}


	

	public int getHealth() {
		return health;
	}

	
	public void setHealth(int health) {
		if (health < 0) {
			this.health = 0;
		} else if (health > 100) {
			this.health = 100;
		} else {
			this.health = health;
		}
	}
	@Override
	public String toString() {
		return "Player [name=" + this.name + ", health=" + this.health + "]";
	}
}