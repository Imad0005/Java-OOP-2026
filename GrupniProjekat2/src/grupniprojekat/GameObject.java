// Miloš Petrović 24/151
// Nebojša Pješčić 23/001
// Imad Guberinić 24/135
// Almir Pelinković 23/133

package grupniprojekat;

public class GameObject {
    
	private int x;
	private int y;
	private int width;
	private int height;

	public boolean intersects(GameObject other) {
        return this.x < other.x + other.width &&
               this.x + this.width > other.x &&
               this.y < other.y + other.height &&
               this.y + this.height > other.y;
               
    }
	
	
	
	@Override
	public String toString() {
		return "GameObject [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}



	public GameObject(int x, int y, int width, int height) {
	
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth( int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

	 
}