package cn.itcast.stream.producer;

import cn.itcast.stream.channel.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 负责向中间件发送消息
 */
@Component
@EnableBinding(MyProcessor.class)
public class MessageSender {

    @Autowired
    @Qualifier("myOutput")
    private MessageChannel myOutput;

    //发送消息
    public void send(Object obj) {
        myOutput.send(MessageBuilder.withPayload(obj).build());
    }
}
