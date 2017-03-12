package com.creheart.platform.filter;

import com.creheart.domain.PlatAdmin;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sunny-chen on 2017/3/11.
 */
@Component
public class PlatSessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String[] loginPaths = {"/Bella/Admin/admin.do","/Bella/Admin/admin/login.do"};
        for (String path : loginPaths) {
            if (uri.equals(path)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PlatAdmin admin = (PlatAdmin) request.getSession().getAttribute("platAdmin");
        if (null == admin) {
            request.getRequestDispatcher("/Admin/admin.do").forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
