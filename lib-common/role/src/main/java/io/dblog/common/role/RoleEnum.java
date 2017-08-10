package io.dblog.common.role;

import lombok.Getter;

/**
 * {@code RoleEnum}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public enum RoleEnum {
    GENERAL(1, RoleConstant.ROLE_GENGERAL),
    ADMIN(1 << 2, RoleConstant.ROLE_ADMIN),
    SUPER_ADMIN(1 << 3, RoleConstant.ROLE_SUPER);

    @Getter
    private final int id;

    @Getter
    private final String role;

    RoleEnum(int id, String role) {
        this.id = id;
        this.role = role;
    }
}