package com.wf.service.system;

import com.wf.entity.system.Post;


import java.util.List;

public interface PostService {
    public void add(Post post);
    public void delete(int id);
    public void update(Post post);
    public Post searchOne(int id);
    public List<Post> searchAll();
    public List<Post> findPost(Post post);
}
