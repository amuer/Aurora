package com.amuer.aurora.base.msghandler;

import com.amuer.aurora.base.users.IUser;

/**
 * Created by wangqiang on 2015/7/23.
 */
public interface IMsgHandlerFactory
{
    public Object getHandler(int id);
    public int doHandler(int id, Object msg);
    public int doHandler(IUser user, int id, Object msg);
}
