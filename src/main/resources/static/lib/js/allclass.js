//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});

$(function () {

    //查看班级信息

    classdetail = function(data){
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.open({

                title: ['班级信息'],
                type: 2,
                content: 'page/class/classdetail.html',
                shadeClose: true,
                area: ['1000px', '700px'],
                success: function (layero,index) {
                    console.log(data);
                    var body = layui.layer.getChildFrame('body', index);
                    body.find(".class_id").text(data.class_id);
                    body.find(".class_name").text(data.class_name);
                    body.find(".class_teacher").text(data.class_teacher);
                    body.find(".class_count").text(data.class_count);
                    body.find(".chinese_teacher").text(data.chinese_teacher);
                    body.find(".mathematics_teacher").text(data.mathematics_teacher);
                    body.find(".english_teacher").text(data.english_teacher);
                    body.find(".politics_teacher").text(data.politics_teacher);
                    body.find(".history_teacher").text(data.history_teacher);
                    body.find(".geography_teacher").text(data.geography_teacher);
                    body.find(".biology_teacher").text(data.biology_teacher);
                    body.find(".chemistry_teacher").text(data.chemistry_teacher);
                    body.find(".physics_teacher").text(data.physics_teacher);
                    body.find(".music_teacher").text(data.music_teacher);
                    body.find(".arts_teacher").text(data.arts_teacher);
                    body.find(".sports_teacher").text(data.sports_teacher);



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
        ,url: 'class/all' //数据接口
        ,title: '班级表'
        ,limit:'20'
        ,page: true //开启分页
        ,title:'班级信息表'
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {type: 'checkbox', fixed: 'left'}

            ,{field: 'class_name', title: '班级名称', width:'8%', sort: true}

            ,{field: 'class_count', title: '学生人数', width:'8%', sort: true}
            ,{field: 'class_teacher', title: '班主任',width:'7%'}
            ,{field: 'chinese_teacher', title: '语文老师', width:'7%'}
            ,{field: 'mathematics_teacher', title: '数学老师', width:'7%'}
            ,{field: 'english_teacher', title: '英语老师', width:'7%'}
            ,{field: 'politics_teacher', title: '政治老师', width:'7%'}

            ,{field: 'history_teacher', title: '历史老师', width:'7%'}
            ,{field: 'geography_teacher', title: '地理老师', width:'7%'}

            ,{field: 'biology_teacher', title: '生物老师', width:'7%'}
            ,{field: 'chemistry_teacher', title: '化学老师', width:'7%'}
            ,{field: 'physics_teacher', title: '物理老师', width: '7%'}
            ,{field: 'music_teacher', title: '音乐老师', width: '7%'}
            ,{field: 'arts_teacher', title: '美术老师', width: '7%'}
            ,{field: 'sports_teacher', title: '体育老师', width: '7%'}

            ,{fixed: 'right', width: '12%', align:'center', toolbar: '#barDemo'}


        ] ]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                var url = 'class/toadd'
                $(window).attr('location',url);
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    var userdata =  data[0];
                    var class_id = userdata.class_id;
                    var url = 'class/toeditclass/'+class_id
                    $(window).attr('location',url);

                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.confirm("是否确认删除？",function () {
                        for(var i=0;i<data.length;i++){
                            var class_id = data[i].class_id;

                            $.ajax({
                                type:"post",
                                url:'class/delete/'+class_id

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
            classdetail(data);

        } else if(layEvent === 'del'){
            layer.confirm('是否确认删除？', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                var class_id = obj.data.class_id;

                $.ajax({
                    type:"post",
                    url:'class/delete/'+class_id

                });

                // window.location.reload();

            });
        } else if(layEvent === 'edit'){
            var class_id = data.class_id;
            var url = 'class/toeditclass/'+class_id
            $(window).attr('location',url);



        }
    });

//
});