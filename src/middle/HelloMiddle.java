package middle;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import primary.entity.Hero;

public class HelloMiddle {

    static void testArrList() {

	List<Hero> arrlist = new ArrayList<Hero>();
	Hero gairenHero = new Hero("gairen", 1000, 30);
	Hero timoHero = new Hero("提莫", 700, 50);
	arrlist.add(gairenHero);
	arrlist.add(timoHero);
	arrlist.iterator();
	System.out.println(arrlist.get(0));
	System.out.println(arrlist.contains(gairenHero));
	System.out.println(arrlist.contains(timoHero));
	System.out.println("打印arrlist: " + arrlist);
	Object[] tmpObjects = arrlist.toArray();
	for (Object object : tmpObjects) {
	    System.err.println(object);
	}
	arrlist.clear();
    }

    static void testList() {
	List testNone = new ArrayList();
	testNone.add(0);
	testNone.add('a');
	testNone.add("hah哈哈");
	System.err.println(testNone);
	Iterator ith = testNone.iterator();
	while (ith.hasNext()) {
	    System.err.println("迭代器； " + ith.next());
	}
	LinkedList linkList = new LinkedList();
	linkList.add(6);
	linkList.addFirst(3);
	linkList.add(1);
	linkList.addLast(10);
	linkList.add(5);
	linkList.add(5);
	linkList.add(5);
	System.out.println(linkList);
	// linkList.removeFirst();
	// linkList.remove();
	linkList.poll();
	System.out.println(linkList.peek());
	// Collections.sort(linkList);
	Collections.rotate(linkList, -1);
	Collections.synchronizedList(linkList);
	System.out.println("打印linklist ： " + linkList);
	byte[] addr = new byte[64];
	try {
	    Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
	    InetAddress ip = InetAddress.getLocalHost();
	    System.out.println(ip);
	    System.out.println(p.getInputStream().read());
	} catch (UnknownHostException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	}
    }

    @SuppressWarnings("deprecation")
    static void testMap() {
	ArrayList<Hero> heros = new ArrayList<>();
	for (int i = 0; i < 5; i++) {
	    float aa = (float) Math.random() * 100;
	    heros.add(new Hero("英雄" + i, (float) Math.random() * 1000,
		    (int) Math.random() * 300));
	}
	HashMap<String, Hero> testHashMap = new HashMap<>();
	testHashMap.hashCode();
	Hashtable<String, Integer> hashtable = new Hashtable<>();
	hashtable.put("hah", 2);
	hashtable.put("null", 2);
	testHashMap.put("test0", heros.get(0));
	testHashMap.put("test1", heros.get(1));
	testHashMap.put("test3", heros.get(3));
	testHashMap.put("test3", heros.get(1));
	testHashMap.put(null, heros.get(1));
	testHashMap.keySet();
	System.out.println(testHashMap);
	System.out.println(testHashMap.get("test2"));
	System.out.println(testHashMap.get("test3"));
	System.out.println(new Date().getTime());
	System.out.println(new Date(-1000));

	Set<Integer> haSet = new HashSet<>();
	haSet.add(4);
	haSet.add(100);
	haSet.add(70);
	haSet.add(70);
	haSet.add(70);
	haSet.add(5);
	System.out.println("hash: " + haSet.hashCode());
	for (Integer integer : haSet) {
	    System.err.println(integer);
	}

	Iterator<Integer> iterator = haSet.iterator();
	while (iterator.hasNext()) {
	    Integer integer = (Integer) iterator.next();
	    System.out.println("迭代器： " + integer);

	}

	Set<Integer> sets = new TreeSet<>();
	sets.add(15);
	sets.add(5);
	sets.add(11);
	sets.add(50);
	System.out.println(sets);

    }

    static void testCompare() {
	List<Integer> bijiaolist = new ArrayList<>();
	Collections.sort(bijiaolist, new Comparator<Integer>() {

	    @Override
	    public int compare(Integer o1, Integer o2) {
		// TODO 自动生成的方法存根
		return 0;
	    }

	});

	List<? extends Number> fanxing = new ArrayList<Integer>();

    }

    static void muluteThread() {
	MulteThread manythread1 = new MulteThread("t1", 600);
	MulteThread manythread2 = new MulteThread("t2", 900);
	manythread1.start();
	manythread2.start();
	// manythread1.setDaemon(true);
	try {
	    manythread1.sleep(3);
	} catch (InterruptedException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	System.out.println("进入中级教程： 下面是容器/集合的实验： ");
	// testArrList();
	testList();
	// testMap();
	testCompare();
	muluteThread();
    }

}
