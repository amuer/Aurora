package com.amuer.aurora.base.spring;

import org.springframework.context.ApplicationContext;

/**
 * Created by wangqiang on 2015/7/16.
 */
public class BaseMessageHandlerBeanFactory extends AbsSpringBeanFactory
{
    private final static BaseMessageHandlerBeanFactory instance = new BaseMessageHandlerBeanFactory();
    private static ApplicationContext baseMessageHanderBeanContext = null;


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
        return baseMessageHanderBeanContext.getBean(key);
    }

    public static void main(String args[])
    {
        BaseMessageHandlerBeanFactory.getInstance().initBeanFactory("BaseMessageHandlerBean.xml");
        BaseMessageHandlerBeanFactory.getInstance().getBean("1");
    }
}
