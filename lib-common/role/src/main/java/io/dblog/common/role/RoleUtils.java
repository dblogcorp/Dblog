package io.dblog.common.role;

/**
 * {@code RoleUtils}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class RoleUtils {

    public static Boolean isInGroup(Integer role, Integer roleGroup) {
        if (null == role) {
            return false;
        }

        return 0 != (role & roleGroup);
    }
}