package com.amuer.aurora.base.db.redis;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wangqiang on 2015/7/27.
 */
public class RedisPoolConfig extends JedisPoolConfig
{
    private String host;
    private int port;

    public void setHost(String host)
    {
        this.host = host;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }
}
