package com.amuer.aurora.base.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by wangqiang on 2015/7/27.
 */
public class DBConfigBeanFactory extends AbsSpringBeanFactory
{
    private static final Logger logger = LoggerFactory.getLogger(DBConfigBeanFactory.class);
    private static final DBConfigBeanFactory instance = new DBConfigBeanFactory();
    private static ApplicationContext dBConfigBeanContext = null;

    public static DBConfigBeanFactory getInstance()
    {
        return instance;
    }

    public int initBeanFactory(String path)
    {
        dBConfigBeanContext = (ApplicationContext) super.loadSpringBean(path);
        if (dBConfigBeanContext != null)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

    public Object getBean(String key)
    {
        try
        {
            return dBConfigBeanContext.getBean(key);
        }
        catch (Exception e)
        {
            logger.error("获取spring bean:{}失败 错误信息{}", key, e.toString());
            return null;
        }
    }
}
