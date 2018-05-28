package primary;

import java.util.Arrays;

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
		int[] a = new int[] { 6, 2, 7, 3, 5 };
		int[] b = new int[10];
		int c = (int) (Math.random() * 100);
		Arrays.toString(a);
		System.arraycopy(a, 0, b, 1, 3);
		System.out.println(Arrays.toString(b));
		b = Arrays.copyOfRange(a, 0, 7);
		System.out.println(Arrays.toString(b));
		Arrays.sort(b);
		c=Arrays.binarySearch(b,6);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.equals(a, b));
		Arrays.fill(b, 'q');
		c=Arrays.binarySearch(b,'q');
		System.out.println(c);

	}

	static float bmi(float high, float haven) {
		return haven / (high * high);
	}

}
