package rs.ac.uns.ftn.informatika.osa.pr19.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.osa.pr19.entity.User;


public class AuthorizationFilter implements Filter {
  
  private String loginPage = null;
  
  public void init(FilterConfig cfg) throws ServletException {
    loginPage = cfg.getInitParameter("login-page");
    if (loginPage == null)
      throw new ServletException("AuthorizationFilter: missing init parameter 'login-page'");
  }
  
  public void destroy() {
  }
  
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws ServletException, IOException {
    HttpServletRequest req = (HttpServletRequest)request;
    
    // ako se pristupa login stranici ili servletu, ne diraj nista
    if (req.getRequestURI().indexOf("login") != -1) {
      chain.doFilter(request, response);
      return;
    }
    
    // u suprotnom prebaci na login stranicu ako sesija ne postoji
    HttpSession session = req.getSession(false);
    if (session == null) {
      request.getRequestDispatcher(loginPage).forward(request, response);
    } else {
      User user = (User)session.getAttribute("user");
      if (user == null || user.getUsername() == null) {
        request.getRequestDispatcher(loginPage).forward(request, response);
      } else {
        chain.doFilter(request, response);
      }
    }
  }

}
