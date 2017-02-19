import com.buxiaoxia.Application;
import com.buxiaoxia.business.entity.User;
import com.buxiaoxia.business.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created on 2017-02-19 22:07.
 * author xiaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindSameUser(){
		User user = userRepository.findByName("夏葳");
		assertEquals(user.getName(),userRepository.findByName("夏葳").getName());
		assertEquals(user.getName(),userRepository.findByName("夏葳").getName());
		assertEquals(user.getName(),userRepository.findByName("夏葳").getName());
		assertEquals(user.getName(),userRepository.findByName("夏葳").getName());
		assertEquals(user.getName(),userRepository.findByName("夏葳").getName());
	}

}
