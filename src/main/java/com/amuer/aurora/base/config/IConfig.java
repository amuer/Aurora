package com.amuer.aurora.base.config;


/**
 * Created by wangqiang on 2015/7/15.
 */
public interface IConfig
{
    /**
     *  获取配置中的对应value值
     * @param key
     * @return json或者xml格式的字符串，失败返回null
     */
    public String getValue(String key);

    /**
     *
     * @param key
     * @return object对象 返回POJO对象，失败返回null
     */
    public Object getObject(String key);

    /**
     *  取配置中的POJO实例
     * @return
     */
    public Object getConfigEntity();

    /**
     * 读配置
     * @param path 配置文件的绝对路径
     * @param bean
     * @return 成功返回0 失败返回错误码
     */
    public int loadConfigFile(String path, String bean);

    /**
     * 重新读取配置，主要用于热更新一些配置
     * @param path
     * @return 成功返回0 失败返回错误码
     */
    public int reloadConfigFile(String path);

}
