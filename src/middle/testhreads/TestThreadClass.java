
package middle.testhreads;

import primary.entity.Hero;

public class TestThreadClass extends Thread {
    Hero gailun1 = new Hero("gailun1", 1000, 50);
    Hero gailun2 = new Hero("gailun2", 700, 50);
    Hero gailun3 = new Hero("gailun3", 1500, 50);

    @Override
    public void run() {
	// TODO 自动生成的方法存根
	super.run();
	gailun1.attach(gailun3, 50);
	gailun2.attach(gailun3, 50);
    }
}
