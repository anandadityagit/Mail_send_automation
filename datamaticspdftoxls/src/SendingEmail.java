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

        final String username = "Provide your SMTP server  username";
        final String password = "SMTP passwordt";

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
            message.setFrom(new InternetAddress("Give the mail id u wish to receive mail on"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("Give the mail id u wish to receive mail on"));
            message.setSubject("Please find attached the PDF to XLS converted file");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            String file = "/Users/adityaanand/IdeaProjects/datamaticspdftoxls/AdityaPDFtoXLS.xls"; //Path for ur xls file
            String fileName = "AdityaPDFtoXLS.xls"; //Name of ur xls file
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
