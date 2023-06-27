package com.spring.service.impl;

import com.spring.mapper.ForumPostMapper;
import com.spring.pojo.Post;
import com.spring.service.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumPostServiceImpl implements ForumPostService {
    @Autowired
    private ForumPostMapper forumPostMapper;

    @Override
    public List<Post> findAll() {
        return forumPostMapper.findall();
    }

//    @Override
//    public Page<Post> selectPostByPages(Integer pages, Integer rows) {
//        return forumPostMapper.selectPage(new Page<>(pages, rows), null);
//    }

    /**
     * 保存帖子
     *
     * @param post 帖子实体类
     * @return 0 表示保存失败，1 表示保存成功
     */
    @Override
    public char savePost(Post post) {
        int i = forumPostMapper.insert(post);
        if (i == 0)
            return 0;
        return 1;
    }

//    /**
//     * 根据关键词搜索帖子
//     *
//     * @param keywords 关键词
//     * @param pages    页码数
//     * @param rows     一页有多少个
//     * @return 符合条件的所有帖子
//     */
//    @Override
//    public Page<Post> searchPost(String keywords, Integer pages, Integer rows) {
//        LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.like(Post::getTitle, keywords)
//                .or().like(Post::getContent, keywords)
//                .or().like(Post::getUsername, keywords);
//        return forumPostMapper.selectPage(new Page<>(pages, rows), queryWrapper);
//    }

    @Override
    public Post findById(String id) {
        return forumPostMapper.SelectById(Integer.valueOf(id));
    }

    @Override
    public String updatePostId(Post postDetails) {
        Post post = forumPostMapper.selectById(postDetails.getPostid());
        if (post == null) {
            return null;
        }

        forumPostMapper.updateById(postDetails);
        return "更新成功";
    }

    /**
     * 根据 id 删除帖子
     *
     * @param id 帖子实体类
     * @return 返回 0 表示不存在该帖子，返回 1 表示删除成功
     */
    @Override
    public void deletePostById(String id) {
        forumPostMapper.DeleteById(id);
    }


    @Override
    public List<Post> searchStatement(String id) {
        return forumPostMapper.selectByType(id);
    }

    @Override
    public char saveStatement(Post post) {
        String postid = post.getType();
        addnumbers(postid);
        int i = forumPostMapper.insert(post);
        if (i == 0)
            return 0;
        return 1;
    }

    @Override
    public void addnumbers(String postid) {
        forumPostMapper.updateStatementNumbers(postid);
    }

    @Override
    public int addlikenumbers(Integer id) {
        forumPostMapper.updatelike(id);
        return 0;
    }

    @Override
    public List<Post> searchPostByUsername(String username) {
        return forumPostMapper.searchPostByUsername(username);
    }

    @Override
    public List<String> searchPostidByUsername(String username) {
        return forumPostMapper.searchPostidByUsername(username);
    }
}
