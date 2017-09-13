package io.dblog.sso.filter;

import io.dblog.sso.util.CookieUtils;
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
import java.util.HashMap;
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
        if (null != CookieUtils.getByName(request, CookieUtils.SESSION_NAME)) {
            chain.doFilter(req, resp);
            return;
        }

        Cookie cookie = new Cookie(CookieUtils.SESSION_NAME, "456789");
        cookie.setMaxAge(11111111);

        HttpServletResponse response = (HttpServletResponse) resp;
        response.addCookie(cookie);

        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {}
}
