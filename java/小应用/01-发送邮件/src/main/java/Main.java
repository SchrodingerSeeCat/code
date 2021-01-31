/*
*   使用QQ邮箱发送邮件
* */


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main{
    public static void main(String[] args) {
        // 1. 设置一些参数
        Properties properties = new Properties();

//        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.debug", "true");
        // 设置qq的邮件服务器
        properties.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件，采用的协议是什么
        properties.setProperty("mail.transport.protocol", "smtp");

        // 2. 创建会话
        Session session = Session.getDefaultInstance(properties);

        // 3. 获取传输对象, 发送邮件
        Transport ts = null;
        try {
            ts = session.getTransport();

            // 发送邮件之前，校验账号和授权码
            ts.connect("471068961@qq.com", "oresztpbmzoscbca");

            // 4. 构建一封邮件
            MimeMessage message = new MimeMessage(session);
            // 发件人
            message.setFrom(new InternetAddress("471068961@qq.com"));
            // 收件人
            // Message.RecipientType.TO 收件人
            // Message.RecipientType.CC 抄送
            // Message.RecipientType.BCC 暗送
            // 把邮件发送给XXX用户
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("248543351@qq.com"));
            // 主题
            message.setSubject("测试发送邮件");
            // 正文
            message.setContent("测试发邮件的正文", "text/html;charset=utf-8");
            // 保存邮件
            message.saveChanges();

            // 5. 发送邮件
            ts.sendMessage(message, message.getAllRecipients());

        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            // 关闭邮件发送对象
            if(ts != null) {
                try {
                    ts.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}