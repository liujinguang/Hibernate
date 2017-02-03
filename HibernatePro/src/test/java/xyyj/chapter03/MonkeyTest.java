package xyyj.chapter03;

import org.junit.Test;

import xyyj.chapter03.BusinessService;
import xyyj.chapter03.Monkey;

public class MonkeyTest {

	@Test
	public void test() {
		BusinessService bs = new BusinessService();

//		Monkey monkey = new Monkey("悟空", "孙", 'M', 500, "神通广大");
//		bs.saveMonkey(monkey);
		
		Monkey monkey = bs.getMonkeyById(new Long(1));
		System.out.println(monkey);
		monkey.setDescription("弼马温");
		bs.updateMonkey(monkey);
	}

}
