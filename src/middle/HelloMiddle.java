package middle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.xml.crypto.Data;

import primary.entity.Hero;

public class HelloMiddle {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	System.out.println("进入中级教程： 下面是容器/集合的实验： ");
	testArrList();
	testList();
	testMap();
    }

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
	System.out.println(linkList);
	linkList.removeFirst();
	linkList.remove();
	linkList.peek();
	System.out.println(linkList.peek());
	System.out.println(linkList);
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
	testHashMap.put("test0", heros.get(0));
	testHashMap.put("test1", heros.get(1));
	testHashMap.put("test3", heros.get(3));
	testHashMap.put("test3", heros.get(1));
	System.out.println(testHashMap);
	System.out.println(testHashMap.get("test2"));
	System.out.println(testHashMap.get("test3"));
	System.out.println(new Date().getTime());
	System.out.println(new Date(-1000));
    }

}
