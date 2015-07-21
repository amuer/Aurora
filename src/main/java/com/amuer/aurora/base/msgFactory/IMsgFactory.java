package com.amuer.aurora.base.msgFactory;

/**
 * Created by wangqiang on 2015/7/21.
 */
public interface IMsgFactory
{
    public Object createMessage(int id, byte[] msg);
    public Object createMessage(String  id);
}
