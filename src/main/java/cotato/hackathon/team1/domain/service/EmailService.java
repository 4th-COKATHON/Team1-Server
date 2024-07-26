package cotato.hackathon.team1.domain.service;

import static cotato.hackathon.team1.domain.constant.EmailConstants.MESSAGE_PREFIX;
import static cotato.hackathon.team1.domain.constant.EmailConstants.MESSAGE_SUFFIX;
import static cotato.hackathon.team1.domain.constant.EmailConstants.SENDER_EMAIL;
import static cotato.hackathon.team1.domain.constant.EmailConstants.SENDER_PERSONAL;
import static cotato.hackathon.team1.domain.constant.EmailConstants.CODE_SUBJECT;

import jakarta.mail.Message.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmail(String email, UUID key) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.addRecipients(RecipientType.TO, email);
        mimeMessage.setText(getVerificationText(String.valueOf(key)), "utf-8", "html");
        mimeMessage.setSubject(CODE_SUBJECT);
        mimeMessage.setFrom(getInternetAddress());
        javaMailSender.send(mimeMessage);

        log.info("이메일 전송 완료");
    }

    private String getVerificationText(String key) {
        StringBuilder sb = new StringBuilder();
        return String.valueOf(sb.append(MESSAGE_PREFIX)
                .append(key)
                .append(MESSAGE_SUFFIX));
    }

    private InternetAddress getInternetAddress() {
        try {
            return new InternetAddress(SENDER_EMAIL, SENDER_PERSONAL);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
