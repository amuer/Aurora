package com.amuer.aurora.base.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by wangqiang on 2015/7/16.
 */
public class BaseMessageHandlerBeanFactory extends AbsSpringBeanFactory
{
    private final static BaseMessageHandlerBeanFactory instance = new BaseMessageHandlerBeanFactory();
    private static ApplicationContext baseMessageHanderBeanContext = null;
    private static final Logger logger = LoggerFactory.getLogger(BaseMessageHandlerBeanFactory.class);

    public static BaseMessageHandlerBeanFactory getInstance()
    {
        return instance;
    }

    public int initBeanFactory(String path)
    {
        baseMessageHanderBeanContext = (ApplicationContext) super.loadSpringBean(path);
        if (baseMessageHanderBeanContext != null)
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
            return baseMessageHanderBeanContext.getBean(key);
        }
        catch (Exception e)
        {
            logger.error("获取spring bean:{}失败 错误信息{}", key, e.toString());
            return null;
        }
    }

    public static void main(String args[])
    {
        BaseMessageHandlerBeanFactory.getInstance().initBeanFactory("BaseMessageHandlerFactoryBean.xml");
        BaseMessageHandlerBeanFactory.getInstance().getBean("1");
        System.out.println(BaseMessageHandlerBeanFactory.getInstance().getBean("1").getClass());
    }
}
