package com.amuer.aurora.base.db.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by wangqiang on 2015/7/27.
 */
public class Redis
{
    private static final Logger logger = LoggerFactory.getLogger(Redis.class);

    public static String getKey(String key)
    {
        if (key.isEmpty())
        {
            logger.error("key is empty");
            return null;
        }

        Jedis jedis = RedisPool.getInstance().getJedisFromPool();
        if (jedis == null)
        {
            return null;
        }

        String value = null;
        try
        {
            value = jedis.get(key);
        }
        catch (Exception e)
        {
            logger.error("cann't get key{}, exception:{}",key, e.toString());
            e.printStackTrace();
        }
        finally
        {
            RedisPool.getInstance().returnResource(jedis);
            return value;
        }

    }

    public static String setvalue(String key, String value)
    {
        if (key.isEmpty())
        {
            logger.error("key is empty");
        }

        if (value.isEmpty())
        {
            logger.error("value is empty");
        }

        Jedis jedis = RedisPool.getInstance().getJedisFromPool();
        if (jedis == null)
        {
            return null;
        }

        String result = null;
        try
        {
            result = jedis.set(key, value);
        }
        catch (Exception e)
        {
            logger.error("set value error, key:{}, value:{}, exception:{}", key, value, e.toString());
            e.printStackTrace();
        }
        finally
        {
            RedisPool.getInstance().returnResource(jedis);
            return result;
        }
    }

    public static String setvalue(String key, String value, int timeout)
    {
        if (key.isEmpty())
        {
            logger.error("key is empty");
        }

        if (value.isEmpty())
        {
            logger.error("value is empty");
        }

        Jedis jedis = RedisPool.getInstance().getJedisFromPool();
        if (jedis == null)
        {
            return null;
        }

        String result = null;
        try
        {
            result = jedis.set(key, value);
            jedis.expire(key, timeout);
        }
        catch (Exception e)
        {
            logger.error("set value error, key:{}, value:{}, exception:{}", key, value, e.toString());
        }
        finally
        {
            RedisPool.getInstance().returnResource(jedis);
            return result;
        }
    }

    public static void main(String arg[])
    {
//        Jedis j = new Jedis("10.1.9.55");
//        j.set("testa", "helloworld");
//        String s = j.get("testa");
//        System.out.println(s);
        Redis redis = new Redis();
        String  result = redis.getKey("testa");
        System.out.println(result);

        result = redis.setvalue("wq", "wqwqwq");
        System.out.println(result);
    }
}
