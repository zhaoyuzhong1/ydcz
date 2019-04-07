<%--<%@ taglib prefix="jodd-lagarto" uri="/jodd-lagarto" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../sys/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<style>


</style>
<body class="sticky-header">

<!-- left side start-->
<%@include file="../ywsys/ywmenu.jsp"%>
<!-- left side end-->

<!-- main content start-->
<div class="main-content" >
    <!-- header section start-->
    <%@include file="../ywsys/ywtop.jsp"%>
    <!-- header section end-->
    <%--------------------------------------------------------内容--%>
    <!-- page heading start-->
    <div class="wrapper">
        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <div class="page-heading">
                        <h3 class="panel-title">
                            <i class="fa fa-th-list" style="margin-right: 5px"></i>汽车品牌管理
                        </h3>
                    </div>
                    <div class="panel-body" >
                        <div class="form-inline pull-right" style="margin-bottom:15px;">
                            <div class="form-group form-group-sm">
                                <input id="search_name" name="search_name" type="text" class="form-control"  placeholder="请输入关键字">
                            </div>&nbsp;
                            <button class="btn btn-main btn-sm" type="button" onclick="gosearch()"><i class="fa fa-search"></i> 查询</button>
                            <button class="btn btn-warning-o btn-sm" type="button" onclick="goreset()"><i class="fa fa-repeat"></i> 重置</button>
                            <button class="btn btn-success-o btn-sm" type="button" onclick="addShop()"><i class="fa fa-plus"></i> 添加</button>
                        </div>
                        <table id="teacher_table"
                               data-page-size="5">
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </div>
    <!--body wrapper end-->
    <%-----------------------------------------------------模态框--%>
    <%-----------------------------------------------------模态框--%>
    <div class="modal fade" id="model">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header1">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title"> 汽车品牌管理</h4>
                </div>
                <div class="modal-body" >
                    <input type="hidden" id="allid">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 品牌名称：</label>
                            <div class="col-sm-7">
                                <input id="name" maxlength="50" type="text"  class="form-control"  placeholder="品牌名称" >
                            </div>
                        </div>


                    </div>
                </div>
                <div class="modal-footer" id="qlfoot1">
                    <button type="button"  class="btn btn-thollow" data-dismiss="modal"><i class="fa fa-times"></i> 取消</button>
                    <button type="button" class="btn btn-tsolid" onclick="add();" ><i class="fa fa-check" ></i> 确定</button>
                </div>
                <div class="modal-footer" id="qlfoot2" style="display: none">
                    <button type="button"  class="btn btn-thollow" data-dismiss="modal"><i class="fa fa-times"></i> 取消</button>
                    <button type="button" class="btn btn-tsolid" onclick="updateEmp();" ><i class="fa fa-check" ></i> 修改</button>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->





</body>
<%--多选下拉框css--%>
<%--<link rel="stylesheet" href="${ctx}/css/bootstrap.css" />--%>
<link rel="stylesheet" href="${ctx}/css/multiple-select.css" />
<%-----多选下拉框js--%>
<script src="${ctx}/js/multiple-select.js"></script>
<script>
    $(this).keydown( function(e) {
        var key = window.event?e.keyCode:e.which;
        if(key.toString() == "13"){
            return false;
        }
    });

    $('#ms').change(function() {
        console.log($(this).val());
    }).multipleSelect({
        width: '67%'
    });

    $(function () {

        var dtb1 = new DataTable1();
        dtb1.Init();
    });

    var DataTable1 = function (){
        var oTableInit = new Object();
        oTableInit.Init = function (){
            $('#teacher_table').bootstrapTable('destroy').bootstrapTable({
                url: "${ctx}/company/queryList",
                method: 'get',
                striped: true,
                cache: false,
                pagination: true,
                sortable: false,
                queryParamsType: "limit",
                queryParams: oTableInit.queryParams,
                pageNumber:1,
                pageSize: 10,
                pageList:[10,20, 30],
                strictSearch: true,
                clickToSelect: true,
                cardView: false,
                paginationFirstText:"<<",
                paginationPreText:"<",
                paginationNextText:">",
                paginationLastText:">>",
                showExport: true,//显示导出按钮
                exportDataType: "basic",//导出类型
                sidePagination: "server",

                columns: [
                    {
                        title: '序号',
                        formatter: function(value,row,index){

                            return Number(row.count+index)+1;
                        }
                    },{
                        field: 'name',
                        title: '品牌名称'
                    },
                    {
                        field: 'cdate',
                        title: '创建时间',
                        formatter: function(value,row,index){
                            return getTime(value)
                        }
                    },
                    {
                        title: '操作',
                        width:'100px',
                        formatter: function(value,row,index){
                            var button ='<div class="btn-group btn-group-xs">'+
                                    '<button type="button" class="btn btn-default btn-maincolor" ><i class="fa fa-eye"></i>&nbsp;操&nbsp;作</button>';
                            var e =  '<button type="button" class="btn btn-default btn-maincolor dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> '+
                                    '<span class="caret"></span>'+
                                    '</button>';

                            var aa =  '<ul class="dropdown-menu dropdown-menu-right">'+
                                    '<li style="float: none;"><button type="button" class="btn btn-link" onclick="update(\''+ row.id + '\',\''+ row.name + '\')">修改</button></li>'+
                                    '</ul>';

                            return button +e + aa+  '</div>';



                        },
                    }
                ]
            });
        };



        //得到查询的参数
        oTableInit.queryParams = function (params) {
            return {

                count: params.limit,  //页面大小
                pagesize:params.offset, //页码
                search_name:$('#search_name').val(),
            };
        };
        return oTableInit;
    }
    function gosearch() {
        $('#teacher_table').bootstrapTable('refreshOptions',{pageNumber:1,pagesize:7});
    }
    //打开模态框
    function addShop(){
        $('#allid').val("");
        $('#name').val("");
        $("#qlfoot1").css("display","block");
        $("#qlfoot2").css("display","none");
        $('#model').modal();
    }

    //添加角色
    function add(){
        var name=$("#name").val();


        if($.isEmptyObject(name)||name.trim()==""){
            Showbo.Msg.alert("品牌名称不能为空！");
            return false;
        }

        $.post("${ctx}/company/add",{name:name},function (d) {
            if(d=="ajaxfail"){
                Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                    if(btn=="yes"){
                        window.location.href="${ctx}/sys/index";
                    }
                });
            }else {
                if(d=="ok"){
                    Showbo.Msg.alert('添加汽车品牌成功');
                    $('#teacher_table').bootstrapTable('refresh');
                    $('#model').modal('hide');

                }else {
                    Showbo.Msg.alert('添加汽车品牌失败');
                }
            }
        });
        $('#model').modal('hide');
    };

    //修改角色
    function update(id,name) {

        $('#allid').val(id);
        $('#name').val(name);


        $("#qlfoot2").css("display","block");
        $("#qlfoot1").css("display","none");
        $('#model').modal();
    }
    function updateEmp() {
        var id = $('#allid').val();
        //id既是role_id又是t_role里的id
        var name=$("#name").val();

        if($.isEmptyObject(name)||name.trim()==""){
            Showbo.Msg.alert("汽车品牌名称不能为空！");
            return false;
        }

        $.post("${ctx}/shop/update",{id:id,name:name},function (d) {
            if(d=="ajaxfail"){
                Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                    if(btn=="yes"){
                        window.location.href="${ctx}/sys/index";
                    }
                });
            }else {
                if(d=="ok"){
                    Showbo.Msg.alert('修改汽车品牌成功');
                    $('#teacher_table').bootstrapTable('refresh');
                    $('#model').modal('hide');
                }else {
                    Showbo.Msg.alert('修改汽车品牌失败');
                }
            }

        });
    }


    function getTime(timestamp) {
        var ts = arguments[0] || 0;
        var t,y,m,d,h,i,s;
        t = ts ? new Date(parseInt(ts)) : new Date();
        y = t.getFullYear();
        m = t.getMonth()+1;
        d = t.getDate();
        h = t.getHours();
        i = t.getMinutes();
        s = t.getSeconds();
        // 可根据需要在这里定义时间格式
//        return y+'-'+(m<10?'0'+m:m)+'-'+(d<10?'0'+d:d)+' '+(h<10?'0'+h:h)+':'+(i<10?'0'+i:i)+':'+(s<10?'0'+s:s);
        return y+'-'+(m<10?'0'+m:m)+'-'+(d<10?'0'+d:d)+' '+(h<10?'0'+h:h)+':'+(i<10?'0'+i:i)+':'+(s<10?'0'+s:s);
    }



    function goreset() {
        $("#search_name").val("");
        gosearch();
    }

    //订单状态
    function getflag(flag) {
        if(flag=='0'){
            return "未审批";
        }else if(flag=='1'){
            return "已审批";
        }else if(flag=='2'){
            return "审批未通过";
        }
    }



</script>


</html>