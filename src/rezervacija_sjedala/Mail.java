package rezervacija_sjedala;
import java.util.*;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail {

	// Ako �aljete s va�eg gmail ra�na, ovo je SMTP server ina�e promijeniti
	private static final String SMTP_SERVER = "smtp.gmail.com";
	// Postavite va� ra�un i lozinku s kojeg �aljete
	// NEMOJTE u projektu staviti va� "pravi" ra�un/lozinku
	// ILI predajete projekt s napomenom da korisnik treba unijeti svoje Gmail podatke
	// ILI za potrebe projekta napravite neki Gmail ra�un pa ovdje upi�ite njegove podatke
	// Preporu�ujem PRVI pristup!
    private static String USERNAME = "unesite email adresu";
    private static String PASSWORD = "unesite lozinku";

	// Adresa primatelja, po�iljatelja, CC,...
    private static String EMAIL_FROM = "unesite email adresu";
    private  String EMAIL_TO ;
    private static String EMAIL_TO_CC = "";

    // Predmet poruke i tekst poruke spremate u ove dvije varoijable
    private static final String EMAIL_SUBJECT = "Rezervacija sjedala";
    private static  String EMAIL_TEXT = " ";
    

    public Mail(String eMAIL_TO, String eMAIL_TEXT) {
		
		EMAIL_TO = eMAIL_TO;
		EMAIL_TEXT= eMAIL_TEXT;
	}


	public  void sendEmail() {
        Properties prop = System.getProperties();
        // Gotovo svi dana�nji smtp serveri su "za�ti�eni" pa ih treba
        //  podesiti (slanje n aispravan port i uz autentifikaciju)
        // Ovo je pode�eno za slanje s Gmail ra�una
        prop.setProperty("mail.transport.protocol", "smtp");     
        prop.setProperty("mail.host", SMTP_SERVER);  
        prop.put("mail.smtp.auth", "true");  
        prop.put("mail.smtp.port", "465");  
        prop.put("mail.debug", "true");  
        prop.put("mail.smtp.socketFactory.port", "465");  
        prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
        prop.put("mail.smtp.socketFactory.fallback", "false");  
        Session session = Session.getDefaultInstance(prop,  
        new javax.mail.Authenticator() {
        		protected PasswordAuthentication getPasswordAuthentication() {  
        		return new PasswordAuthentication(USERNAME,PASSWORD);  
           }  
       });  
 
        Message msg = new MimeMessage(session);
        try {
        
            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to 
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO, false));

            // cc
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(EMAIL_TO_CC, false));

            // subject
            msg.setSubject(EMAIL_SUBJECT);
            
            // content 
            msg.setText(EMAIL_TEXT);
            
            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            
            // connect to server
            t.connect();
            
            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            // close connection
            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

   