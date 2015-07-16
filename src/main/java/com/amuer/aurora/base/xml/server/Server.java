//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2015.07.15 时间 04:53:32 PM CST 
//


package com.amuer.aurora.base.xml.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ZookeeperServer"/>
 *         &lt;element ref="{}RouterServer"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zookeeperServer",
    "routerServer"
})
@XmlRootElement(name = "Server")
public class Server {

    @XmlElement(name = "ZookeeperServer", required = true)
    protected ZookeeperServer zookeeperServer;
    @XmlElement(name = "RouterServer", required = true)
    protected RouterServer routerServer;
    @XmlAttribute(name = "version", required = true)
    protected byte version;

    /**
     * 获取zookeeperServer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ZookeeperServer }
     *     
     */
    public ZookeeperServer getZookeeperServer() {
        return zookeeperServer;
    }

    /**
     * 设置zookeeperServer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ZookeeperServer }
     *     
     */
    public void setZookeeperServer(ZookeeperServer value) {
        this.zookeeperServer = value;
    }

    /**
     * 获取routerServer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RouterServer }
     *     
     */
    public RouterServer getRouterServer() {
        return routerServer;
    }

    /**
     * 设置routerServer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RouterServer }
     *     
     */
    public void setRouterServer(RouterServer value) {
        this.routerServer = value;
    }

    /**
     * 获取version属性的值。
     * 
     */
    public byte getVersion() {
        return version;
    }

    /**
     * 设置version属性的值。
     * 
     */
    public void setVersion(byte value) {
        this.version = value;
    }

}
