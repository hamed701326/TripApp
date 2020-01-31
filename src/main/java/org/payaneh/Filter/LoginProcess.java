package org.payaneh.Filter;



import org.payaneh.entities.User;
import org.payaneh.repositories.UserRepository;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginProcess implements Filter {
    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();

        String password = req.getParameter("password");
        String userName=req.getParameter("username");
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        User user1=UserRepository.getUserRepository().valid(user);
        if (!user1.equals(null)) {
            HttpSession session=((HttpServletRequest)req).getSession(true);
            session.setAttribute("user",user1);
            filterChain.doFilter(req, resp);//sends request to next resource
        } else {
            out.print("username or password error!");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
    }
}
