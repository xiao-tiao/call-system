package com.wf.dao.system;

import com.wf.entity.system.Post;
import com.wf.entity.system.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("postDao")
public interface PostDao {
    public void insert(Post post);
    public void delete(int id);
    public void update(Post post);
    public Post findOne(int id);
    public List<Post> findAll();
    public List<Post> findPost(Post post);
    public void deleteBySid(int id);
    public void deleteByDid(int id);
    public void deleteBySDid(@Param("id") int id[]);
}
