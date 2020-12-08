package com.valid.dao;

import com.valid.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogIF(Map<String, Object> map);

    //
    List<Blog> queryBlogChoose(Map<String, Object> map);

    // 更新博客
    int updateBlog(Map<String, Object> map);

    // 查询1-2-3号的博客
    List<Blog> queryBlogForeach(Map<String, Object> map);
}
