package middle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import middle.testhreads.MyThreadPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import primary.entity.Hero;

public class HelloMiddle {

    static Logger logger = LogManager.getLogger(HelloMiddle.class);

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
	    logger.debug("迭代器； " + ith.next());
	    // System.err.println("迭代器； " + ith.next());
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

    void muluteThread() {
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

    static void testThreadCi() {
	// 线程池应该叫任务池才合理才对。
	int NUM = 10;
	MyThreadPool wode = new MyThreadPool(4);
	logger.fatal("生成线程池，等待2s再创建任务以便所有空线程初始化完成！");
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	logger.fatal("等待2s后！开始创建任务");
	for (int i = 0; i < NUM; i++) {
	    final int itmp = i;
	    Runnable task = new Runnable() {
		@Override
		public void run() {
		    // TODO Auto-generated method stub
		    logger.warn("这里执行真正的任务,执行任务时间0.5s;" + itmp);
		    try {
			Thread.sleep(500);
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
	    };
	    logger.fatal("每隔1s，在任务队列尾部添加 任务" + i);
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    wode.add(task, "task" + i);
	    ThreadPoolExecutor threads = new ThreadPoolExecutor(2, 3, 3,
		    TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
	    // threads.execute(task);

	}

    }

    public static void connectMssql() {
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=sample";
	String connectDbUrl = "jdbc:sqlserver://112.24.14.203:1433;"
		+ "databaseName=GroupData1"; // 连接服务器和数据库GroupData1
					     // ;integratedSecurity=true;
	String userName = "sa"; // 默认用户名
	String userPwd = "123456"; // 密码

	// Declare the JDBC objects.
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	// Establish the connection.
	try {
	    // 建立文件输出流 和 StringBuilder 保存数据库结果，以便将数据库结果写入txt文本
	    File cun = new File("./data/b.txt");
	    FileWriter fWriter = new FileWriter(cun, true);
	    StringBuilder sbBuilder = new StringBuilder("开始\r\n");
	    if (cun.isFile()) {
	    }

	    Class.forName(driverName);// 使用反射 加载JDBC驱动
	    con = DriverManager.getConnection(connectDbUrl, userName, userPwd);

	    logger.info("开始连接数据库，并且搜索！");
	    // Create and execute an SQL statement that returns some data.
	    String SQL = "SELECT top 10 * FROM Group2";
	    stmt = con.createStatement();
	    rs = stmt.executeQuery(SQL);

	    // Iterate through the data in the result set and display it.
	    while (rs.next()) {
		sbBuilder.append(rs.getString(1) + ";" + rs.getString(2) + ";"
			+ rs.getString(3) + ";" + rs.getString(4) + ";"
			+ rs.getString(5) + ";" + rs.getString(6) + ";"
			+ rs.getString(7) + "\r\n");
		// logger.info(rs.getString(7));
	    }
	    logger.info("数据库遍历成功，开始写入文件");

	    sbBuilder.append("结束\r\n");
	    fWriter.write(sbBuilder.toString());
	    fWriter.write(sbBuilder.toString(), 10, 100);
	    fWriter.close();
	    logger.info("文件写入成功！");

	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (rs != null)
		try {
		    rs.close();
		} catch (Exception e) {
		}
	    if (stmt != null)
		try {
		    stmt.close();
		} catch (Exception e) {
		}
	    if (con != null)
		try {
		    con.close();
		} catch (Exception e) {
		}
	}

    }

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	logger.info("进入中级教程： 下面是容器/集合的实验： ");
	// testArrList();
	// testList();
	// testMap();
	// testCompare();
	HelloMiddle helloMiddle = new HelloMiddle();
	// helloMiddle.muluteThread(); // 解决static方法中无法调用非静态方法的问题。
	// testThreadCi();
	connectMssql();
    }
}
