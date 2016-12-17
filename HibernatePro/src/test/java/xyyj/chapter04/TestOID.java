package xyyj.chapter04;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOID {
	BusinessService bs = null;

	@Before
	public void setUp() throws Exception {
		bs = new BusinessService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIncrement() {
		bs.saveObject(new IncrementTester("Test1"));
		bs.saveObject(new IncrementTester("Test2"));
		bs.saveObject(new IncrementTester("Test3"));
		
		List<IncrementTester> list = bs.findAll(IncrementTester.class);
		for (IncrementTester tester : list) {
			System.out.println(tester);
		}
		
		//bs.deleteAll(IncrementTester.class);
	}
	
	@Test
	public void testIdentity() {
		bs.saveObject(new IdentifyTester("Test1"));
		bs.saveObject(new IdentifyTester("Test2"));
		bs.saveObject(new IdentifyTester("Test2"));

		List<IdentifyTester> list = bs.findAll(IdentifyTester.class);
		for (IdentifyTester tester : list) {
			System.out.println(tester);
		}
	}
	
	@Test
	public void testHilo() {
		bs.saveObject(new HiloTester("Test1"));
		bs.saveObject(new HiloTester("Test2"));
		bs.saveObject(new HiloTester("Test2"));

		List<HiloTester> list = bs.findAll(HiloTester.class);
		for (HiloTester tester : list) {
			System.out.println(tester);
		}
	}
	
	@Test
	public void testNative() {
		bs.saveObject(new NativeTest("Test1"));
		bs.saveObject(new NativeTest("Test2"));
		bs.saveObject(new NativeTest("Test2"));

		List<NativeTest> list = bs.findAll(NativeTest.class);
		for (NativeTest tester : list) {
			System.out.println(tester);
		}
	}

}
