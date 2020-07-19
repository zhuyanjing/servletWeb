package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    private String name;

    public MyServlet(){
        System.out.println("MyServlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do  get");
        String name = req.getParameter("name");
        if(name!=null && name !=""){
            this.name = name;
        }
        System.out.println("name is :"+ this.name);
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do  post");
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
        super.destroy();
    }
}
