<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../img/bpsqu.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>
                    <security:authentication property="principal.username"></security:authentication>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/pages/main.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->

            <%--用于控制页面上标签是否显示--%>
            <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_LEAYINGE')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-folder"></i> <span>系统操作</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">

                        <li id="admin-login">
                            <a href="/users/findAll.do?page=1&size=2">
                                <i class="fa fa-circle-o"></i> 用户管理
                            </a>
                        </li>

                        <li id="admin-register">
                            <a href="/role/findAll.do?page=1&size=2">
                                <i class="fa fa-circle-o"></i> 角色管理
                            </a>
                        </li>

                        <li id="admin-404">
                            <a href="/permission/findAll.do">
                                <i class="fa fa-circle-o"></i> 资源权限管理
                            </a>
                        </li>

                        <li id="admin-500">
                            <a href="/log/findAll.do">
                                <i class="fa fa-circle-o"></i> 访问日志
                            </a>
                        </li>
                    </ul>
                </li>
            </security:authorize>


            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="charts-chartjs">
                        <a href="/product/findAll.do?page=1&size=2">
                            <i class="fa fa-circle-o"></i> 商品管理
                        </a>
                    </li>

                    <li id="charts-morris">
                        <a href="/order/findAll.do?page=1&size=2">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>

                </ul>
            </li>


            <!-- 菜单 /-->

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
