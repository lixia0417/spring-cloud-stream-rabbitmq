import com.buxiaoxia.Application;
import com.buxiaoxia.business.entity.User;
import com.buxiaoxia.business.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
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


	@Before
	public void before(){
		userRepository.save(new User("xw1","1",1));
		userRepository.save(new User("xw2","2",2));
		userRepository.save(new User("xw3","3",3));
		userRepository.save(new User("xw4","4",4));
		System.out.println("=============save=============");
	}

	@Test
	public void testFindSameUser(){
		User user = userRepository.findByName("xw1");
		assertEquals(user.getName(),userRepository.findByName("xw1").getName());
		assertEquals(user.getName(),userRepository.findByName("xw1").getName());
	}

	@Test
	public void testDelUser(){
		userRepository.findByName("xw1");
		userRepository.deleteByName("xw1");
		//不使用 @CacheEvict  而且不做查询
//		assertEquals("xw1",userRepository.findByName("xw1").getName());
//		assertEquals("xw1",userRepository.findByName("xw1").getName());

		//使用 @CacheEvict  就会做一次查询
		assertNull(userRepository.findByName("xw1"));
		assertNull(userRepository.findByName("xw1"));
	}

	@After
	public void after(){
		System.out.println("=============deleteAll=============");
		userRepository.deleteAll();
	}

}
