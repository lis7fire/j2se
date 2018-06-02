
package middle.testhreads;

import primary.entity.Hero;

public class TestThreadRunnable implements Runnable {
    String name;
    Hero hero1;

    public TestThreadRunnable(Hero h1, String threadName) {
	// TODO 自动生成的构造函数存根
	this.hero1 = h1;
	this.name = threadName;
    }

    @Override
    public void run() {
	// TODO 自动生成的方法存根
	// System.out.println("Runnable: " + this.name);
	while (true) {
	    if (hero1.getHp() > 250) {
		try {
		    hero1.redHp();
		    System.out.println("HP量很大，休息一会");
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    // TODO 自动生成的 catch 块
		    e.printStackTrace();
		}
	    } else {
		hero1.huiHp();
	    }
	}

    }

}
