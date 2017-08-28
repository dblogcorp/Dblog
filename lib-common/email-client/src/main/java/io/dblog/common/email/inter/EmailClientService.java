package io.dblog.common.email.inter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * {@code EmailClientService}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Service
public class EmailClientService {

    private static final Logger logger = LoggerFactory.getLogger(EmailClientService.class);

    public boolean sendEmail(Short topic, Short type, String... to) {
        return true;
    }
}
