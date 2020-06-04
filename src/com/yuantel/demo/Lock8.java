package com.yuantel.demo;

import java.util.concurrent.TimeUnit;

/*
 * 1、标准访问，同一个对象访问两个同步方法？	先打印短信
 * 2、短信暂停4s，先打印短信还是邮件？	先打印短信
 * 3、新增普通（未加锁）开机方法，先打印短信还是邮件？ 先打印开机
 * 4、有两部手机，先打印短信还是邮件？	先打印邮件
 * 5、静态同步方法，1部手机，先打印短信还是邮件？	先打印短信
 * 6、静态同步方法，2部手机，先打印短信还是邮件？	先打印短信
 * 7、1个普通同步方法，1个静态同步方法，1部手机，先打印短信还是邮件？	先打印邮件
 * 8、1个普通同步方法，1个静态同步方法，2部手机，先打印短信还是邮件？	先打印邮件
 *
 * 
 * */

public class Lock8 {

	public static void main(String[] args) {
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();

		new Thread(new Runnable() {

			@Override
			public void run() {

				phone1.sendMsg();
			}
		}, "A").start();

		// 暂停500ms保证线程A能够先运行起来
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		new Thread(new Runnable() {

			@Override
			public void run() {
				phone2.sendEmail();
				//phone2.openPhone();
			}
		}, "B").start();

	}

}

class Phone {

	public static synchronized void sendMsg() {

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("**********sendMsg");
	}

	public synchronized void sendEmail() {
		System.out.println("**********sendEmail");
	}
	
	public  void openPhone() {
		System.out.println("**********openPhone");
	}
}
