package pl.portalpracowniczy.app.webapp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String to, String title, String contens){
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("kuuba8@o2.pl");
            helper.setFrom("kuuba8@o2.pl");
            helper.setSubject(title);
            helper.setText(contens, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
    }
