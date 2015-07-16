package com.amuer.aurora.base.message;

/**
 * Created by mark on 2015/7/15.
 */

public  class Message
{
    private int msgLength;
    private short msgID;
    private short srcID;
    private short srcType;
    private short dstID;
    private short dstType;
    private Byte[] msgBody;

    public void setMsgLength(int msgLength)
    {
        this.msgLength = msgLength;
    }

    public void setMsgID(short msgID)
    {
        this.msgID = msgID;
    }

    public void setSrcID(short srcID)
    {
        this.srcID = srcID;
    }

    public void setSrcType(short srcType)
    {
        this.srcType = srcType;
    }

    public void setDstID(short dstID)
    {
        this.dstID = dstID;
    }

    public void setDstType(short dstType)
    {
        this.dstType = dstType;
    }

    public void setMsgBody(Byte[] msgBody)
    {
        this.msgBody = msgBody;
    }

    public int getMsgLength()
    {
        return msgLength;
    }

    public short getMsgID()
    {
        return msgID;
    }

    public short getSrcID()
    {
        return srcID;
    }

    public short getSrcType()
    {
        return srcType;
    }

    public short getDstID()
    {
        return dstID;
    }

    public short getDstType()
    {
        return dstType;
    }

    public Byte[] getMsgBody()
    {
        return msgBody;
    }
}

