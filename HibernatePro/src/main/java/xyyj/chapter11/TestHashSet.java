package xyyj.chapter11;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHashSet {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSize() {
        Set<String> set = new HashSet<String>();
        String s1 = new String("Hello");
        String s2 = s1;
        String s3 = new String("World");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        assertEquals(set.size(), 2);
        
        String s4 = new String("Hello");
        set.add(s4);
        assertEquals(set.size(), 2);
    }
    
    @Test
    public void testMonkeyHashSet() {
        Set<Monkey> set = new HashSet<Monkey>();
        Monkey monkey1 = new Monkey(15, "TOM");
        Monkey monkey2 = new Monkey(15, "TOM");
        
        set.add(monkey1);
        set.add(monkey2);
        
        assertEquals(set.size(), 1);
    }
    
    @Test
    public void testTreeSet() {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(new Integer(8));
        set.add(new Integer(7));
        set.add(new Integer(6));
        set.add(new Integer(9));
        
        Iterator<Integer> itor = set.iterator();
        while (itor.hasNext()) {
            Integer integer = (Integer) itor.next();
            
            System.out.println(integer);
        }
    }

}
