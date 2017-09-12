package io.dblog.sso.filter;

import io.dblog.sso.service.session.Session;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * {@code SessionFilter}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (null == cookie) {
                continue;
            }

            String cookieName = cookie.getName();
            if (Objects.equals(cookieName, "sid") && StringUtils.isNotBlank(cookie.getValue())) {
                chain.doFilter(req, resp);
                return;
            }
        }

        Cookie cookie = new Cookie("sid", "456789");
        cookie.setMaxAge(11111111);

        HttpServletResponse response = (HttpServletResponse) resp;
        response.addCookie(cookie);

        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {}
}
