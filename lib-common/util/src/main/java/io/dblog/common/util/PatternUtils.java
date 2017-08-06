package io.dblog.common.util;

import java.util.regex.Pattern;

/**
 * Created by Pelin on 17/8/6.
 */
public class PatternUtils {

    private static final String USER_NAME_CHECK_REGEX = "^[a-zA-Z][a-zA-Z0-9]+_?[a-zA-Z0-9]+";

    private static final String EMAIL_CHECK_REGEX = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

    /**
     * 只允许包含字符和数字以及下滑杠, 不允许以连字号开头或结尾, 最多 20 个字符. 区分大小写
     */
    public static Boolean checkUserName(String userName) {
        if (null == userName || userName.length() > 20) {
            return false;
        }

        return Pattern.matches(USER_NAME_CHECK_REGEX, userName);
    }

    /**
     * Email format check
     */
    public static Boolean checkEmail(String email) {
        if (null == email) {
            return false;
        }

        return Pattern.matches(EMAIL_CHECK_REGEX, email);
    }
}
