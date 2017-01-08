package xyyj.chapter11;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArrayList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(3));
		list.add(new Integer(2));
		
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Collections.sort(list);
		
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() +  " ");
		}
		System.out.println();
	}

}
