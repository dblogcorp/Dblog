package io.dblog.sso.constant;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Pelin on 17/8/3.
 */
public class AccountConstant {

    public static final short STATUS_INACTIVED = 1; // inactive account
    public static final short STATUS_ACTIVED = 2; // active account
    public static final short STATUS_BLOCKED = 3; // blocked account

    public enum AccountStatus {
        INACTIVED(STATUS_INACTIVED, "INACTIVED"),
        ACTIVED(STATUS_ACTIVED, "ACTIVED"),
        BLOCKED(STATUS_BLOCKED, "BLOCKED");

        @Getter
        private short code;
        @Getter
        private String msg;

        AccountStatus(short code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static String getMsg(short code) {
            for (AccountStatus status : AccountStatus.values()) {
                if (code == status.code) {
                    return status.msg;
                }
            }
            return StringUtils.EMPTY;
        }
    }

}
