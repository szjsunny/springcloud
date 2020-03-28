package cn.itcast.stream.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class MessageListener {

    @StreamListener(Sink.INPUT)
    public void input(String message) {
        System.out.println("接收到得消息是==>" + message);
    }

}
