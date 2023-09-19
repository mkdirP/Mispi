import data.Entry;
import data.Validator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntryTest {
    Entry entry1 = new Entry(1.0,2.0,3.0);
    Entry entry2 = new Entry(3.1,40.0,3.0);
    Entry entry3 = new Entry(1.0,2.0,2.5);

    @BeforeClass
    public static void go(){
        System.out.print("JunitTestValidator started\n");
    }
    @Test
    public void test_validate_value(){
        System.out.print("Testing test_validate_value...\n");
        assertEquals(Validator.validateValues(entry1),true);
        assertEquals(Validator.validateValues(entry2), false);
        assertEquals(Validator.validateValues(entry3), true);
    }
    @Test
    public void test_validate_range(){
        System.out.print("Testing test_validate_range...\n");
        assertEquals(Validator.validateRange(entry1.getX(),entry1.getY(),entry1.getR()),true);
        assertEquals(Validator.validateRange(entry2.getX(),entry2.getY(),entry2.getR()),false);
        assertEquals(Validator.validateRange(entry3.getX(),entry3.getY(),entry3.getR()),true);
    }
    @AfterClass
    public static void start(){
        System.out.print("JunitTestValidator ended\n");
    }

}
