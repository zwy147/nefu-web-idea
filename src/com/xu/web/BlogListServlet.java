package com.xu.web;

import com.alibaba.fastjson.JSON;
import com.xu.dao.BlogDao;
import com.xu.entity.Blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BlogListServlet extends HttpServlet {

    private BlogDao blogDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        blogDao = new BlogDao();
        List<Blog> blogList = blogDao.getBlogList();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(blogList));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
