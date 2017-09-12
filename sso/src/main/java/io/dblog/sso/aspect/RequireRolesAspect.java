package io.dblog.sso.aspect;

import io.dblog.common.exception.UnauthorizedException;
import io.dblog.common.role.RoleEnum;
import io.dblog.common.role.RoleUtils;
import io.dblog.jpa.sso.entity.Account;
import io.dblog.sso.annotations.RequireRoles;
import io.dblog.sso.service.session.Session;
import io.dblog.sso.service.session.SessionStore;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * {@code RequireRolesAspect}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Aspect
@Component
public class RequireRolesAspect {

    @Autowired
    private SessionStore sessionStore;

    @Around("@annotation(requireRoles)")
    public void around(RequireRoles requireRoles) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String sid = (String) request.getAttribute("sid");
        if (StringUtils.isBlank(sid)) {
            return;
        }

        Session session = sessionStore.get(sid);
        if (null == session) {
            throw new UnauthorizedException("user.has.not.login");
        }

        Account account = session.getAccount();
        if (null == account) {
            throw new UnauthorizedException("user.permission.check.failed");
        }

        RoleEnum[] roleGroupArr = requireRoles.value();
        if (roleGroupArr.length <= 0) {
            return;
        }

        Integer role = account.getRole();
        Integer roleGroup = Math.toIntExact(
                Arrays.stream(roleGroupArr).map(RoleEnum::getRole).count()
        );
        if (!RoleUtils.isInGroup(role, roleGroup)) {
            throw new UnauthorizedException("user.has.no.permission");
        }
    }
}
