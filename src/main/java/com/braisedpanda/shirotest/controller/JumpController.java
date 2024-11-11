package com.braisedpanda.shirotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JumpController {

    @RequestMapping("toregist")
    public String toregist(){
        return "user/regist";
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

    @RequestMapping("jump")
    public String tojump(){
        return "test/jump";
    }

    @RequestMapping("index")
    public String index(){
        return "menu/main";
    }
    @RequestMapping("uploadtest")
    public String upload(){
        return "user/upload";
    }


    @RequestMapping("notRole")
    public String testr(){
        return "menu/nopermission";
    }

    @RequestMapping("tostudentlist")
    public String tostudentlist(){
        return "student/allstudent";
    }



    @RequestMapping("toallpermission")
    public String toallpermission(){
        return "permission/allrole_permission";
    }


    @RequestMapping("toleft")
    public String toleft(){
        return "menu/left";
    }

    @RequestMapping("toallrole")
    public String toallrole(){
        return "permission/allrole";
    }


    @RequestMapping("toclassgrades")
    public String toclassgrades(){
        return "class/classgrades";
    }



}
