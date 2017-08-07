package io.dblog.common.email.inter;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * {@code EmailClientEnum} email enum
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class EmailClientEnum {

    public static final Short TYPE_SYNC = 1; // sync email
    public static final Short TYPE_ASYNC = 2; // async email

    public static final Short TOPIC_REGISTER = 1; // register email

    public enum EmailTopic {
        SYNC(TOPIC_REGISTER, "注册邮件");

        @Getter
        private short code;
        @Getter
        private String topic;

        EmailTopic(short code, String topic) {
            this.code = code;
            this.topic = topic;
        }

        public static String getTopic(short code) {
            for (EmailTopic topic : EmailTopic.values()) {
                if (code == topic.code) {
                    return topic.getTopic();
                }
            }

            return StringUtils.EMPTY;
        }
    }
}
