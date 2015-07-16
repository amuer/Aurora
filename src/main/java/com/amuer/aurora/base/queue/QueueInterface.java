package com.amuer.aurora.base.queue;

import com.amuer.aurora.base.message.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by mark on 2015/7/15.
 */
public interface QueueInterface
{

    public int initQueue();
    public int push(Message message);
    public int push(Message message, int timeout, TimeUnit timeUnit) throws InterruptedException;

    public int pop(Message message);
    public int pop(BlockingQueue<Message> collection, int num);
    public int popAll(BlockingQueue<Message> collection);
}

