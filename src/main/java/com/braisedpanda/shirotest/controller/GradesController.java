package com.braisedpanda.shirotest.controller;


import com.braisedpanda.shirotest.Utils.Utils;
import com.braisedpanda.shirotest.bean.*;
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

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import java.util.*;

@Controller
public class GradesController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;



    //批量生成学生成绩卡数据
    @RequestMapping("addGradesCard")
    public String addGradesCard(){
        Student_Grades_Card card = new Student_Grades_Card();
        List<Student> studentList = studentService.getAllStudent();
        for (Student s:
             studentList) {
            String stu_id = s.getStu_id();
            for(int i=1;i<=3;i++){
                String time = i+"";
                String stu_grades_card_id = "SGC"+time+stu_id;
                card.setStu_grades_card_id(stu_grades_card_id);
                card.setStu_id(stu_id);
                card.setTest_time(time);
                if(i==1){
                    card.setTest_describe("开学考试");

                }else if(i==2){
                    card.setTest_describe("期中考试");

                }else {
                    card.setTest_describe("期末考试");
                }
                gradesService.add(card);

            }
        }


        return "user/blank";

    }

    //批量生成学生成绩
    @RequestMapping("addGrades")
    public String addGrades(){
        List<Student> studentList = studentService.getAllStudent();
        for (Student s:
             studentList) {
            String stu_id = s.getStu_id();
            List<Student_Grades_Card> student_grades_cardList = gradesService.getGradesCard(stu_id);
            Student_Grades student_grades = new Student_Grades();
            for (Student_Grades_Card student_grades_card:
                    student_grades_cardList ) {
                String stu_grades_card_id = student_grades_card.getStu_grades_card_id();

                student_grades.setStu_grades_id("SGI"+stu_grades_card_id);
                student_grades.setStu_grades_card_id(stu_grades_card_id);
                Random random = new Random();
                double a = 60+random.nextInt(90);
                double b = 60+random.nextInt(90);
                double c = 60+random.nextInt(90);
                double d = 60+random.nextInt(90);
                double e = 60+random.nextInt(90);
                double f = 60+random.nextInt(90);
                double g = 60+random.nextInt(90);
                double h = 60+random.nextInt(90);
                double i = 60+random.nextInt(90);
                double j = 60+random.nextInt(90);
                double k = 60+ random.nextInt(90);
                double l = 60+random.nextInt(90);
                student_grades.setChinese(a);
                student_grades.setMathematics(b);
                student_grades.setEnglish(c);
                student_grades.setPolitics(d);
                student_grades.setHistory(e);
                student_grades.setGeography(f);
                student_grades.setBiology(g);
                student_grades.setChemistry(h);
                student_grades.setPhysics(i);
                student_grades.setMusic(j);
                student_grades.setArts(k);
                student_grades.setSports(l);

                double[] array = new double[]{a,b,c,d,e,f,g,h,i,j,k,l};
                double max=array[0];
                double min=array[0];
                double total=0;
                for(int x=0;x<array.length;x++){

                    if(max<array[x]){
                        max=array[x];
                    }
                    if(min>array[x]){
                        min=array[x];
                    }
                    total = total+array[x];
                }
                double ave = total/array.length;

                student_grades.setMaxscore(max);
                student_grades.setMinscore(min);
                student_grades.setTotal(total);
                student_grades.setAverage(ave);

                System.out.println(student_grades);
                gradesService.addGrades(student_grades);

            }



        }

        return "user/blank";

    }
    //查询学生成绩
    @ResponseBody
    @RequestMapping("grades/sudent/{stu_id}")
    public Map<String,Object> getStudentGrades(@PathVariable("stu_id") String stu_id,int page,int limit){
        List<StudentGradesCustom> sgcList = new ArrayList<StudentGradesCustom>();

        //根据学生id查找学生
        Student student = studentService.getStudentById(stu_id);

        //成绩卡，根据学生的id在成绩卡中，查询多次考试的成绩单号
        Student_Grades_Card gcard = new Student_Grades_Card();
        List<Student_Grades_Card> gcardList =  gradesService.getGradesCard(stu_id);
        for (Student_Grades_Card card:
                gcardList) {
            //创建前端展示的成绩单
            StudentGradesCustom sgc = new StudentGradesCustom();

            String cardid = card.getStu_grades_card_id();
            //多次成绩单号已经查到
           Student_Grades grades = gradesService.getGrades(cardid);

            //设置学生id
            sgc.setStu_id(stu_id);
            //设置学生姓名
            sgc.setStu_name(student.getStu_name());
            //设置学生班级
            sgc.setClass_id(student.getClass_id());
            //设置测试的描述信息
            sgc.setTest_describe(card.getTest_describe());
            //设置总分
            sgc.setTotal(grades.getTotal());
            //设置平均分
            sgc.setAverage(grades.getAverage());
            //设置最高分
            sgc.setMaxscore(grades.getMaxscore());
            //设置最低分
            sgc.setMinscore(grades.getMinscore());
            //设置语文分数
            sgc.setChinese(grades.getChinese());
            //设置数学分数
            sgc.setMathematics(grades.getMathematics());
            //设置英语分数
            sgc.setEnglish(grades.getEnglish());
            //设置政治分数
            sgc.setPolitics(grades.getPolitics());
            //设置历史分数
            sgc.setHistory(grades.getHistory());
            //设置地理分数
            sgc.setGeography(grades.getGeography());
            //设置生物分数
            sgc.setBiology(grades.getBiology());
            //设置化学分数
            sgc.setChemistry(grades.getChemistry());
            //设置物理分数
            sgc.setPhysics(grades.getPhysics());
            //设置音乐分数
            sgc.setMusic(grades.getMusic());
            //设置美术分数
            sgc.setArts(grades.getArts());
            //设置体育分数
            sgc.setSports(grades.getSports());
            //设置考试的时间
            sgc.setTest_time(card.getTest_time());

            sgcList.add(sgc);
        }



        int count = sgcList.size();
        PageHelper.startPage(page,limit);
   ;

        PageInfo<StudentGradesCustom> studentGradesPageInfo = new PageInfo<>(sgcList);

        List<StudentGradesCustom> studentGradesList = studentGradesPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",studentGradesList);
        return resultMap;




    }
    //跳转到我的成绩
    @RequestMapping("tostudentgrades")
    public String tostudentgrades(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        String stu_id = user.getActivecode();
        System.out.println(user);
        model.addAttribute("stu_id",stu_id);

        return "student/studentgrades";

    }

    //批量生成班级成绩卡
    @ResponseBody
    @RequestMapping("autoaddclass_gardes_card")
    public void autoaddclass_gardes_card(){
        //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
       List<Student_Grades_Card> sg_cardlist = gradesService.getSGCard();
       //获取所有的班级id
       List<String> classidlist = classService.getAllClassId();
        for (String s:
             classidlist) {
           //批量生成student_gardes_card信息
            for (Student_Grades_Card sgc:
                 sg_cardlist) {
                Class_Grades_Card cgcrad = new Class_Grades_Card();
                //设置唯一id值，CGC+班级id+考试时间
                String class_grades_card_id = "CGC"+s+sgc.getTest_time().replace("-","");
                cgcrad.setClass_grades_card_id(class_grades_card_id);
                //设置class_id
                cgcrad.setClass_id(s);
                cgcrad.setTest_time(sgc.getTest_time());
                cgcrad.setTest_describe(sgc.getTest_describe());


               gradesService.addClass_Grades_Card(cgcrad);
            }

        }

    }

    //批量生成班级成绩统计
    @ResponseBody
    @RequestMapping("addclass_grades")
    public HashMap<String,Object> addclass_grades(){
        HashMap<String,Object> resultMap = new HashMap<>();

        //获取各个班的所有学生
        Class_Grades class_grades = new Class_Grades();
        //获取所有的班级成绩卡片
        List<Class_Grades_Card> class_grades_cardList = gradesService.getAllClass_Grades_Card();

        for (Class_Grades_Card class_Grades_Card:
                class_grades_cardList  ) {

            String class_grades_id = "CGI"+ class_Grades_Card.getClass_grades_card_id();
            class_grades.setClass_grades_id(class_grades_id);
            class_grades.setClass_grades_card_id(class_Grades_Card.getClass_grades_card_id());

            //获取class_id
            String class_id = class_Grades_Card.getClass_id();
            System.out.println("班级ID："+class_id+"==============================");

                //根据class_id查找出该班级所有的学生
                List<Student> studentList = studentService.getStudentByClassId(class_id);

                            List<Double> totallist = new ArrayList<>();
                            List<Double> chineselist = new ArrayList<>();
                            List<Double> mathematicslist = new ArrayList<>();
                            List<Double> englishlist = new ArrayList<>();
                            List<Double> politicslist = new ArrayList<>();
                            List<Double> historylist = new ArrayList<>();
                            List<Double> geographylist = new ArrayList<>();
                            List<Double> biologylist = new ArrayList<>();
                            List<Double> chemistrylist = new ArrayList<>();
                            List<Double> physicslist = new ArrayList<>();
                            List<Double> musiclist = new ArrayList<>();
                            List<Double> artslist = new ArrayList<>();
                            List<Double> sportslist = new ArrayList<>();

                            System.out.println("该班级所有学生：==============================");

                            for (Student stu:
                                    studentList) {
                                System.out.println("学生姓名："+stu.getStu_name());

                                //根据每个学生的学生stu_id，查找出该学生的成绩卡
                                String stu_id = stu.getStu_id();
                                String time_describe = class_Grades_Card.getTest_describe();

                                Student_Grades_Card  student_Grades_Card = gradesService.getGradesCardById_and_DesCribe(stu_id,time_describe);

                                String stu_grades_card_id = student_Grades_Card.getStu_grades_card_id();

                                Student_Grades student_grades =  gradesService.getGrades(stu_grades_card_id);

                                double total = student_grades.getTotal();
                                double chinese = student_grades.getChinese();
                                double mathematics = student_grades.getMathematics();
                                double english = student_grades.getEnglish();
                                double politics = student_grades.getPolitics();
                                double history = student_grades.getHistory();
                                double geography = student_grades.getGeography();
                                double biology = student_grades.getBiology();
                                double chemistry = student_grades.getChemistry();
                                double physics = student_grades.getPhysics();
                                double music = student_grades.getMusic();
                                double arts = student_grades.getArts();
                                double sports = student_grades.getSports();

                                totallist.add(total);
                                chineselist.add(chinese);
                                mathematicslist.add(mathematics);
                                englishlist.add(english);
                                politicslist.add(politics);
                                historylist.add(history);
                                geographylist.add(geography);
                                biologylist.add(biology);
                                chemistrylist.add(chemistry);
                                physicslist.add(physics);
                                musiclist.add(music);
                                artslist.add(arts);
                                sportslist.add(sports);

                            }
                            Utils utils = new Utils();
                            //总分各分值统计
                            Double total_max = utils.getMax(totallist);
                            Double total_min = utils.getMin(totallist);
                            Double total_aver = utils.getAver(totallist);

                            class_grades.setTotal_ave(total_aver);
                            class_grades.setTotal_max(total_max);
                            class_grades.setTotal_min(total_min);

                            //语文各分值统计
                            Double chinese_max = utils.getMax(chineselist);
                            Double chinese_min = utils.getMin(chineselist);
                            Double chinese_aver = utils.getAver(chineselist);

                            class_grades.setChinese_ave(chinese_aver);
                            class_grades.setChinese_max(chinese_max);
                            class_grades.setChinese_min(chinese_min);

                            //数学各分值统计
                            Double mathematics_max = utils.getMax(mathematicslist);
                            Double mathematics_min = utils.getMin(mathematicslist);
                            Double mathematics_aver = utils.getAver(mathematicslist);

                            class_grades.setMathematics_ave(mathematics_aver);
                            class_grades.setMathematics_max(mathematics_max);
                            class_grades.setMathematics_min(mathematics_min);

                            //英语各分值统计
                            Double english_max = utils.getMax(englishlist);
                            Double english_min = utils.getMin(englishlist);
                            Double english_aver = utils.getAver(englishlist);

                            class_grades.setEnglish_ave(english_aver);
                            class_grades.setEnglish_max(english_max);
                            class_grades.setEnglish_min(english_min);

                            //政治各分值统计
                            Double politics_max = utils.getMax(politicslist);
                            Double politics_min = utils.getMin(politicslist);
                            Double politics_aver = utils.getAver(politicslist);

                            class_grades.setPolitics_ave(politics_aver);
                            class_grades.setPolitics_max(politics_max);
                            class_grades.setPolitics_min(politics_min);


                            //历史各分值统计
                            Double history_max = utils.getMax(historylist);
                            Double history_min = utils.getMin(historylist);
                            Double history_aver = utils.getAver(historylist);

                            class_grades.setHistory_max(history_max);
                            class_grades.setHistory_min(history_min);
                            class_grades.setHistory_ave(history_aver);

                            //地理各分值统计
                            Double geography_max = utils.getMax(geographylist);
                            Double geography_min = utils.getMin(geographylist);
                            Double geography_aver = utils.getAver(geographylist);

                            class_grades.setGeography_ave(geography_aver);
                            class_grades.setGeography_max(geography_max);
                            class_grades.setGeography_min(geography_min);


                            //生物各分值统计
                            Double biology_max = utils.getMax(biologylist);
                            Double biology_min = utils.getMin(biologylist);
                            Double biology_aver = utils.getAver(biologylist);

                            class_grades.setBiology_ave(biology_aver);
                            class_grades.setBiology_max(biology_max);
                            class_grades.setBiology_min(biology_min);



                            //化学各分值统计
                            Double chemistry_max = utils.getMax(chemistrylist);
                            Double chemistry_min = utils.getMin(chemistrylist);
                            Double chemistry_aver = utils.getAver(chemistrylist);

                            class_grades.setChemistry_ave(chemistry_aver);
                            class_grades.setChinese_min(chemistry_min);
                            class_grades.setChemistry_max(chemistry_max);


                            //物理各分值统计
                            Double physics_max = utils.getMax(physicslist);
                            Double physics_min = utils.getMin(physicslist);
                            Double physics_aver = utils.getAver(physicslist);

                            class_grades.setPhysics_ave(physics_aver);
                            class_grades.setPhysics_max(physics_max);
                            class_grades.setPhysics_min(physics_min);

                            //音乐各分值统计
                            Double music_max = utils.getMax(musiclist);
                            Double music_min = utils.getMin(musiclist);
                            Double music_aver = utils.getAver(musiclist);

                            class_grades.setMusic_ave(music_aver);
                            class_grades.setMusic_max(music_max);
                            class_grades.setMusic_min(music_min);


                            //美术各分值统计
                            Double arts_max = utils.getMax(artslist);
                            Double arts_min = utils.getMin(artslist);
                            Double arts_aver = utils.getAver(artslist);

                            class_grades.setArts_max(arts_max);
                            class_grades.setArts_ave(arts_aver);
                            class_grades.setArts_min(arts_min);

                            //体育各分值统计
                            Double sports_max = utils.getMax(sportslist);
                            Double sports_min = utils.getMin(sportslist);
                            Double sports_aver = utils.getAver(sportslist);

                            class_grades.setSports_min(sports_min);
                            class_grades.setSports_ave(sports_aver);
                            class_grades.setSports_max(sports_max);

                            System.out.println("该班级成绩分数："+class_grades);

                            gradesService.addClass_Grades(class_grades);

                 }




        return null;

    }


    @ResponseBody
    @RequestMapping("classgrades")
    public HashMap<String,Object> classgrades(int page,int limit){
        HashMap<String,Object> resultMap = new HashMap<>();



        int count = gradesService.getAllClassGrades().size();
        PageHelper.startPage(page,limit);
        List<Class_Grades> class_gradeslist1 = gradesService.getAllClassGrades();

        PageInfo<Class_Grades> class_GradesPageInfo = new PageInfo<>(class_gradeslist1);

        List<Class_Grades> class_gradeslist2 = class_GradesPageInfo.getList();

        List<Object> customList = new ArrayList<>();

        for (Class_Grades cgrades:
                class_gradeslist2 ) {
            String class_grades_card_id = cgrades.getClass_grades_card_id();
            Class_Grades_Card card = gradesService.getClass_Grades_CardByID(class_grades_card_id);
            CustomClassGrades custom = new CustomClassGrades();
            custom.setClass_id(card.getClass_id());
            custom.setTest_describe(card.getTest_describe());
            custom.setTest_time(card.getTest_time());
            custom.setTotal_ave(cgrades.getTotal_ave());
            custom.setTotal_max(cgrades.getTotal_max());
            custom.setTotal_min(cgrades.getTotal_min());
            custom.setChinese_max(cgrades.getChinese_max());
            custom.setChinese_min(cgrades.getChinese_min());
            custom.setChinese_ave(cgrades.getChinese_ave());
            custom.setMathematics_max(cgrades.getMathematics_max());
            custom.setMathematics_min(cgrades.getMathematics_min());
            custom.setMathematics_ave(cgrades.getMathematics_ave());
            custom.setEnglish_max(cgrades.getEnglish_max());
            custom.setEnglish_min(cgrades.getEnglish_min());
            custom.setEnglish_ave(cgrades.getEnglish_ave());
            custom.setPolitics_max(cgrades.getPolitics_max());
            custom.setPolitics_min(cgrades.getPolitics_min());
            custom.setPolitics_ave(cgrades.getPolitics_ave());
            custom.setHistory_max(cgrades.getHistory_max());
            custom.setHistory_min(cgrades.getHistory_min());
            custom.setHistory_ave(cgrades.getHistory_ave());
            custom.setGeography_max(cgrades.getGeography_max());
            custom.setGeography_min(cgrades.getGeography_min());
            custom.setGeography_ave(cgrades.getGeography_ave());
            custom.setBiology_ave(cgrades.getBiology_ave());
            custom.setBiology_max(cgrades.getBiology_max());
            custom.setBiology_min(cgrades.getBiology_min());
            custom.setChemistry_ave(cgrades.getChemistry_ave());
            custom.setChemistry_max(cgrades.getChemistry_max());
            custom.setChemistry_min(cgrades.getChemistry_min());
            custom.setPhysics_max(cgrades.getPhysics_max());
            custom.setPhysics_min(cgrades.getPhysics_min());
            custom.setPhysics_ave(cgrades.getPhysics_ave());
            custom.setMusic_ave(cgrades.getMusic_ave());
            custom.setMusic_min(cgrades.getMusic_min());
            custom.setMusic_max(cgrades.getMusic_max());
            custom.setArts_max(cgrades.getArts_max());
            custom.setArts_min(cgrades.getArts_min());
            custom.setArts_ave(cgrades.getArts_ave());
            custom.setSports_max(cgrades.getSports_max());
            custom.setSports_min(cgrades.getSports_min());
            custom.setSports_ave(cgrades.getSports_ave());






            customList.add(custom);

        }



        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);


        resultMap.put("data",customList);
        return resultMap;





    }










}
