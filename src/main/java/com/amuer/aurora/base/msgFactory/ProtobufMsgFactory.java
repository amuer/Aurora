package com.amuer.aurora.base.msgFactory;

import com.amuer.aurora.base.protocol.protobuf.PbBaseMessage;
import com.amuer.aurora.base.spring.BaseMessageHandlerBeanFactory;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangqiang on 2015/7/22.
 */
public class ProtobufMsgFactory extends  AbsProtobufMsgFactory
{
    private static final Logger logger = LoggerFactory.getLogger(ProtobufMsgFactory.class);
    private static final ProtobufMsgFactory instance = new ProtobufMsgFactory();

    public static ProtobufMsgFactory getInstance()
    {
        return instance;
    }

    public static void main(String args[]) throws InvalidProtocolBufferException
    {
        ProtobufMsgFactory.getInstance().setAbsSpringBeanFactory(BaseMessageHandlerBeanFactory.getInstance());

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
