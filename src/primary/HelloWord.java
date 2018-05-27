package primary;

import primary.entity.Hero;

public class HelloWord {
	Hero teemo = new Hero("teemo");

	public int method1(final int j) {
		// j = 5; //这个能否执行？
		return j;
	}

	public static void main(String[] args) {
		Hero garen = new Hero("garen", 1000, 50);
		// TODO Auto-generated method stub
		System.out.println("Hello Word!" + garen.getHp());

		System.out.println(bmi(1.61f, 50));
		int xuepin = 100;
		garen.huixue(xuepin);
		System.out.println("" + garen.getHp());
		garen.setHp(30);
		System.out.println("掉血了：" + garen.getHp());
		garen.revive(garen);
		System.out.println("复活之后：" + garen.getHp());

	}

	static float bmi(float high, float haven) {
		return haven / (high * high);
	}

}
