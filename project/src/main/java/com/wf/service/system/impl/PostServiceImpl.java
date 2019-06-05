package com.wf.service.system.impl;

import com.wf.dao.system.PostDao;
import com.wf.entity.system.Post;
import com.wf.service.system.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;
    public void add(Post post) {
        post.setStatus("正常");
        postDao.insert(post);
    }

    public void delete(int id) {
        postDao.delete(id);
    }

    public void update(Post post) {
            postDao.update(post);
    }

    public Post searchOne(int id) {
        return postDao.findOne(id);
    }

    public List<Post> searchAll() {
        return postDao.findAll();
    }

    public List<Post> findPost(Post post) {
        return postDao.findPost(post);
    }
}
