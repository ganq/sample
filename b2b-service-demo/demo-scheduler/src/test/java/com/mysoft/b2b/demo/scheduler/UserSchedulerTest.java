package com.mysoft.b2b.demo.scheduler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.demo.test.BaseTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserSchedulerTest extends BaseTestCase {
	@Autowired
	private UserScheduler userScheduler;

	@Test
	public void testSaveUserScheduler() {
		userScheduler.saveUserScheduler();
		Assert.assertTrue(true);
	}

}