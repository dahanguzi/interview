package com.yuantel;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestVolitale {
	
	//规约、收集
	@Test
	public void test1() {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer sum = list.stream().reduce(0, (x,y) -> x + y);
		System.out.println(sum);
		
	}
}
