package io.lcalmsky.app.modules.account.infra.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@Profile("local") // (1)
@Component // (2)
@Slf4j // (3)
public class ConsoleMailSender implements JavaMailSender { // (4)
    
	@Override public MimeMessage createMimeMessage() {
        return null;
    }

    @Override public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
        return null;
    }

    @Override public void send(MimeMessage mimeMessage) throws MailException {

    }

    @Override public void send(MimeMessage... mimeMessages) throws MailException {

    }

    @Override public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

    }

    @Override public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

    }

    @Override public void send(SimpleMailMessage simpleMessage) throws MailException { // (5)
        log.info("{}", simpleMessage);
    }

    @Override public void send(SimpleMailMessage... simpleMessages) throws MailException {

    }
}