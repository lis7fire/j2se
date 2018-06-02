
package primary.entity;

import java.io.Serializable;

public class Hero implements Serializable {

    private int heroId;

    String name;

    int moveSpeed;

    float hp, hujia;

    String sayAfterDead = "wo ri";

    static float hpUp = 9999;

    public Hero(String name) {
	this.name = name;
    }

    public Hero(String name, float hp) {
	this(name);
	this.hp = hp;
    }

    public Hero(String name, float hp, int speed) {
	this(name, hp);
	this.moveSpeed = speed;
	this.hujia = 50;
    }

    public void setHp(float hp) {
	this.hp = hp;
    }

    public float getHp() {
	return hp;
    }

    @Override
    public String toString() {
	return "Hero [英雄名字： " + name + ", moveSpeed=" + moveSpeed + ", hp=" + hp
		+ ", hujia=" + hujia + ", sayAfterDead=" + sayAfterDead + "]";
    }

    void addSpeed(int speedplus) {
	this.moveSpeed += speedplus;
    }

    public String attach(Hero hitedHero, float reduceHp) {
	String result;
	if (hitedHero.hp > reduceHp) {

	    hitedHero.hp = hitedHero.hp - reduceHp;
	    result = this.name + "正在攻击：" + hitedHero.name + "这个英雄已经掉血数量："
		    + reduceHp + "； 剩余血量：" + hitedHero.hp;
	} else
	    result = hitedHero.name + "这个英雄已经死了，无法掉血！";

	return result;
    }

    public synchronized void huiHp() {// 自动回血
	this.hp += 10;
	System.out.println(this.name + "自动回血中。。。现在血量：" + this.hp);

    }

    public void redHp() {// 自动掉血
	synchronized (this) {
	    this.hp -= 10;
	    if (this.hp < 50) {
		this.notify();
	    }
	    System.out.println(this.name + "自动掉血中。。。现在血量：" + this.hp);
	}
    }

    public void keng() {
	System.out.println("Hero 我坑队友了！");
    }

    void legendary() {
	System.out.println("我超神了！");
    }

    // 回血
    public synchronized void huixue(int xp) {
	this.hp = this.hp + xp;
	System.out.println(this.name + "喝了药瓶： " + xp + " 现在血量：" + this.hp);
	// 回血完毕后，血瓶=0
	xp = 0;
	try {
	    this.wait();
	} catch (InterruptedException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	}

    }

    // 隐藏父类的battleWin方法
    public static void battleWin() {
	System.out.println("Hero battle win");
    }

    // 复活
    public void revive(Hero h) {
	// h = new Hero("盖伦", 1000);
	h.setHp(1000);
    }

    public void finalize() {
	System.out.println("这个 类Hero 正在被回收");
    }

    public static void main(String[] args) {
	Hero name1 = new Hero("gailun");
	name1.moveSpeed = 12;
	name1.hp = 3000;
	name1.hujia = 300;
	System.out.println(name1);
    }
}
