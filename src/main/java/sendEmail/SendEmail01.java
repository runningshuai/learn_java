//package sendEmail;
//
//import javax.mail.Address;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//public class SendEmail01 {
//    public static void main(String[] args) {
//        String from="991957740@qq.com";
//        String to="banshuaiyin@xueqiu.com";
//
//        //获取系统属性
//        Properties properties = System.getProperties();
//
//        //设置邮件服务器
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.smtp.auth", "true");
//
//        //获取sesson对象
//        Session session = Session.getInstance(properties);
//
//        MimeMessage message = new MimeMessage(session);
//
//        try {
//            message.setFrom(new InternetAddress(from));
//
//            message.setText("java 测试发邮件功能！");
//            message.setSubject("测试邮件100");
//
//            Transport transport = session.getTransport();
//            transport.connect("smtp.qq.com",587, "991957740", "ecplntqhrkswbcbd");
//            transport.sendMessage(message,
//                    new Address[]{new InternetAddress(to)});
//            transport.close();
//            System.out.println("sent message successfully...");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(properties);
//    }
//}
