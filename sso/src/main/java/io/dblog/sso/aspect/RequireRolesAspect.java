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

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * {@code RequireRolesAspect}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Component
@Aspect
public class RequireRolesAspect {

    @Autowired
    private SessionStore sessionStore;

    @Pointcut("@annotation(requireRoles)")
    public void annotationRequireRoles(RequireRoles requireRoles) {}

    @Around(value = "annotationRequireRoles(requireRoles)", argNames = "point,requireRoles")
    public void before(ProceedingJoinPoint point, RequireRoles requireRoles) {
        for (Object arg : point.getArgs()) {
            if (!(arg instanceof HttpServletRequest)) {
                continue;
            }

            HttpServletRequest request = (HttpServletRequest) arg;
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
}
