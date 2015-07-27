package com.amuer.aurora.base.db.redis;


import com.amuer.aurora.base.spring.DBConfigBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wangqiang on 2015/7/27.
 */
public class RedisPool
{
    private static final Logger logger = LoggerFactory.getLogger(RedisPool.class);
    private static final RedisPool instance = new RedisPool();
    private JedisPool jedisPool;
    private boolean isLoadRedisConfigAndInitPool = false;

    private RedisPool()
    {
    }

    public static RedisPool getInstance()
    {
        return instance;
    }

    public int loadRedisConfig()
    {
        if (isLoadRedisConfigAndInitPool)
        {
            return -1;
        }

        DBConfigBeanFactory.getInstance().initBeanFactory("DBConfigBean.xml");

        RedisPoolConfig redisPoolConfig = (RedisPoolConfig) DBConfigBeanFactory.getInstance().getBean("redisPoolConfig");
        jedisPool = new JedisPool(redisPoolConfig, redisPoolConfig.getHost(), redisPoolConfig.getPort());
        isLoadRedisConfigAndInitPool = true;
        return 0;
    }

    public Jedis getJedisFromPool()
    {
        try
        {
            return jedisPool.getResource();
        }
        catch (Exception e)
        {
            logger.error("getJedisFromPool exception");
            logger.error(e.toString());
            return null;
        }
    }

    public void returnResource(Jedis jedis)
    {
        if (jedis != null)
        {
            try
            {
                jedisPool.returnResourceObject(jedis);
            }
            catch (Exception e)
            {
                logger.error("returnResource exception");
                logger.error(e.toString());
            }
        }
    }

    public static void main(String args[])
    {
        RedisPool.getInstance().loadRedisConfig();
        Jedis j = RedisPool.getInstance().getJedisFromPool();
        j.set("wq", "zy");
        while (true)
        {
            j.get("wq");
            if (false)
            {
                break;
            }
        }
        System.out.println(j.get("wq"));
    }
}
