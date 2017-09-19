package util;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.utils.SequenceUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class SequenceTest {
	
	@Test
	public void  getSequence(){
		long id = SequenceUtil.getSequence().nextId();
		System.out.println(id);
	}

}
