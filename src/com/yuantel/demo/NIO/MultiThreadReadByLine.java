package com.yuantel.demo.NIO;

public class MultiThreadReadByLine {

	public static void main(String[] args) {
		
		long beginTime = System.currentTimeMillis();
		System.out.println("开始时间："+beginTime);
		FileReaderByLine fileReader = new FileReaderByLine("C:\\Users\\Administrator\\Desktop\\20200601_day_CONSUME_2YY_test.txt", 100, 4);
		fileReader.registerHanlder(new FileLineDataHandler());
		fileReader.startRead();
		long endTime = System.currentTimeMillis();
		System.out.println("结束时间："+endTime);
		System.out.println("总计耗时："+(endTime-beginTime));
	}

}
