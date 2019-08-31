package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private FooDao fooDao;

	@Test(expected = Exception.class)
	public void getFoosUsingExpression() {
		final List<Foo> foos = fooDao.getFoosUsingExpression();
	}

	@Test
	public void getFoosUsingConstructorExpression() {
		final List<Foo> foos = fooDao.getFoosUsingConstructorExpression();

		assertThat(foos).hasSize(2);
		assertThat(foos.get(0).getBars()).hasSize(1);
		assertThat(foos.get(1).getBars()).hasSize(2);
	}

}
