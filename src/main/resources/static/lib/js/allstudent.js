//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});

$(function () {

    //查看学生信息

    studentdetail = function(data){
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.open({

                title: ['学生信息'],
                type: 2,
                content: 'page/student/studentdetail.html',
                shadeClose: true,
                area: ['1000px', '700px'],
                success: function (layero,index) {
                    console.log(data);
                    var body = layui.layer.getChildFrame('body', index);
                    body.find(".stu_id").text(data.stu_id);
                    body.find(".stu_name").text(data.stu_name);
                    body.find(".stu_password").text(data.stu_password);
                    body.find(".stu_email").text(data.stu_email);
                    body.find(".stu_id_card").text(data.stu_id_card);
                    body.find(".stu_sex").text(data.stu_sex);
                    body.find(".stu_birthday").text(data.stu_birthday);
                    body.find(".nation_name").text(data.nation_name);
                    body.find(".stu_status").text(data.stu_status);
                    body.find(".stu_age").text(data.stu_age);
                    body.find(".class_id").text(data.class_id);
                    body.find(".stu_enrollment_time").text(data.stu_enrollment_time);
                    body.find(".stu_political").text(data.stu_political);
                    body.find(".stu_address").text(data.stu_address);
                    body.find(".stu_image").text(data.stu_image);



                    layui.form.render();
                },
                cancel:function () {

                },
                end:function () {



                }
            });

        });
    }



});
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
    var laydate = layui.laydate //日期
        ,laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,table = layui.table //表格
        ,carousel = layui.carousel //轮播
        ,upload = layui.upload //上传
        ,element = layui.element //元素操作
        ,slider = layui.slider //滑块





    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 800
        ,limit:'20'
        ,url: 'student/all' //数据接口
        ,title: '用户表'
        ,page: true //开启分页
        ,title:'学生信息表'
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'stu_id', title: '学号', width:'10%', sort: true}
            ,{field: 'stu_name', title: '姓名', width:'8%'}
            ,{field: 'stu_image', title: '头像', sort: false,
                templet:function (d) { return '<div><img style="height: 30px;width: 30px" src='+d.stu_image+'></div>' }

            }
            ,{field: 'stu_sex', title: '性别', width:'5%', sort: true}
            ,{field: 'stu_id_card', title: '身份证号码', width:'15%', sort: true}
            ,{field: 'stu_birthday', title: '出生日期', width:'10%', sort: true}
            ,{field: 'stu_age', title: '年龄', width:'8%', sort: true}
            ,{field: 'class_id', title: '班级', width:'8%', sort: true}

            ,{field: 'nation_name', title: '民族', width:'8%'}
            ,{field: 'stu_status', title: '状态', width:'8%'}

            ,{field: 'stu_enrollment_time', title: '入学时间', width:'8%', sort: true}
            ,{field: 'stu_political', title: '政治面貌', width:'8%'}
            ,{field: 'stu_address', title: '住址', width: '8%'}

            ,{fixed: 'right', width: '16%', align:'center', toolbar: '#barDemo'}


        ] ]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                var url = 'toaddstudent'
                $(window).attr('location',url);
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    var userdata =  data[0];
                    var stu_id = userdata.stu_id;
                    var url = 'student/toeditstudent/'+stu_id
                    $(window).attr('location',url);

                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.confirm("是否确认删除？",function () {
                        for(var i=0;i<data.length;i++){
                            var stu_id = data[i].stu_id;

                            $.ajax({
                                type:"post",
                                url:'student/delete/'+stu_id

                            });
                            // window.location.reload();
                        }
                    });


                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            studentdetail(data);

        } else if(layEvent === 'del'){
            layer.confirm('是否确认删除？', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                var stu_id = obj.data.stu_id;

                $.ajax({
                    type:"post",
                    url:'student/delete/'+stu_id

                });

                // window.location.reload();

            });
        } else if(layEvent === 'edit'){
            var stu_id = data.stu_id;
            var url = 'student/toeditstudent/'+stu_id
            $(window).attr('location',url);



        }
    });

//
});