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



    var stu_id = $("#stu_id").text();
    console.log("id："+stu_id);

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 800
        ,limit:'20'
        ,url: 'grades/sudent/'+stu_id //数据接口
        ,title: '用户表'
        ,page: true //开启分页
        ,title:'学生信息表'
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {type: 'checkbox', fixed: 'left'}
            // ,{field: 'stu_id', title: '学号', width:'10%', sort: true}
            // ,{field: 'stu_name', title: '姓名', width:'8%'}
            // ,{field: 'class_id', title: '班级', width:'8%', sort: true}
            ,{field: 'test_time', title: '考试时间', width:'8%', sort: true}
            ,{field: 'test_describe', title: '描述', width:'8%', sort: true}

            ,{field: 'total', title: '总分', width:'8%', sort: true}
            ,{field: 'average', title: '平均分', width:'8%', sort: true}
            ,{field: 'maxscore', title: '最高分', width:'8%', sort: true}
            ,{field: 'minscore', title: '最低分', width:'8%', sort: true}

            ,{field: 'chinese', title: '语文', width:'8%', sort: true}
            ,{field: 'mathematics', title: '数学', width:'8%', sort: true}

            ,{field: 'english', title: '英语', width:'8%', sort: true}
            ,{field: 'politics', title: '政治', width:'8%', sort: true}
            ,{field: 'history', title: '历史', width: '8%', sort: true}
            ,{field: 'geography', title: '地理', width:'8%', sort: true}
            ,{field: 'biology', title: '生物', width:'8%', sort: true}

            ,{field: 'chemistry', title: '化学', width:'8%', sort: true}
            ,{field: 'music', title: '音乐', width:'8%', sort: true}
            ,{field: 'arts', title: '美术', width: '8%', sort: true}
            ,{field: 'sports', title: '体育', width:'8%', sort: true}


            // ,{fixed: 'right', width: '16%', align:'center', toolbar: '#barDemo'}


        ] ]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                var url = 'student/toadd'
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
                            window.location.reload();
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

                window.location.reload();

            });
        } else if(layEvent === 'edit'){
            var stu_id = data.stu_id;
            var url = 'student/toeditstudent/'+stu_id
            $(window).attr('location',url);



        }
    });

//
});