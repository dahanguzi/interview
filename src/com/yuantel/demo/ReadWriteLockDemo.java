package com.yuantel.demo;

public class ReadWriteLockDemo {
	// 上锁—>解锁（释放锁）
	/*
	 * 1、可重入锁（递归锁） 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获得该锁的代码，
	 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获得锁
	 * 
	 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
	 * 
	 * 2、多个线程同时读取一个资源没有问题，为了满足并发量，读取共享资源可以同时进行。
	 * 但是如果有一个线程要去写共享资源，就不应该再有其他线程可以对该资源进行读或写
	 * 
	 * 小总结： 读-读可以共存 读-写不能共存 写-写不能共存
	 */
	public static void main(String[] args) {

	}
}

class MyCache {
	
}