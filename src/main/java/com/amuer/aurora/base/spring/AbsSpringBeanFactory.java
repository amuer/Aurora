package com.amuer.aurora.base.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangqiang on 2015/7/16.
 */
public abstract  class AbsSpringBeanFactory
{
    private static final Logger logger = LoggerFactory.getLogger(AbsSpringBeanFactory.class);

    protected Object loadSpringBean(String path)
    {
        try
        {
            Object context = new ClassPathXmlApplicationContext(path);
            logger.info("spring 加载文件:{}成功", path);
            return context;
        }
        catch (BeansException e)
        {
            logger.error("spring 加载文件:{}失败", path);
            logger.error(e.toString());
            return null;
        }
    }

    public abstract  int initBeanFactory(String path);

    public abstract  Object getBean(String key);

}
