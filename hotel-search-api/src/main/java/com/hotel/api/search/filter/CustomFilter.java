package com.hotel.api.search.filter;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomFilter implements Filter {

    public CustomFilter() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest) req).getHeader("authorization");
        MDC.put("token",((HttpServletRequest) req).getHeader("authorization").substring("Bearer ".length()));
        chain.doFilter(req, res);
        MDC.remove("token");
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}