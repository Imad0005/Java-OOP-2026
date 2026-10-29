// Miloš Petrović 24/151
// Nebojša Pješčić 23/001
// Imad Guberinić 24/135
// Almir Pelinković 23/133
package grupniprojekat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private Player player;
	private Enemy[] enemies;
	private List<String> eventLog = new ArrayList<>();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Enemy[] getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemy[] enemies) {
		this.enemies = enemies;
	}

	public List<String> getEventLog() {
		return eventLog;
	}

	public void setEventLog(List<String> eventLog) {
		this.eventLog = eventLog;
	}

	public boolean checkCollison(Player p, Enemy e) {
		return p.getX() < e.getX() + e.getWidth()
		&& p.getX() + p.getWidth() > e.getX()
		&& p.getY() < e.getY() + e.getHeight()
		&& p.getY() + p.getHeight() > e.getY();
	}
	
	public void decreaseHealth(Player p, Enemy e) {
		int stariHealth = p.getHealth();
		int noviHealth = Math.max(0, stariHealth - e.getDamage());
	
		p.setHealth(noviHealth);
		
		eventLog.add("HIT: " + p.getName() + " by " + e.getType()
		+ " for " + e.getDamage()
		+ " -> HP " + stariHealth + " -> " + p.getHealth());
	}
	
	public void addEnemy(Enemy e) {
		if (e == null) {				
			return;
		}
	
		if (enemies == null) {
			enemies = new Enemy[0];
		}
	
		enemies = Arrays.copyOf(enemies, enemies.length + 1);
		enemies[enemies.length - 1] = e;
	
		eventLog.add("SPAWN: " + e.getType() + " at (" + e.getX() + "," + e.getY() + ")");
	}
	
	
	public void addEnemyFromString(String data) {
		if (data == null || data.trim().isEmpty()) return;
		
		String[] dijelovi = data.split(";");
		String tip = dijelovi[0];
		
		String[] xy = dijelovi[1].split(",");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		
		String[] wh = dijelovi[2].split("x");
		int width = Integer.parseInt(wh[0]);
		int height = Integer.parseInt(wh[1]);
		
		int damage = Integer.parseInt(dijelovi[3]);

		Enemy e = new Enemy(height, x, y, width, tip, damage);
		addEnemy(e);
	}
	
	public List<Enemy> findEnemiesByType(String upit) {
		List<Enemy> rezultat = new ArrayList<>();
	
		if (upit == null || upit.trim().isEmpty()) {
			return rezultat;
		}
	
		String trazeno = upit.trim().toLowerCase();
	
		for (Enemy e : enemies) {
			if (e.getType().toLowerCase().contains(trazeno)) {
				rezultat.add(e);
			}
		}
		return rezultat;
	}
	
	public List<Enemy> collidingWithPlayer() {
		List<Enemy> sudari = new ArrayList<>();

		if (player == null || enemies == null) {
			return sudari;
		}

		for (Enemy e : enemies) {
			if (e != null && checkCollison(player, e)) {
				sudari.add(e);
			}
		}
		return sudari;
	}
	
	public void resolveCollisions() {
		List<Enemy> sudari = collidingWithPlayer();

		for (Enemy e : sudari) {
			decreaseHealth(player, e);
		}
	}
	
	
	public static void main(String[] args) {
		Player p = new Player(32, 10, 5, 32, "  miloš petrović  ", 85);
		Game igra = new Game();
		igra.setPlayer(p);

		Enemy e1 = new Enemy(16, 12, 5, 16, "Goblin", 20);
		igra.addEnemy(e1);

		igra.addEnemyFromString("BossGoblin;12,5;16x16;30");

		System.out.println("=== PRIJE KOLIZIJE ===");
		System.out.println(igra.getPlayer());

		igra.resolveCollisions();

		System.out.println("\n=== POSLIJE KOLIZIJE ===");
		System.out.println(igra.getPlayer());

		System.out.println("\n=== PRETRAGA ZA 'gob' ===");
		List<Enemy> pronadjeni = igra.findEnemiesByType("gob");
		for (Enemy en : pronadjeni) {
			System.out.println(en);
		}

		System.out.println("\n=== DNEVNIK DOGAĐAJA (eventLog) ===");
		for (String dogadjaj : igra.getEventLog()) {
			System.out.println(dogadjaj);
		}
	}
}