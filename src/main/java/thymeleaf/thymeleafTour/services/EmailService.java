package thymeleaf.thymeleafTour.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailContentBuilder emailContentBuilder;

    public void sendComplexEmail(String sendTo, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            String content = emailContentBuilder.build(message);
            messageHelper.setFrom("noreply@blahblah.com");
            messageHelper.setTo(sendTo);
            messageHelper.setSubject("Sample mail subject");
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            throw e;
        }
    }

    
}