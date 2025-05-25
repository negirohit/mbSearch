package utils;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

import mbsearch.base.TestBase;

import java.io.File;

public class EmailSend extends TestBase{

    public static void sendEmailWithReport(String toEmail) {
    	
    	
        final String fromEmail = "rohit.negi@magicbricks.com"; // Change to your Gmail
        final String password = "stsr ynyw wgdm idph";    // Use App Password if 2FA is on

        String subject = "Automation Test Report";
        String bodyText = "Hi,\n\nLatest Search test report.\n\nThanks.";

        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, "Test Automation"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            // Email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(bodyText);

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "C:\\Users\\Rohit.Negi\\new\\eclipse-workspace\\mbsearch\\test-output\\ExtentReport.html"; // Update path
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            DataSource source = new FileDataSource(file);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("ExtentReport.html");

            // Combine parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // Send mail
            Transport.send(message);
            System.out.println("✅ Email sent successfully to " + toEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
