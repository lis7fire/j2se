
package middle.testhreads;

import primary.entity.Hero;

public class MainClass {

    static void siLock() {

	final Object o1 = new Object();
	final Object o2 = new Object();
	final Object o3 = new Object();
	final Thread t1 = new Thread() {
	    @Override
	    public void run() {
		// TODO 自动生成的方法存根
		synchronized (o1) {
		    try {
			sleep(500);
		    } catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		    }
		    synchronized (o3) {
			System.out.println(this.getName() + "开始");
			synchronized (o2) {
			}
		    }
		}
	    }
	};
	final Thread t2 = new Thread() {
	    @Override
	    public void run() {
		// TODO 自动生成的方法存根
		synchronized (o3) {
		    try {
			sleep(500);
		    } catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		    }
		    synchronized (o2) {
			synchronized (o1) {
			    System.out.println(this.getName() + "开始");
			}
		    }
		}
	    }
	};
	final Thread t3 = new Thread() {
	    @Override
	    public void run() {
		// TODO 自动生成的方法存根
		synchronized (o2) {
		    try {
			sleep(1500);
		    } catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		    }
		    System.out.println(this.getName() + "开始");
		    synchronized (o3) {
			synchronized (o1) {
			}
		    }
		}
	    }
	};
	t1.start();
	t2.start();
	t3.start();

    }

    static void testxunhuan() {
	final Hero gailun1 = new Hero("小魔法师", 700, 50);
	final Hero gailun2 = new Hero("赏金        ", 1000, 50);
	final Hero gailun3 = new Hero("盖伦        ", 500, 50);

	KillThread kill1 = new KillThread(gailun1, gailun3, 100);
	KillThread kill2 = new KillThread(gailun2, gailun3, 50);
	// kill1.start();
	// kill2.start();

	// new Thread(new TestThreadRunnable(gailun3, "xiancheng1")).start();
	// new Thread(new TestThreadRunnable(gailun1, "xiancheng1")).start();

	new Thread() {
	    public void run() {
		while (true) {
		    gailun3.huixue(100);
		}
	    };
	}.start();

	new Thread() {
	    public void run() {
		while (true) {
		    try {
			sleep(300);
		    } catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		    }
		    System.out.println("diaoxie1:");
		    gailun3.redHp();
		}

	    };
	}.start();
	new Thread() {
	    public void run() {
		while (true) {
		    try {
			sleep(500);
		    } catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		    }
		    System.out.println("diaoxie2:");
		    gailun3.redHp();
		}
		
	    };
	}.start();

	for (int i = 0; i < 0; i++) {
	    new Thread() {
		public void run() {
		    while (gailun2.getHp() > 950) {
			gailun2.redHp();
		    }
		};
	    }.start();
	}

	while (gailun1.getHp() == 1) {
	    try {
		Thread.sleep(500);
	    } catch (InterruptedException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	    }
	}
	System.out.println("小魔法师准备！");
	new Thread() {
	    public void run() {
		gailun1.redHp();
	    };
	}.start();
	new Thread() {
	    public void run() {
		gailun1.huixue(500);
	    };
	}.start();

	System.out.println(gailun1);
	System.out.println(gailun2);
	System.out.println(gailun3);
    }

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	// siLock();
	testxunhuan();
	final TestVoliate volate = new TestVoliate();
	new Thread() {
	    public void run() {
		volate.plus();
	    };
	}.start();
	new Thread() {
	    public void run() {
		volate.run();
	    };
	}.start();
    }

}
