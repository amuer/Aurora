package com.amuer.aurora.base.net.parser;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by wangqiang on 2015/7/16.
 */
public class BaseEncoder extends MessageToByteEncoder
{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception
    {

    }
}
