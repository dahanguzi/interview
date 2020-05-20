package com.yuantel.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class ForkJoinPoolDemo {
	//分支合并框架
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		
		ForkJoinTask<Long> task = new ForkJoinPoolSumCalculate(0L,100000000L);
		
		Long sum = pool.invoke(task);
		
		
		System.out.println("计算结果为："+sum);
	}
	
	//java8新特性
	@Test
	public void test1() {
		
		long sum = LongStream.rangeClosed(0L, 100000000L).parallel().reduce(0L, Long::sum);
		System.out.println(sum);
	}
	
}

class ForkJoinPoolSumCalculate extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long start;
	private long end;
	
	private static final long THURSHOLD = 10000L;//设置临界值
	
	public ForkJoinPoolSumCalculate(long start,long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		
		if(length <= THURSHOLD) {
			long sum = 0L;
			for(long i = start;i <= end;i++) {
				sum += i;
			}
			return sum;
		}else {
			long middle = (start + end)/2;
			ForkJoinPoolSumCalculate left = new ForkJoinPoolSumCalculate(start,middle);
			left.fork();
			
			ForkJoinPoolSumCalculate right = new ForkJoinPoolSumCalculate(middle+1,end);
			right.fork();
			
			return left.join() + right.join();
		}
	}
	
}
