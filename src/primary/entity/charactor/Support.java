package primary.entity.charactor;

import primary.entity.Hero;

public class Support extends Hero implements Healer {

	public Support(String name, float hp, int speed) {
		super(name, hp, speed);
		// TODO 自动生成的构造函数存根
	}

	public void keng() {
		System.out.println("support keng!");
	}

	public void keng2() {
		super.keng();
	}
    public void finalize(){
        System.out.println("这个 类Support 正在被回收");
    }
	@Override
	public void heal() {
		// TODO 自动生成的方法存根
		System.out.println("加了一口血！");
	}

	// 隐藏父类的battleWin方法
	public static void battleWin() {
		System.out.println("Support hero battle win");
	}
}
