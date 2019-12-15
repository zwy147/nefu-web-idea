package com.xu.web;


import com.xu.dao.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlogAddServlet extends HttpServlet {
    private BlogDao blogDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        blogDao = new BlogDao();
        blogDao.addBlog(req.getParameter("blog_title"),req.getParameter("blog_content"));
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("添加成功！");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
    }