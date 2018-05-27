package primary;

import javax.sound.midi.MetaEventListener;

import primary.entity.Hero;

public class HelloWord {
	Hero teemo = new Hero("teemo");

	public int method1(final int j) {
		// j = 5; //这个能否执行？
		return j;
	}

	public static void main(String[] args) {

		Hero garen = new Hero("garen");
		// TODO Auto-generated method stub
		System.out.println("Hello Word!");
		int age = 2;
		byte b = 5;
		int i1 = 10;
		int i2 = 300;
		b = (byte) i1;
		b = (byte) i2;
		short a = 1;
		short c = 2;
		System.out.println(a + c);
		System.out.println(b + "   " + i2);

		System.out.println(bmi(1.61f, 50));

	}

	static float bmi(float high, float haven) {
		return haven / (high * high);
	}

}
