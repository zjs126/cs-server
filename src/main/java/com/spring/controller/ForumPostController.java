package com.spring.controller;

import com.spring.pojo.Post;
import com.spring.pojo.Result;
import com.spring.service.ForumPostService;
import com.spring.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/forum")
@CrossOrigin
public class ForumPostController {
    @Autowired
    private ForumPostService forumPostService;

    /**
     * 查找所有帖子
     *
     * @return 结果集
     */
    @GetMapping("/findAll")
    public Result findAll() {
        List<Post> allPost = forumPostService.findAll();
        return Result.success(allPost);
    }

//    /**
//     * 根据 pages 和 rows 获取帖子
//     *
//     * @param pages 页码数
//     * @param rows  一页有多少个帖子
//     * @return 结果集
//     */
//    @GetMapping("/getPostByPage/{pages}/{rows}")
//    public Result getPostByPage(@PathVariable(value = "pages") Integer pages,
//                                @PathVariable(value = "rows") Integer rows) {
//        Page<Post> postPage = forumPostService.selectPostByPages(pages, rows);
//        return Result.success(postPage);
//    }

    /**
     * 保存帖子
     *
     * @param post 帖子实体类
     * @return 结果集
     */
    @PostMapping("/savePost")
    public Result savePost(@RequestBody Post post, HttpServletRequest request) {

        String token = request.getParameter("token");
        Claims claims = JwtUtils.parseJWT(token);
        String username = (String) claims.get("username");
        post.setUsername(username);
        post.setLocalDateTime(LocalDateTime.now());
        char c = forumPostService.savePost(post);
        if (c == 0)
            return Result.error("save post failed");

        return Result.success("success");
    }
//
//    /**
//     * 根据关键字搜索帖子
//     *
//     * @param keywords 关键字
//     * @param pages    页码数
//     * @param rows     一页有多少个帖子
//     * @return 结果集
//     */
//    @GetMapping("/searchPost/{keywords}/{pages}/{rows}")
//    public Result searchPost(@PathVariable(value = "keywords") String keywords,
//                             @PathVariable(value = "pages") Integer pages,
//                             @PathVariable(value = "rows") Integer rows) {
//        Page<Post> postPage = forumPostService.searchPost(keywords, pages, rows);
//        return Result.success(postPage);
//    }

    @PostMapping("/savaStatement")
    public Result saveStatement(@RequestBody Post post, HttpServletRequest request) {

        String token = request.getParameter("token");
        Claims claims = JwtUtils.parseJWT(token);
        String username = (String) claims.get("username");
        post.setUsername(username);
        post.setLocalDateTime(LocalDateTime.now());
        char c = forumPostService.saveStatement(post);
        if (c == 0)
            return Result.error("save post failed");

        return Result.success("success");
    }

    @GetMapping("/searchStatement/{postid}")
    public Result searchStatement(@PathVariable(value = "postid") String id) {
        List<Post> statements = forumPostService.searchStatement(id);
        return Result.success(statements);
    }

    /**
     * 根据 id 查找帖子
     *
     * @param id 帖子编号
     * @return 结果集
     */
    @GetMapping("/findPostById/{id}")
    public Result findPostById(@PathVariable(value = "id")String id) {
        Post post = forumPostService.findById(id);
        return Result.success(post);
    }

    @GetMapping("/searchPostByUsername/{username}")
    public Result searchPostByUsername(@PathVariable(value = "username")String username){
        List<Post> posts=forumPostService.searchPostByUsername(username);
        return Result.success(posts);
    }
    /**
     * 根据 id 删除帖子
     *
     * @param id 帖子编号
     * @return 结果集
     */
    @DeleteMapping("/deletePost/{id}")
    public Result deletePost(@PathVariable(value = "id") String id) {
        forumPostService.deletePostById(id);
        return Result.success("success");
    }

    @PostMapping("/addlikenumber/{postid}")
    public Result addlikenumbers(@PathVariable(value ="postid")Integer id) {
        int bool = forumPostService.addlikenumbers(id);
    if(bool==1){
        return Result.success();
    }else return Result.error("添加失败");
    }

    @PostMapping("/updatePost")
    public Result updatePost(@RequestBody Post post){
        post.setLocalDateTime(LocalDateTime.now());
        String a=forumPostService.updatePostId(post);
        if(a==null){
            return Result.error("修改失败");
        }
        return Result.success("修改成功");
    }

    @GetMapping("/postStatemented/{username}")
    public Result postStatemented(@PathVariable(value = "username") String username){
        List<String> postid =forumPostService.searchPostidByUsername(username);
        return Result.success(postid);
    }
}
