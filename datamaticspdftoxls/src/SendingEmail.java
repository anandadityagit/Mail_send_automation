import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class SendingEmail {

    public static void main(String[] args) {

        final String username = "postmaster@sandbox463369fb9d0a4440bc7349f09388e914.mailgun.org";
        final String password = "Test@321@Test";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.mailgun.org");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sharanyug@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("sharanyug@gmail.com"));
            message.setSubject("Please find attached the PDF to XLS converted file");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            String file = "/Users/adityaanand/IdeaProjects/datamaticspdftoxls/AdityaPDFtoXLS.xls";
            String fileName = "AdityaPDFtoXLS.xls";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            //message.setContent(messageBody,"text/html; charset=utf-8");
            message.setContent(multipart);


            System.out.println("Sending Email with an attachment");

            Transport.send(message);

            System.out.println("Mail has been sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}