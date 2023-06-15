package DigDesSchool.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class Sender {
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine engine;
    private String address;

    public Sender(JavaMailSender mailSender, SpringTemplateEngine engine, @Value("${spring.mail.username}") String address) {
        this.address = address;
        this.javaMailSender = mailSender;
        this.engine = engine;
    }

    public void send(String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Map<String, Object> map =new HashMap<>();
        map.put("message", message);
        Context context = new Context();
        context.setVariables(map);
        String text = engine.process("index", context);
        messageHelper.setTo(address);
        messageHelper.setFrom(address);
        messageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }
}
