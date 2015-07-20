package com.amuer.aurora.base.net.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangqiang on 2015/7/16.
 */
public class NettyServer
{

    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void run() throws Exception
    {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup();

        try
        {
            ServerBootstrap b = new ServerBootstrap();
            b.group(eventLoopGroup, workLoopGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {
                @Override
                protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel) throws Exception
                {
                    socketChannel.pipeline().addLast(new DiscardServerHandler());
                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(12222).sync();
            logger.info("listening:::");
            System.out.println("---------------------------------------");
            f.channel().closeFuture().sync();
            System.out.println("1111---------------------------------------");
            logger.info("close sync");
        }
        catch (Exception e)
        {

        }
        finally
        {
            eventLoopGroup.shutdownGracefully();
            workLoopGroup.shutdownGracefully();
        }
    }

    public  static void main(String args[])
    {
        try
        {
            System.out.println("111111111111111111111111111111111111111111");
            new NettyServer().run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
