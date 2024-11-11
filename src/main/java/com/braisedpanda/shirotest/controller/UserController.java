package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.bean.User_Role;
import com.braisedpanda.shirotest.service.PermissionService;
import com.braisedpanda.shirotest.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;


    //查找所有的用户
    @RequestMapping("/alluser")
    public ModelAndView allUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.getAllUser();

        modelAndView.addObject("useList",userList);
        modelAndView.setViewName("index");
       return modelAndView;
    }

    //用户注册
    @RequestMapping("/regist")
    public String regist(User user,Model model,String activecode){
        if(activecode ==null || activecode.length()==0){
            user.setActivecode("0");
        }
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");
        userService.addUser(user);

        model.addAttribute("user",user);

        return "redirect:/";
    }

    //用户登录
    @PostMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();


        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (IncorrectCredentialsException ice) {
            modelAndView.addObject("tips","*密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (LockedAccountException lae) {
            modelAndView.addObject("tips","*账户已锁定~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (ExcessiveAttemptsException eae) {
            modelAndView.addObject("tips","*用户名或密码错误次数过多~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (AuthenticationException ae) {
            modelAndView.addObject("tips","*用户名或密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        if (subject.isAuthenticated()) {
            User user = userService.getUser(username,password);
            session.setAttribute("user",user);
            modelAndView.setViewName("menu/main");
            return modelAndView;
        } else {
            token.clear();
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }

//
    @GetMapping("test1")
    public String test1(){
        return "user/userlist";
    }

    //查找所有用户(使用分页助手)
    @RequiresPermissions("finds")
    @RequestMapping("/userlist/{startPage}")
    public ModelAndView  userlist(@PathVariable("startPage") int startPage){
        ModelAndView modelAndView = new ModelAndView();
        int totalCount = userService.getAllUser().size();
        PageHelper.startPage(startPage,8);
        List<User> userList1 = userService.getAllUser();
        int totalPage ;
        if(totalCount % 8 ==0){
            totalPage = totalCount / 8;
        }else{
            totalPage = totalCount / 8 +1 ;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
        List<User> userList = userPageInfo.getList();

        modelAndView.addObject("userList",userList);
        //向前端页面传入总页数和当前页数，方便操作
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("startPage",startPage);
        modelAndView.setViewName("user/userlist");

        return modelAndView;
    }
    //删除用户
    @RequestMapping("/delete/{uid}")
    public String delete(@PathVariable("uid") String uid){
        userService.delete(uid);

        return "user/blank";
    }

    //修改用户信息(回显)

    @RequestMapping("edituser/{uid}")
    public ModelAndView getuser(@PathVariable("uid") int uid){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserByUid(uid);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }
    //修改用户信息
    @RequestMapping("user/edit")
    public ModelAndView  edituser(User user){
        int startPage = 1;

        userService.edit(user);
        ModelAndView modelAndView = new ModelAndView();
        int totalCount = userService.getAllUser().size();
        PageHelper.startPage(startPage,8);
        List<User> userList1 = userService.getAllUser();
        int totalPage ;
        if(totalCount % 8 ==0){
            totalPage = totalCount / 8;
        }else{
            totalPage = totalCount / 8 +1 ;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
        List<User> userList = userPageInfo.getList();

        modelAndView.addObject("userList",userList);
        //向前端页面传入总页数和当前页数，方便操作
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("startPage",startPage);
        modelAndView.setViewName("user/userlist");

        return modelAndView;
    }
    //编辑用户(后台编辑)
    //修改用户信息
    @RequestMapping("user_edit")
    public String user_edit(User user){


        userService.edit(user);


        return "user/success";
    }

    //新增用户（后台添加）

    @RequestMapping("/adduser")
    public ModelAndView adduser(User user,Model model,String activecode){
        if(activecode ==null || activecode.length()==0){
            user.setActivecode("0");
        }
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");
        userService.addUser(user);

        model.addAttribute("user",user);
        int startPage = 1;

        userService.edit(user);
        ModelAndView modelAndView = new ModelAndView();
        int totalCount = userService.getAllUser().size();
        PageHelper.startPage(startPage,8);
        List<User> userList1 = userService.getAllUser();
        int totalPage ;
        if(totalCount % 8 ==0){
            totalPage = totalCount / 8;
        }else{
            totalPage = totalCount / 8 +1 ;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList1);
        List<User> userList = userPageInfo.getList();

        modelAndView.addObject("userList",userList);
        //向前端页面传入总页数和当前页数，方便操作
        modelAndView.addObject("totalPage",totalPage);
        modelAndView.addObject("startPage",startPage);
        modelAndView.setViewName("user/userlist");

        return modelAndView;


    }
    //添加用户(layui弹出层)
    //新增用户（后台添加）
    @RequestMapping("/add_user")
    public String add_user(User user){
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");

        userService.addUser(user);


        return "user/success";


    }
    //退出登录
    @RequestMapping("/quite")
    public String quite(HttpSession session){
        session.removeAttribute("user");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        return "redirect:/";
    }









    @RequestMapping("user/table")
    public @ResponseBody Map<String,Object> testtable(int page,int limit){
        int count = userService.getAllUser().size();
        PageHelper.startPage(page,limit);
        List<User> userList1 = userService.getAllUser();

        PageInfo<User> userPageInfo = new PageInfo<>(userList1);

        List<User> userList = userPageInfo.getList();
        for (User user:
             userList) {
            List<User_Role> user_roleList = permissionService.getRoleById(user.getUid()+"");
            StringBuffer sb = new StringBuffer();
            if(user_roleList ==null || user_roleList.size()==0){
                user.setRoleList("无角色");
            }
            else {
                for (User_Role user_role :
                        user_roleList) {
                    sb.append("【");
                    sb.append(user_role.getRole());
                    sb.append("】");

                }
                user.setRoleList(sb.toString());
            }



        }
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",userList);
        return resultMap;

    }



    @RequestMapping("/userlist2")
    public  String userlist2(){


        return "user/userlist2";
    }
    //图片上传测试
    @ResponseBody
    @RequestMapping("upload")
    public Map upload(MultipartFile file,HttpServletRequest request){

        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                String filepath = "D:\\StudentManagementSystem\\src\\main\\resources\\static\\images\\" + dateStr+"\\"+uuid+"." + prefix;


                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map2=new HashMap<>();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                map2.put("src","/images/"+ dateStr+"/"+uuid+"." + prefix);
                return map;
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;

    }


    //修改用户信息(回显)

    @RequestMapping("userinfo")
    public ModelAndView userinfo(HttpSession session){
        User user1 = (User)session.getAttribute("user");
        int uid = user1.getUid();
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserByUid(uid);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/userlist2");
        return modelAndView;
    }








}
