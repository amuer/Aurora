package com.amuer.aurora.base.msghandler;

import com.amuer.aurora.base.users.IUser;

/**
 * Created by wangqiang on 2015/7/16.
 */
public interface IMsgHandler
{
    public int handle(Object msg);
    public int handle(IUser user, Object msg);
}
