<%--<%@ taglib prefix="jodd-lagarto" uri="/jodd-lagarto" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../sys/header.jsp"%>
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
                            <i class="fa fa-th-list" style="margin-right: 5px"></i>系统统计页
                        </h3>
                    </div>
                    <div class="panel-body" >
                        <div class="form-inline pull-right" style="margin-bottom:15px;">
                            <div class="form-group form-group-sm">
                                <select id="cityid">
                                    <option value="0">请选择城市</option>
                                    <c:forEach items="${cs}" var="c">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:forEach>
                                </select>
                            </div>&nbsp;
                            <button class="btn btn-main btn-sm" type="button" onclick="gosearch()"><i class="fa fa-search"></i> 查询</button>
                        </div>
                        <table id="teacher_table"
                               data-page-size="5">


                        </table>
                    </div>
                </section>
            </div>
        </div>
    </div>

    <script>
        function gosearch() {
            var cityid = $("#cityid").val();

            $.post("${ctx}/sys/getTj",{cityid:cityid},function (d) {
                if(d=="ajaxfail"){
                    Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                        if(btn=="yes"){
                            window.location.href="${ctx}/sys/index";
                        }
                    });
                }else {
                    $("#teacher_table").html(d);
                }
            });

        }
    </script>

</html>