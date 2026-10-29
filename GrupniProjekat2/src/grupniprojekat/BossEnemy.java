package grupniprojekat;

public class BossEnemy extends Enemy {
	private String type;
	private int x;
	private int y;
	private int height;
	private int width;
	private int damage;

	public BossEnemy(int x, int y, int width, int height, String type, int damage, String type2, int x2, int y2,
			int height2, int width2, int damage2) {
		super(x, y, width, height, type, damage);
		type = type2;
		x = x2;
		y = y2;
		height = height2;
		width = width2;
		damage = damage2;
	}

	@Override
	public int getDamage() {
		return super.getDamage() * 2;
	}

	@Override
	public String toString() {
		return "BossEnemy [type=" + type + ", x=" + x + ", y=" + y + ", height=" + height + ", width=" + width
				+ ", damage=" + damage + "]";
	}

}