package com.ldd;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @Author ldd
 * @Date 2023/12/5
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmailController {

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail(@RequestParam("email") String email,
                             @RequestParam("text") String text){

        try {
            MimeMessage msg = createMimeMsg(email, text, "author.gif");
            javaMailSender.send(msg);
        } catch (MessagingException | UnsupportedEncodingException e) {
            log.error("邮件发送失败:",e);
            return false;
        }

        return true;

    }


    /**
     * 创建复杂邮件
     * @param email 收件人邮箱
     * @param text  发件内容
     * @param attachmentClasspath 附件地址
     * @return 返回这个组装好的信件
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */

    private MimeMessage createMimeMsg(String email,String text,String attachmentClasspath) throws MessagingException, UnsupportedEncodingException {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true);
        mimeMessageHelper.setFrom(mailProperties.getFrom(),mailProperties.getPersonal());
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setBcc(mailProperties.getBcc());
        mimeMessageHelper.setSubject(mailProperties.getSubject());
        mimeMessageHelper.setText(text);
        mimeMessageHelper.addAttachment("附件",new ClassPathResource(attachmentClasspath));

        return msg;
    }

    /**
     * 一个简单的信件
     * @param email 收件人邮箱
     * @param text 内容
     * @return
     */
    private SimpleMailMessage createSimpleMsg(String email,String text){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getFrom());
        msg.setTo(email);
        msg.setBcc(mailProperties.getBcc());
        msg.setSubject(mailProperties.getSubject());
        msg.setText(text);

        return msg;
    }
}
