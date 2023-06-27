package com.spring.controller;

import com.spring.pojo.Result;
import com.spring.pojo.User;
import com.spring.service.UserService;
import com.spring.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理Controller
 */

@Slf4j
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        log.info("注册");
        userService.register(user);

        return Result.success("success");
    }

    @PostMapping("/login/username")
    public Result loginByUsernameAndPassword(@RequestBody User user) {
        log.info("用户名登录：{}", user);
        User u = userService.loginByUsernameAndPassword(user);

        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/login/email")
    public Result loginByEmailAndPassword(@RequestBody User user) {
        log.info("邮箱登录：{}", user);
        User u = userService.loginByEmailAndPassword(user);

        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @GetMapping("/user")
    public Result Usersearch(HttpServletRequest request){
        log.info("用户信息获取");

        String token=request.getParameter("token");
        Claims claims=JwtUtils.parseJWT(token);
        Integer id= (Integer) claims.get("id");
        String username=(String) claims.get("username");
        User u=userService.UserSearch(id,username);

        if(u!=null){
            return Result.success(u);
        }
        return Result.error("用户查询失败");
    }

    @GetMapping("/username")
    public Result searchUserbyName(@RequestParam String username){
        log.info("通过用户名查询用户");

        User U=userService.searchUserbyName(username);
        return Result.success(U);
    }

    @PostMapping("/updateuser")
    public Result UpdateUser(HttpServletRequest request,@RequestBody User user){
        log.info("用户信息更新");

        String token=request.getParameter("token");
        Claims claims=JwtUtils.parseJWT(token);
        Integer id= (Integer) claims.get("id");
        user.setId(id);
        userService.UpdateUser(user);

        Map<String, Object> claim = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());

        String jwt = JwtUtils.generateJwt(claim);
        return Result.success(jwt);
    }

}
