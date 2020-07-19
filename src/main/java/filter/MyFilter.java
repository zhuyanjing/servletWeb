package filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public MyFilter(){
        System.out.println("MyFilter  contructor...");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init  MyFilter ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy  MyFilter...");
    }
}
