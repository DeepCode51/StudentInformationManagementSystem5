package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    ClassService classService;


    //批量生成学生测试数据
    @RequestMapping("addStudent")
    public String addStudent(){
        Student student = new Student();
        for(int i=0;i<500;i++){
            Random random = new Random();
            String a =random.nextInt(9)+"";
            String b =random.nextInt(9)+"";
            String c =random.nextInt(9)+"";
            String d =random.nextInt(9)+"";
            String e =random.nextInt(9)+"";
            String f = random.nextInt(56)+"";
            String uid = "2018"+a+"00"+b+c+d+e;

            student.setStu_id(uid);
            student.setStu_name("user_"+a+i);
            student.setStu_password("123456");
            student.setStu_email("user_"+i+"@163.com");
            student.setStu_id_card("340123199"+a+"0"+c+d+e+"5866");
            if(random.nextInt(9)>5){
                student.setStu_sex("男");
            }else {
                student.setStu_sex("女");
            }

            student.setStu_birthday("199"+a+"-0"+c+"-"+d+e);
//            Nation nation = nationService.getNationById("1");

            student.setNation_name("汉族");
            student.setStu_status("在校");
            student.setStu_age(random.nextInt(9)+16+"");
            student.setClass_id("G"+a+"0"+b);
            student.setStu_enrollment_time("2003-1-1");
            student.setStu_political("团员");
            student.setStu_address("安徽省合肥市");
            student.setStu_image("/images/2019-08-02/5705f0d1-4627-4f76-a630-9193866655fb.jpg");
            studentService.addStudent(student);

        }


        return "sd1";

    }


    //查询所有学生
    @RequestMapping("student/all")
    public @ResponseBody
    Map<String,Object> allStudent(int page, int limit){
        int count = studentService.getAllStudent().size();
        PageHelper.startPage(page,limit);
        List<Student> studentList1 = studentService.getAllStudent();

        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList1);

        List<Student> studentList = studentPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",studentList);
        return resultMap;

    }

    //删除学生信息
    @RequestMapping("student/delete/{stu_id}")
    public String delete(@PathVariable("stu_id")String stu_id){
        studentService.delete(stu_id);
        return "user/blank";
    }

    //查询学生的学习成绩卡
    @RequestMapping("student/findcard")
    public String findCard(){
        List<Student> studentList = studentService.getAllStudent();
        for (Student s:
             studentList) {
            String stu_id = s.getStu_id();
            List<Student_Grades_Card> cardList = gradesService.getGradesCard(stu_id);

        }


        return "user/blank";
    }

    //查询学生成绩
    @RequestMapping("student/grades/{stu_id}")
    public String findStudentGrades(@PathVariable("stu_id") String stu_id){
        List<Student_Grades_Card> cardList = gradesService.getGradesCard(stu_id);
        for (Student_Grades_Card card:
             cardList) {
            Student_Grades grades = gradesService.getGrades(card.getStu_grades_card_id());
            System.out.println(grades);
        }


        return "user/blank";
    }

    //更新用户信息
    @RequestMapping("/editstudent")
    public String editstudent(Student student){
       studentService.updateStudent(student);
        return "student/allstudent";
    }

    //根据stu_id查找用户信息，并返回到界面
    @RequestMapping("student/toeditstudent/{stu_id}")
    public ModelAndView toeditstudent(@PathVariable("stu_id") String stu_id){
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(stu_id);
        modelAndView.addObject("student",student);
        modelAndView.setViewName("student/editstudent");


        return modelAndView;
    }
    //跳转到添加学生界面
    @RequestMapping("toaddstudent")
    public String tostudent(Model model){

        List<Nation> nationList = nationService.getAllNation();
        model.addAttribute("nationList",nationList);
        List<SClass> classList = classService.getAllClass();
        model.addAttribute("classList",classList);
        return "student/addstudent";
    }

    //添加学生信息
    @RequestMapping("student/addstudent")
    public String addstudent(Student student){
        //注册学生信息
        String stu_id = UUID.randomUUID()+"";
        stu_id = stu_id.replace("-","");
        student.setStu_id(stu_id);

        studentService.addStudent(student);

        //注册学生信息时,自动注册用户信息

        User user = new User();
        user.setUsername(student.getStu_name());
        user.setPassword(student.getStu_password());
        user.setEmail(student.getStu_email());
        user.setBirthday(student.getStu_birthday());
        user.setGender(student.getStu_sex());
        user.setImages(student.getStu_image());
        user.setActivecode(stu_id);
        userService.addUser(user);

        //授予该学生权限

        User_Role user_role = new User_Role();
        user_role.setUid(user.getUid());
        user_role.setU_r_id(stu_id);
        user_role.setUsername(student.getStu_name());
        user_role.setRoleid("cccdd017ff3b4f9dba8ff77c7836e1f6");
        user_role.setRole("学生");
        user_role.setRole_describe("学生可以查看学生、班级信息、我的成绩");
        permissionService.addUser_Role(user_role);


        return "menu/msg";

    }


}
