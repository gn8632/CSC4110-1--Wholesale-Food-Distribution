package sample;
//Giorgi Nozadze
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMailClass extends sample.CreateOrder {

    public static void SendEmail(String customer) throws Exception {

        String myEmail = "wsuprojteam1@gmail.com";
        String myEmPass = "projectOne1";
        Properties prt = new Properties();
        prt.put("mail.smtp.auth", "true");
        prt.put("mail.smtp.starttls.enable", "true");
        prt.put("mail.smtp.host", "smtp.gmail.com");
        prt.put("mail.smtp.port", "587");


        Session emailSession = Session.getInstance(prt, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail,myEmPass);
            }});

        Message email = mailFeature(emailSession, myEmail, customer);
        Multipart emailStuff = new MimeMultipart();
        MimeBodyPart attachedFile = new MimeBodyPart();

        // ----
        FileReader fileC = new FileReader("counterAlt.txt");
        BufferedReader cr = new BufferedReader(fileC);
        String theline;
        theline = cr.readLine();
        int counter = Integer.parseInt(theline);

        // ----

        sample.CreateOrder fileName = new sample.CreateOrder();
        attachedFile.attachFile("PurchaseOrder" + counter + ".txt");
        emailStuff.addBodyPart(attachedFile);
        email.setContent(emailStuff);
        Transport.send(email);
        System.out.println("Email Sent");
    }

    public static Message mailFeature(Session emailProcess, String myAccountEmail, String customer) {
        try {
            Message email = new MimeMessage(emailProcess);
            email.setFrom(new InternetAddress(myAccountEmail));
            email.setRecipient(Message.RecipientType.TO, new InternetAddress(customer));
            email.setSubject("WSU Inc - Purchase Order");
            email.setText("Please review the purchase order, sign it and send it back");
            return email;
        } catch (Exception exception) {
            Logger.getLogger(JavaMailClass.class.getName()).log(Level.CONFIG, null, exception);
        }
        return null;
    }
}
