package com.jliu.xyyj.chapter02;


import java.util.List;

import org.junit.Test;

import xyyj.chapter02.BusinessService;
import xyyj.chapter02.Monkey;

public class MonkeyTest {

	@Test
	public void test() {
		BusinessService bs = new BusinessService();
		
		bs.saveMonkey(new Monkey("智多星", 1, 'M'));
		bs.saveMonkey(new Monkey("孙小圣", 10, 'M'));
		
		List<Monkey> list = bs.findAllMonkeys();
		for (Monkey monkey : list) {
			System.out.println(monkey);
		}
		
		Monkey monkey = bs.getMonkeyById(new Long(1));
		System.out.println(monkey);
	}

}
