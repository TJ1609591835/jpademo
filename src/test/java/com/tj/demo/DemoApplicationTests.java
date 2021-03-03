package com.tj.demo;

import com.tj.demo.dao.UserRepository;
import com.tj.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.runner.RunWith;

import java.util.Optional;

//@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

//	@Test
	public void test() {
		Optional<User> user = userRepository.findById(1);
		System.out.println(user.get().getId());
	}

}
