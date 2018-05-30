
package middle;

import java.util.Random;

public class MulteThread extends Thread {
    private String name;
    private int sum;

    MulteThread(String na, int s) {
	this.name = na;
	this.sum = s;
    }
    public void run() {
	// TODO 自动生成的方法存根
	synchronized (name) {

	}
	while (sum > 0) {
	    System.out.println(name + " i am in 多线程 :　" + sum);
	    sum -= new Random().nextInt(100);
	}
    }

}
