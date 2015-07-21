package com.amuer.aurora.base.msgFactory;

import com.amuer.aurora.base.protocol.protobuf.PbBaseMessage;
import com.amuer.aurora.base.spring.BaseMessageHandlerBeanFactory;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangqiang on 2015/7/21.
 */
public class ProtobufMsgFactory implements IMsgFactory
{
    public static final ProtobufMsgFactory instance = new ProtobufMsgFactory();
    private static final Logger logger = LoggerFactory.getLogger(ProtobufMsgFactory.class);

    private ProtobufMsgFactory(){}

    public static ProtobufMsgFactory getInstance()
    {
        return instance;
    }

    public Object createMessage(int id, byte msg[])
    {
        Message.Builder builder = (Message.Builder) BaseMessageHandlerBeanFactory.getInstance().getBean(String.valueOf(id));

        // 没找到ID对应的builder类
        if (builder == null)
        {
            logger.error("cann't find id:{} descriptor from BaseMessageHandlerBeanFactory", id);
            return null;
        }

        Message message;

        try
        {
            message = builder.mergeFrom(msg).build();
            return message;
        }
        catch (InvalidProtocolBufferException e)
        {
            e.printStackTrace();
            logger.error("cann't builder protobuf message, id:{}", id);
            return null;
        }

    }

    public Object createMessage(String id)
    {
        return null;
    }

    public static void main(String arg[]) throws InvalidProtocolBufferException
    {
        PbBaseMessage.BaseMessage.Builder builder = PbBaseMessage.BaseMessage.newBuilder();
        builder.setServerID(111);
        builder.setServerType(233);
        PbBaseMessage.BaseMessage baseMessage = builder.build();
        byte[] b = baseMessage.toByteArray();

//        Message message = builder.mergeFrom(b).build();
//
//        PbBaseMessage.BaseMessage baseMessage2 = (PbBaseMessage.BaseMessage) message;
//        System.out.println(baseMessage2.getServerID());
//        System.out.println(baseMessage2.getServerType());

        BaseMessageHandlerBeanFactory.getInstance().initBeanFactory("BaseMessageHandlerBean.xml");
        Message m = (Message) ProtobufMsgFactory.getInstance().createMessage(1, b);
        PbBaseMessage.BaseMessage baseMessage1 = (PbBaseMessage.BaseMessage) m;

        System.out.println(baseMessage1.getServerID());
        System.out.println(baseMessage1.getServerType());
    }
}
