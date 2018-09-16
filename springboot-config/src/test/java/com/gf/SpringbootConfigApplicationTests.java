package com.gf;

import com.gf.entity.Cat;
import com.gf.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	Cat cat;

	@Test
	public void contextLoads() {
		System.out.println(person);
		System.out.println(cat);
	}

}
