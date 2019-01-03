package top.by.xiceos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import top.by.xiceos.dao.UserDao;
import top.by.xiceos.entity.User;
import top.by.xiceos.pattern.FanoutReceiver;
import top.by.xiceos.pattern.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private FanoutSender fanoutSender;

	@Autowired
	private FanoutReceiver fanoutReceiver;

	@Autowired
	private UserDao userDao;

	@Autowired
	private Environment env;

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testFanout() throws Exception {
		User user = userDao.findById(1L).get();
		fanoutSender.send(user);
	}

}

