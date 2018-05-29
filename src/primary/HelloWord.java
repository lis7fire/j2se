package primary;

import java.util.Arrays;
import java.util.Scanner;

import primary.entity.Hero;
import primary.entity.charactor.Support;

public class HelloWord {
	Hero teemo = new Hero("teemo");

	public int method1(final int j) {
		// j = 5; //杩欎釜鑳藉惁鎵ц锛�
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
		System.out.println("获取血量" + garen.getHp());
		garen.revive(garen);
		System.out.println("新的血量" + garen.getHp());
		int[] a = new int[] { 6, 2, 7, 3, 5 };
		int[] b = new int[10];
		int c = (int) (Math.random() * 100);
		Arrays.toString(a);
		System.arraycopy(a, 0, b, 1, 3);
		System.out.println(Arrays.toString(b));
		b = Arrays.copyOfRange(a, 0, 7);
		System.out.println(Arrays.toString(b));
		Arrays.sort(b);
		c = Arrays.binarySearch(b, 6);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.equals(a, b));
		Arrays.fill(b, 'q');
		c = Arrays.binarySearch(b, 'q');
		System.out.println(c);
		Hero hhh = new Support("ggg", 100, 500);
		hhh.keng();

		Support sss = (Support) hhh; // new Support("sss", 100, 30);
		sss.keng2();

		System.out.println(hhh instanceof Support);
		System.out.println(hhh.getClass());
		byte cc = 'c';
		Byte byte1 = cc;
		String str = "das";
		System.out.println(Float.parseFloat("3.14e2"));
		System.out.println("valueof : " + String.valueOf(3.1e4f));
		double e;
		int n = Integer.MAX_VALUE;
		e = Math.pow(1 + 1d/ n, n);
		System.err.println(e);
		System.out.println(Math.E);
		Scanner input =new Scanner(System.in);
		System.out.println("请输入整数：");
		int in1=input.nextInt();
//		System.out.println("请输入字串：");
		input.nextLine();//占位换行符
		String in2=input.nextLine();
		System.out.println("字串： "+in2);
		char ch='q';
		Character.toString(ch);		
		str.toCharArray();
		
	}

	static float bmi(float high, float haven) {
		return haven / (high * high);
	}

}
