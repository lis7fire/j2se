package primary.entity;

public class Hero {
	private int heroId;
	String name;
	int moveSpeed;
	float hp, hujia;
	String sayAfterDead = "wo ri";
	static float hpUp = 9999;

	public Hero(String name) {
		this.name = name;
	}

	public Hero(String name, float hp) {
		this(name);
		this.hp = hp;
	}

	public Hero(String name, float hp, int speed) {
		this(name, hp);
		this.moveSpeed = speed;
		this.hujia = 50;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getHp() {
		return hp;
	}

	void addSpeed(int speedplus) {
		this.moveSpeed += speedplus;
	}

	void keng() {
		System.out.println("我坑队友了！");
	}

	void legendary() {
		System.out.println("我超神了！");
	}

	// 回血
	public void huixue(int xp) {
		this.hp = this.hp + xp;
		// 回血完毕后，血瓶=0
		xp = 0;
	}

	// 复活
	public void revive(Hero h) {
		// h = new Hero("盖伦", 1000);
		h.setHp(1000);
	}

	public static void main(String[] args) {
		Hero name1 = new Hero("gailun");
		name1.moveSpeed = 12;
		name1.hp = 3000;
		name1.hujia = 300;
		System.out.println(name1);
	}
}
