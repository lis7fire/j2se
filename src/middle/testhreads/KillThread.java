
package middle.testhreads;

import primary.entity.Hero;

public class KillThread extends Thread {
    Hero hero1;
    Hero hero2;
    float redHp = 50.0f;
    Object oo = new Object();

    public KillThread(Hero h1, Hero h2) {
	this.hero1 = h1;
	this.hero2 = h2;
	// TODO 自动生成的构造函数存根
    }

    public KillThread(Hero h1, Hero h2, float hp) {
	this(h1, h2);
	this.redHp = hp;
	// TODO 自动生成的构造函数存根
    }

    @Override
    public void run() {
	// TODO 自动生成的方法存根
	while (hero2.getHp() > 250) {
	    try {
		Thread.sleep(300);
	    } catch (InterruptedException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	    }
	    synchronized (hero2) {
		System.out.println(this.hero1.attach(hero2, redHp));
	    }
	}
    }

}
