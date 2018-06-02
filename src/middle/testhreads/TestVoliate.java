
package middle.testhreads;

public class TestVoliate {
    volatile boolean statu = false;
    int num = 0;
    static int allnum = 0;

    void plus() {
	statu = true;
	int j = 0;
	System.err.println("1");
	try {
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	}
	for (int i = 0; i < 10000; i++) {
	    j = i + 1;
	}
	System.err.println("2");
    }

    void run() {
	if (statu) {
	    System.out.println("进入if了，");
	} else {
	    System.out.println("进入else了， false了，");
	}
    }

}
