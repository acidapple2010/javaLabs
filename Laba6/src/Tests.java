
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {

	GenericList<String> genericList = new GenericList<String>(10);

	@Before
	public void init(){
		genericList.add("джигурда");
		genericList.add("джигурда2");
	}

	@Test
	public void test1() throws Exception {
		assertEquals(genericList.size(), 10);
	}

	@Test(timeout = 10)
	public void test2() throws InterruptedException {
		Thread.sleep(5);
	}

	@Test
	public void test3() throws Exception {
		genericList.removeAll();
		System.out.println(genericList.occupied());
	}


}