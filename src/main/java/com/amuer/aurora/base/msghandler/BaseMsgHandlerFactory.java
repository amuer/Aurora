package com.amuer.aurora.base.msghandler;

import com.amuer.aurora.base.users.IUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangqiang on 2015/7/23.
 */
public class BaseMsgHandlerFactory extends AbsMsgHanlderFactory
{
    private static final Logger logger = LoggerFactory.getLogger(BaseMsgHandlerFactory.class);

    public int doHandler(int id, Object msg)
    {
        IMsgHandler handler = (IMsgHandler) getHandler(id);
        if (handler == null)
        {
            logger.error("handle == null");
            return -1;
        }
        return handler.handle(msg);
    }

    public int doHandler(IUser user, int id, Object msg)
    {
        IMsgHandler handler = (IMsgHandler) getHandler(id);
        if (handler == null)
        {
            logger.error("handle == null");
            return -1;
        }
        return handler.handle(user, msg);
    }
}
