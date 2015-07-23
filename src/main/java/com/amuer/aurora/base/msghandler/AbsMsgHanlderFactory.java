package com.amuer.aurora.base.msghandler;

import com.amuer.aurora.base.spring.AbsSpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangqiang on 2015/7/23.
 */
public abstract class AbsMsgHanlderFactory implements IMsgHandlerFactory
{
    private static final Logger logger = LoggerFactory.getLogger(AbsMsgHanlderFactory.class);
    private AbsSpringBeanFactory absSpringBeanFactory;

    public void setAbsSpringBeanFactory(AbsSpringBeanFactory absSpringBeanFactory)
    {
        this.absSpringBeanFactory = absSpringBeanFactory;
    }

    public Object getHandler(int id)
    {
        IMsgHandler handler = (IMsgHandler) absSpringBeanFactory.getBean(String.valueOf(id));
        if (handler == null)
        {
            logger.error("cann't find handle:{}", id);
            return null;
        }

        return handler;
    }

}
