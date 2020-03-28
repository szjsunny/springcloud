package cn.itcast.stream;

import cn.itcast.stream.producer.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProducerTest {
    @Autowired
    private MessageSender messageSender;
    @Test
    public void send() {
        //messageSender.send("我看看我这个消息是不是被两个消费者都消费了");
        for (int i = 0; i < 5; i++) {
            messageSender.send(i + "");
        }
    }

}
