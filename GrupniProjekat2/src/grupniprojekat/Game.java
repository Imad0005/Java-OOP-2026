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

		public boolean checkCollison(Player p,Enemy e) {
			return p.getX() < e.getX() + e.getWidth()
			&& p.getX() + p.getWidth() > e.getX()
			&& p.getY() < e.getY() + e.getHeight()
			&& p.getY() + p.getHeight() > e.getY();

		}
		

		public void decreaseHealth(Player p, Enemy e) {
			int stariHealth = p.getHealth();
			int noviHealth = Math.max(0, stariHealth  - e.getDamage());
		
		p.setHealth(noviHealth);
		
		eventLog.add("HIT: " + p.getName() + " by " + e.getType()
		+ " for " + e.getDamage()
		+ " -> HP " + stariHealth + "-> " + p.getHealth());
		
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
		
		
		class Player {
			private String name;
			private int x;
			private int y;
			private int width;
			private int height;
			private int health;

			public Player(String name, int x, int y, int width, int height, int health) {
				setName(name);
				this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
				setHealth(health);
			}

			public String getName() {
				return name;
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

			public void setWidth(int width) {
				this.width = width;
			}

			public int getHeight() {
				return height;
			}

			public void setHeight(int height) {
				this.height = height;
			}

			public int getHealth() {
				return health;
			}

			// Health ne može biti manji od 0 ni veći od 100, zato ga ograničavamo
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
				return "Player[" + name + "] @ (" + x + "," + y
						+ ") " + width + "x" + height + " HP=" + health;
			}
		}

	class Enemy {
		private String type;
		private int x;
		private int y;
		private int width;
		private int height;
		private int damage;
		
		public Enemy(String type, int x, int y, int width, int height, int damage) {
				setType(type);
				this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
				setDamage(damage);
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				if (type == null || type.trim().isEmpty()) {
					throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan!");
				}

				this.type = type.trim().replaceAll("\\s+", " ");
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

			public void setWidth(int width) {
				this.width = width;
			}

			public int getHeight() {
				return height;
			}

			public void setHeight(int height) {
				this.height = height;
			}

			public int getDamage() {
				return damage;
			}

			// Damage ne može biti manji od 0 ni veći od 100, zato ga ograničavamo
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
				return "Enemy[" + type + "] @ (" + x + "," + y
						+ ") " + width + "x" + height + " DMG=" + damage;
			}
		}
	}

