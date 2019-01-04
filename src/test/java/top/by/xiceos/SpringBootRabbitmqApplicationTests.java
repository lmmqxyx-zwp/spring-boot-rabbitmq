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
import top.by.xiceos.pattern.*;

import java.util.List;

/**
 * <p>Title: SpringBootRabbitmqApplicationTests</p>
 * <p>Description:
 * 此类实现的测试有：
 * 		1、dao的测试
 * 		2、消息发送的测试
 * 			fanout：广播/订阅
 * 			dircet：精确匹配
 * 			topic：模糊匹配
 * 				*：匹配单个单词、例如：1.333.*.44 <= 1.333.454.44
 * 				#：匹配所有、例如：1.# <= 1.44.55
 * </p>
 *
 * @author zwp
 * @date 2019/1/4 11:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Autowired
	private FanoutSender fanoutSender;

	@Autowired
	private FanoutReceiver fanoutReceiver;

	@Autowired
	private DirectSender directSender;

	@Autowired
	private DirectReceiver directReceiver;

	@Autowired
	private TopicSender topicSender;

	@Autowired
	private TopicReceiver topicReceiver;

	@Autowired
	private UserDao userDao;

	@Autowired
	private Environment env;

	/* 可以获取spring容器中所有注入的bean */
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testFanout() throws Exception {
		User user = userDao.findById(1L).get();
		fanoutSender.send(user);
	}

	@Test
	public void testDirect() throws Exception {
		List<User> list = userDao.findAll();
		directSender.send(list);
	}

	@Test
	public void testTopic() throws Exception {
		User user =  userDao.findById(1L).get();
		topicSender.send(user);
	}

}

