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
                            <i class="fa fa-th-list" style="margin-right: 5px"></i>汽车管理
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
                    <h4 class="modal-title"> 汽车管理</h4>
                </div>
                <div class="modal-body" >
                    <input type="hidden" id="allid">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 汽车名称：</label>
                            <div class="col-sm-7">
                                <input id="title" maxlength="80" type="text"  class="form-control"  placeholder="汽车名称" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 汽车品牌：</label>
                            <div class="col-sm-7">
                                <select id="companyid">
                                    <option value="">请选择品牌</option>
                                    <c:forEach var="c" items="${cs}">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 汽车颜色：</label>
                            <div class="col-sm-7">
                                <input id="color" maxlength="80" type="text"  class="form-control"  placeholder="汽车颜色" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 指导价格：</label>
                            <div class="col-sm-7">
                                <input id="guiprice" maxlength="10" type="text"  class="form-control"  placeholder="指导价格（万元）" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 销售价格：</label>
                            <div class="col-sm-7">
                                <input id="price" maxlength="10" type="text"  class="form-control"  placeholder="销售价格（万元）" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 首付金额：</label>
                            <div class="col-sm-7">
                                <input id="downpay" maxlength="10" type="text"  class="form-control"  placeholder="首付金额（万元）" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 月供金额：</label>
                            <div class="col-sm-7">
                                <input id="monpay" maxlength="10" type="text"  class="form-control"  placeholder="月供金额（元）" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-3"><font color="red" >*</font> 首页显示：</label>
                            <div class="col-sm-7">
                                <select id="issy">
                                    <option value="">请选择</option>
                                    <option value="0">是</option>
                                    <option value="1">否</option>
                                </select>
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
                url: "${ctx}/car/queryList",
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
                        field: 'title',
                        title: '汽车名称'
                    },{
                        field: 'companyname',
                        title: '品牌'
                    },{
                        field: 'color',
                        title: '车辆颜色'
                    },{
                        field: 'guiprice',
                        title: '指导价（万元）'
                    }
                    ,{
                        field: 'price',
                        title: '销售价（万元）'
                    },{
                        field: 'downpay',
                        title: '首付（万元）'
                    },{
                        field: 'monpay',
                        title: '月供（元）'
                    },{
                        field: 'issy',
                        title: '首页显示',
                        formatter: function(value,row,index){
                            if(value=='0'){
                                return "是";
                            }else {
                                return "否";
                            }
                        }
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
                                    '<li style="float: none;"><button type="button" class="btn btn-link" onclick="update(\''+ row.id + '\',\''+ row.title + '\',\''+ row.companyid + '\',\''+ row.color + '\',\''+ row.guiprice + '\',\''+ row.price + '\',\''+ row.downpay + '\',\''+ row.monpay + '\',\''+ row.issy + '\')">修改</button></li>'+
                                    '<li style="float: none;"><button type="button" class="btn btn-link" onclick="img(\''+ row.id + '\')">图片管理</button></li>'+
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
        $('#title').val("");
        $('#color').val("");
        $('#companyid').val("");
        $("#guiprice").val("");
        $("#price").val("");
        $("#downpay").val("");
        $("#monpay").val("");
        $("#issy").val("");
        $("#qlfoot1").css("display","block");
        $("#qlfoot2").css("display","none");
        $('#model').modal();
    }

    //添加角色
    function add(){
        var title=$("#title").val();
        var color=$("#color").val();
        var companyid=$("#companyid").val();
        var guiprice=$("#guiprice").val();
        var price=$("#price").val();
        var downpay=$("#downpay").val();
        var monpay=$("#monpay").val();
        var issy=$("#issy").val();


        if($.isEmptyObject(title)||title.trim()==""){
            Showbo.Msg.alert("请填写汽车名称！");
            $("#title").focus();
            return false;
        }else if($.isEmptyObject(companyid)||companyid.trim()==""){
            Showbo.Msg.alert("请选择汽车品牌！");
            $("#title").focus();
            return false;
        }else if(color.length==0||$.trim(color)==""){
            Showbo.Msg.alert("请填写车辆颜色！");
            $("#color").focus();
            return false;
        }else if(guiprice.length==0||$.trim(guiprice)==""){
            Showbo.Msg.alert("请填写指导价格！");
            $("#guiprice").focus();
            return false;
        }else if(price.length==0||$.trim(price)==""){
            Showbo.Msg.alert("请填写销售价格！");
            $("#price").focus();
            return false;
        }else if(downpay.length==0||$.trim(downpay)==""){
            Showbo.Msg.alert("请填写首付金额！");
            $("#downpay").focus();
            return false;
        }else if(monpay.length==0||$.trim(monpay)==""){
            Showbo.Msg.alert("请填写月供金额！");
            $("#monpay").focus();
            return false;
        }else if($.trim(issy)==""){
            Showbo.Msg.alert("请选择是否首页显示！");

            return false;
        }

        $.post("${ctx}/car/addCar",{title:title,companyid:companyid,color:color,guiprice:guiprice,price:price,downpay:downpay,monpay:monpay,issy:issy},function (d) {
            if(d=="ajaxfail"){
                Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                    if(btn=="yes"){
                        window.location.href="${ctx}/sys/index";
                    }
                });
            }else {
                if(d=="ok"){
                    Showbo.Msg.alert('添加车辆成功');
                    $('#teacher_table').bootstrapTable('refresh');
                    $('#model').modal('hide');

                }else {
                    Showbo.Msg.alert('添加车辆失败');
                }
            }
        });
        $('#model').modal('hide');
    };

    //修改角色
    function update(id,title,companyid,color,guiprice,price,downpay,monpay,issy) {

        $('#allid').val(id);
        $("#title").val(title);
        $("#companyid").val(companyid);
        $("#color").val(color);
        $("#guiprice").val(guiprice);
        $("#price").val(price);
        $("#downpay").val(downpay);
        $("#monpay").val(monpay);
        $("#issy").val(issy);


        $("#qlfoot2").css("display","block");
        $("#qlfoot1").css("display","none");
        $('#model').modal();
    }
    function updateEmp() {
        var id = $('#allid').val();
        //id既是role_id又是t_role里的id
        var title=$("#title").val();
        var companyid=$("#companyid").val();
        var color=$("#color").val();
        var guiprice=$("#guiprice").val();
        var price=$("#price").val();
        var downpay=$("#downpay").val();
        var monpay=$("#monpay").val();
        var issy=$("#issy").val();


        if($.isEmptyObject(title)||title.trim()==""){
            Showbo.Msg.alert("请填写汽车名称！");
            $("#title").focus();
            return false;
        }else if($.isEmptyObject(companyid)||companyid.trim()==""){
            Showbo.Msg.alert("请填写汽车品牌！");
            $("#title").focus();
            return false;
        }else if(color.length==0||$.trim(color)==""){
            Showbo.Msg.alert("请填写车辆颜色！");
            $("#color").focus();
            return false;
        }else if(guiprice.length==0||$.trim(guiprice)==""){
            Showbo.Msg.alert("请填写指导价格！");
            $("#guiprice").focus();
            return false;
        }else if(price.length==0||$.trim(price)==""){
            Showbo.Msg.alert("请填写销售价格！");
            $("#price").focus();
            return false;
        }else if(downpay.length==0||$.trim(downpay)==""){
            Showbo.Msg.alert("请填写首付金额！");
            $("#downpay").focus();
            return false;
        }else if(monpay.length==0||$.trim(monpay)==""){
            Showbo.Msg.alert("请填写月供金额！");
            $("#monpay").focus();
            return false;
        }else if($.trim(issy)==""){
            Showbo.Msg.alert("请选择是否首页显示！");

            return false;
        }

        $.post("${ctx}/car/updateCar",{id:id,title:title,companyid:companyid,color:color,guiprice:guiprice,price:price,downpay:downpay,monpay:monpay,issy:issy},function (d) {
            if(d=="ajaxfail"){
                Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                    if(btn=="yes"){
                        window.location.href="${ctx}/sys/index";
                    }
                });
            }else {
                if(d=="ok"){
                    Showbo.Msg.alert('修改车辆成功');
                    $('#teacher_table').bootstrapTable('refresh');
                    $('#model').modal('hide');
                }else {
                    Showbo.Msg.alert('修改车辆失败');
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


    function img(id) {
        window.location.href="${ctx}/car/imgindex?carid="+id;
    }



</script>


</html>