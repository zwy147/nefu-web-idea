package com.xu.dao;

import com.xu.entity.Blog;
import com.xu.entity.User;
import com.xu.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlogDao {
    private static QueryRunner qr;
    static {
        qr = new QueryRunner(C3P0Utils.getDataSource());
    }

    /**
     * 获取博客列表
     * @return
     */
    public List<Blog> getBlogList(){
        List<Blog> blogList = null;
        try {
            String sql = "select * from t_blog";

            blogList = qr.query(sql, new BeanListHandler<>(Blog.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogList;
    }
    /**
     * 删除某个博客
     */
    public void deleteBlogById(int id){
        try {
            String sql = "delete from t_blog where id = ?";

            qr.update(sql , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 增加
     */
    public void addBlog(String title, String content){

        try {
            String sql = "INSERT INTO t_blog(blog_title,blog_content) VALUES(?,?);";
            Object[] params = {title, content};
            qr.update(sql , params);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改
     */
    public void updateBlog(String title, String content,int id){

        try{
            String sql = "UPDATE t_blog SET blog_title=?, blog_content=? WHERE id=?";
            Object[] params = {title,content, id};
            qr.update(sql , params);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
