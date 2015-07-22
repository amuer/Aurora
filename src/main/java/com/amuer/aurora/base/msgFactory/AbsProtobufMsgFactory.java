package com.amuer.aurora.base.msgFactory;

import com.amuer.aurora.base.protocol.protobuf.PbBaseMessage;
import com.amuer.aurora.base.spring.AbsSpringBeanFactory;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangqiang on 2015/7/21.
 */
public abstract class AbsProtobufMsgFactory implements IMsgFactory
{
    private static final Logger logger = LoggerFactory.getLogger(AbsProtobufMsgFactory.class);
    private AbsSpringBeanFactory absSpringBeanFactory;

    public void setAbsSpringBeanFactory(AbsSpringBeanFactory absSpringBeanFactory)
    {
        this.absSpringBeanFactory = absSpringBeanFactory;
    }

    public AbsSpringBeanFactory getAbsSpringBeanFactory()
    {
        return absSpringBeanFactory;
    }

    public Object createMessage(int id, byte msg[])
    {
        Message.Builder builder = (Message.Builder) absSpringBeanFactory.getBean(String.valueOf(id));

        // 没找到ID对应的builder类
        if (builder == null)
        {
            logger.error("cann't find id:{} builder from BaseMessageHandlerBeanFactory", id);
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

}
