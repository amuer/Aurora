package com.amuer.aurora.base.spring;

import com.amuer.aurora.base.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangqiang on 2015/7/16.
 */
public class SpringBeanFactory extends AbsSpringBeanFactory
{
    private static final Logger logger = LoggerFactory.getLogger(SpringBeanFactory.class);
    private static ApplicationContext applicationContext = null;
    private static final SpringBeanFactory instance = new SpringBeanFactory();

    private SpringBeanFactory()
    {
        logger.info("construct SpringBeanFactory");
    }

    public static SpringBeanFactory getInstance()
    {
        return instance;
    }

    public int initBeanFactory(String path)
    {
        applicationContext = (ApplicationContext) super.loadSpringBean(path);
        if (applicationContext != null)
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
            return applicationContext.getBean(key);
        }
        catch (Exception e)
        {
            logger.error("获取spring bean:{}失败 错误信息{}", key, e.toString());
            return null;
        }
    }

    public static void main(String arg[])
    {
        SpringBeanFactory.getInstance().initBeanFactory("SpringBean.xml");
        Message message = (Message) SpringBeanFactory.getInstance().getBean("1");
    }
}
