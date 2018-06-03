package middle.testhreads;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThreadPool {
    Logger logger = LogManager.getLogger(getClass());
    int num;
    LinkedList<Runnable> pools = new LinkedList<>();
    String currnTaskName;

    public MyThreadPool(int num) {
	this.num = num;
	synchronized (pools) { // 这种初始化的时候应该不需要对pools加锁
	    // 开启线程
	    for (int i = 0; i < num; i++) {
		new NewThread("消费者线程 " + i).start();
	    }
	}

    }

    public void add(Runnable r, String taskName) {
	this.currnTaskName = taskName;
	synchronized (pools) {
	    pools.addLast(r);
	    // pools.notifyAll();
	    pools.notify();
	}
    }

    class NewThread extends Thread {
	public NewThread(String tname) {
	    super(tname);
	    // TODO Auto-generated constructor stub
	}

	Runnable task;

	@Override
	public void run() {
	    // TODO Auto-generated method stub
	    logger.info("启动空线程：" + this.getName());
	    while (true) {
		synchronized (pools) {
		    while (pools.isEmpty()) {
			logger.error("任务池空了，wait等待任务中" + this.getName());
			try {
			    pools.wait();
			} catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    }
		    task = pools.removeLast();
		    // pools.notifyAll();
		}
		logger.debug(this.getName() + "线程从任务队列头部获取到任务，并且开始执行任务"
			+ currnTaskName);
		task.run();
	    }
	}
    }

}
