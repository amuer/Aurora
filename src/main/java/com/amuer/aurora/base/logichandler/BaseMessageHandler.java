package com.amuer.aurora.base.logichandler;

import com.amuer.aurora.base.msghandler.IMsgHandler;
import com.amuer.aurora.base.users.IUser;

/**
 * Created by wangqiang on 2015/7/23.
 */
public class BaseMessageHandler implements IMsgHandler
{
    public int handle(Object msg)
    {
        return 0;
    }

    public int handle(IUser user, Object msg)
    {
        return 0;
    }
}
