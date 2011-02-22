package com.seanxiaoxiao.jmssample;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {
    public static void main(String[] args) {

        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            //test-queue跟sender的保持一致，一个创建一个来接收
            destination = session.createQueue("test-queue");
            consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message arg0) {
                    System.out.println("==================");
                    try {
                        System.out.println("RECEIVE1第一个获得者:"
                                + ((TextMessage) arg0).getText());
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });

            MessageConsumer consumer1 = session.createConsumer(destination);
            consumer1.setMessageListener(new MessageListener() {
                public void onMessage(Message arg0) {
                    System.out.println("+++++++++++++++++++");
                    try {
                        System.out.println("RECEIVE1第二个获得者:"
                                + ((TextMessage) arg0).getText());
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        //在eclipse里运行的时候，这里不要关闭，这样就可以一直等待服务器发送了，不然就直接结束了。
        // } finally {
        // try {
        // if (null != connection)
        // connection.close();
        // } catch (Throwable ignore) {
        // }
        // }

    }
}