package com.zubayr.MyServer;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

//@WebServlet("/")
public class MyServlet extends HttpServlet {

    private DBTemplate template;

    @Override
    public void init(ServletConfig config) throws ServletException {
        template = new DBTemplate();
        //try {
            //template.createTable();
        //} catch (SQLException throwables) {
          //  throwables.printStackTrace();
        //}
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.setContentType("text/html;charset=Windows-1251");
            String msg = template.getAllDevelopers().stream().reduce((e1,e2) -> (e1.concat("<br/>")) + e2).orElse("список пуст");
            resp.getWriter().print(msg);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        template.add(req.getParameter("name"));
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){

        String queryString = req.getRequestURI();
        int index = queryString.lastIndexOf("/");
        String id = queryString.substring(++index);
        template.delete(Integer.valueOf(id));
    }
}
