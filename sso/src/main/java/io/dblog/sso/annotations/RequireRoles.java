package io.dblog.sso.annotations;

import io.dblog.common.role.RoleEnum;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Check permissions, if appear this annoation, user must be logined status.
 * {@code RequireRoles}
 * @Scope: controller class or method
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequireRoles {

    @AliasFor("value")
    RoleEnum[] value() default {};
}
