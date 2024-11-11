package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.SClass;
import com.braisedpanda.shirotest.bean.Student;
import com.braisedpanda.shirotest.bean.Student_Grades;
import com.braisedpanda.shirotest.bean.Student_Grades_Card;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.GradesService;
import com.braisedpanda.shirotest.service.NationService;
import com.braisedpanda.shirotest.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ClassController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;

    //批量生成学生测试数据
    @ResponseBody
    @RequestMapping("addClass")
    public List addClass(){
        SClass sclass = new SClass();
        List<String> classidList = studentService.getAllClass();
        for (String classid:
             classidList) {
                String[] teacherlist = new String[]{"节振国","赵大华","汤绍箕","黄强辉",
                        "孙德林 ","赵进","张志","孙顺达","孙寿康","吴国梁","张石山","吕文达",
                        "李文","马连良","贾德善","马良","吴克","宗敬先","吕德","钱生禄",};

                int s = teacherlist.length;
                Random random = new Random();
                int a = random.nextInt(s);
                int b = random.nextInt(s);
                int c = random.nextInt(s);
                int d = random.nextInt(s);
                int e = random.nextInt(s);
                int f = random.nextInt(s);
                int g = random.nextInt(s);
                int h = random.nextInt(s);
                int i = random.nextInt(s);
                int j = random.nextInt(s);
                int k = random.nextInt(s);
                int l = random.nextInt(s);
                int m = random.nextInt(s);
                sclass.setClass_id(classid);
                sclass.setClass_name(classid);
                sclass.setClass_teacher(teacherlist[a]);
                sclass.setChinese_teacher(teacherlist[b]);
                sclass.setMathematics_teacher(teacherlist[c]);
                sclass.setEnglish_teacher(teacherlist[d]);
                sclass.setPolitics_teacher(teacherlist[e]);
                sclass.setHistory_teacher(teacherlist[f]);
                sclass.setGeography_teacher(teacherlist[g]);
                sclass.setBiology_teacher(teacherlist[h]);
                sclass.setChemistry_teacher(teacherlist[i]);
                sclass.setPhysics_teacher(teacherlist[j]);
                sclass.setMusic_teacher(teacherlist[k]);
                sclass.setArts_teacher(teacherlist[l]);
                sclass.setSports_teacher(teacherlist[m]);

                int count = studentService.getStudentConutByCid(classid);
                sclass.setClass_count(count);
                classService.addClass(sclass);
                System.out.println(sclass);






        }
        return classidList;

    }


    //查询所有班级
    @RequestMapping("class/all")
    public @ResponseBody
    Map<String,Object> allClass(int page, int limit){
        int count = classService.getAllClass().size();
        PageHelper.startPage(page,limit);
        List<SClass> sClassList1 = classService.getAllClass();

        PageInfo<SClass> classPageInfo = new PageInfo<>(sClassList1);

        List<SClass> classtList = classPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",classtList);
        return resultMap;

    }

    //跳转界面
    @RequestMapping("toclasslist")
    public String toclasslist(){
        return "class/allclass";
    }


    //根据classid值删除class
    @ResponseBody
    @RequestMapping("class/delete/{class_id}")
    public void deleteClassById(@PathVariable("class_id") String class_id){

        classService.deleteClassById(class_id);
    }

    //跳转到编辑班级界面
    @RequestMapping("class/toeditclass/{class_id}")
    public ModelAndView toeidtclass(@PathVariable("class_id") String class_id){
        ModelAndView modelAndView = new ModelAndView();
       SClass sclass =  classService.getClassById(class_id);
       modelAndView.addObject("class",sclass);
       modelAndView.setViewName("class/edit_class");
        return modelAndView;

    }

    @RequestMapping("editclass")
    public String editClass(SClass sClass,Model model){
        System.out.println(sClass);
        classService.updateClass(sClass);

        model.addAttribute("msg","编辑班级信息成功");
        return "menu/msg";
    }

}
