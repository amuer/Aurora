package com.amuer.aurora.base.queue;

import com.amuer.aurora.base.config.ConfigManager;
import com.amuer.aurora.base.message.Message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by mark on 2015/7/15.
 */
public class MessageQueue implements QueueInterface
{

    private BlockingQueue<Message> blockingQueue = null;

    public int initQueue()
    {
        int capacity = Integer.parseInt(ConfigManager.getInstance().getConfig("MessageConfig").getValue("MessageQueueCapacity"));
        blockingQueue = new ArrayBlockingQueue<Message>(capacity);
        return 0;
    }

    public int push(Message message)
    {
        blockingQueue.offer(message);
        return 1;
    }

    public int push(Message message, int timeout, TimeUnit timeUnit)
    {
        try
        {
            blockingQueue.offer(message, timeout, timeUnit);
            return 1;
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public int pop(Message message)
    {
        message = blockingQueue.poll();
        if (message != null)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public int pop(BlockingQueue<Message> collection, int num)
    {
        return blockingQueue.drainTo(collection, num);
    }

    public int popAll(BlockingQueue<Message> collection)
    {
        return blockingQueue.drainTo(collection);
    }
}

