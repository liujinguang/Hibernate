package xyyj.chapter11;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMap {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Monday");
		map.put("2", "Tuesday");
		map.put("3", "Wendsday");
		map.put("4", "Thursday");
		System.out.println(map.get("2"));
	}
	
	@Test
	public void testTreeMap() {
		
		Map<String, String> map = new TreeMap<String, String>();
		map.put("1", "Monday");
		map.put("4", "Thursday");
		map.put("3", "Wendsday");
		map.put("2", "Tuesday");
		
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " " +  map.get(key));
		}
	}

}
