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

        RedisPoolConfig redisPoolConfig = (RedisPoolConfig) DBConfigBeanFactory.getInstance().getBean("redisPoolConfig");
        jedisPool = new JedisPool((JedisPoolConfig)redisPoolConfig, redisPoolConfig.getHost(), redisPoolConfig.getPort());
        isLoadRedisConfigAndInitPool = true;
        logger.info("redis pool loadRedisConfig success!");
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
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        DBConfigBeanFactory.getInstance().initBeanFactory("DBConfigBean.xml");
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
