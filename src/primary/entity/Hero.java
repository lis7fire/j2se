package primary.entity;

public class Hero {
	String name;
	int moveSpeed;
	float hp, hujia;
	String sayAfterDead = "wo ri";

	public Hero(String name) {
		this.name = name;
		this.moveSpeed = 0;
		this.hp = 0;
		this.hujia = 0;
	}

	void addSped(int speedplus) {
		this.moveSpeed += speedplus;
	}

	void keng() {
		System.out.println("�ҿӶ����ˣ�");
	}

	void legendary() {

		System.out.println("�ҳ����ˣ�");
	}

	public static void main(String[] args) {
		Hero name1 = new Hero("gailun");
		name1.moveSpeed = 12;
		name1.hp = 3000;
		name1.hujia = 300;
		System.out.println(name1);
	}
}
