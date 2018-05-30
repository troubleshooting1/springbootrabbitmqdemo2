package com.anji.springbootrabbitmq2;

import com.anji.springbootrabbitmq2.basic.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springbootrabbitmq2ApplicationTests {

	@Autowired
	private MessageSender sender;

	@Test
	public void send(){
		sender.send();
	}

	@Test
	public void sendAndReceive(){
		sender.sendAndReceive();
	}

	@Test
	public void contextLoads() {
	}

}
