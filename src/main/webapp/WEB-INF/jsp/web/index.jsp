<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<!-- saved from url=(0086)https://ccsxxwd.tangeche.com/home?shopId=01280205&salerphone=13331585767#1548755159532 -->
<html style="font-size: 50px;">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="易贷车主、新车报价、购车贷款、零首付">
    <meta name="viewport"
          content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,minimal-ui,viewport-fit=cover">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta content="telephone=no" name="format-detection">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>易贷车主</title>
    <link href="${ctx}/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/css/index.css">
</head>
<body class="index-page">
<div id="app">
    <div class="home-page">
        <div class="shop-sign-container bg">
            <div class="shop-info-container">
                <div class="shop-image">
                    <img src="${ctx}/images/logo.png">
                </div>
                <div class="shop-info">
                    <div class="title">
                        <div class="title-text">${shop.name}</div>
                    </div>
                    <div class="address">${shop.address}</div>
                    <img src="${ctx}/images/shouquan.png" class="shop-badge">
                </div>
            </div>
        </div>
        <div class="saler-module-container">
            <div class="saler-info-box">
                <div class="saler-avatar">
                    <div class="saler-photo-box">
                        <img src="${ctx}/images/yanfu.jpg" alt="" class="saler-photo">
                    </div>
                    <img src="${ctx}/images/jinpaiguwen.png" alt="" class="saler-tag">
                </div>
                <div class="saler-info">
                    <div class="saler-name">${shop.linkman}</div>
                    <div class="saler-phone">欢迎咨询 ${shop.mobile}</div>
                </div>
            </div>
            <div class="phone-icon"><img src="${ctx}/images/phone_grey.png" alt=""></div>
        </div>
        <div class="delivery-moment">
            <div tabindex="-1" role="dialog" aria-hidden="true" class="pswp">
                <div class="pswp__bg"></div>
                <div class="som-image-viewer">
                    <div class="som-image-viewer__title"><span><img src="${ctx}/images/cancel.png"></span><span>01/ 00</span>
                    </div>
                </div>
                <div class="pswp__scroll-wrap">
                    <div class="pswp__container">
                        <div class="pswp__item"></div>
                        <div class="pswp__item"></div>
                        <div class="pswp__item"></div>
                    </div>
                    <div class="pswp__ui pswp__ui--hidden">
                        <div class="pswp__top-bar">
                            <div class="pswp__preloader">
                                <div class="pswp__preloader__icn">
                                    <div class="pswp__preloader__cut">
                                        <div class="pswp__preloader__donut"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="recommend-car-list">
            <div class="recommend-title">
                <i class="point"></i>
                <em class="line"></em>
                <div class="title">
                    <img src="${ctx}/images/like.png">您可能喜欢
                </div>
                <em class="line"></em>
                <i class="point"></i>
            </div>
            <div class="common-car-list car-list">
                <c:forEach var="c" items="${cars}">
                    <div class="common-car-item common-car-item">
                        <div data-v-46bfca60="" class="image-wrapper">
                            <img data-v-46bfca60="" src="${ctx}/${c.imgpath}" width="100%" height="100%" class="oss-image car-image">
                            <img data-v-46bfca60="" src="${ctx}/images/shangxin.png" class="stock-icon">
                        </div>
                        <div data-v-46bfca60="" class="text-infos">
                            <p data-v-46bfca60="" class="model-name">${c.title}</p>
                            <p data-v-46bfca60="" class="car-status">厂商指导价${c.guiprice}万</p>
                            <p data-v-46bfca60="" class="price-info">
                                <span data-v-46bfca60="" class="down-payment">首付<span data-v-46bfca60="" class="down-payment-price">${c.downpay}</span>万</span>
                                <span data-v-46bfca60="" class="monthly-payments">月供${c.monpay}元</span>
                            </p>
                        </div>
                    </div>
                    <div class="splite-line"></div>
                </c:forEach>

            </div>
            <div class="splite-line"></div>
            <div class="view-all"><a href="${ctx}/web/list"><span>查看更多</span></a>
                <img src="${ctx}/images/to_right2.png" alt="">
            </div>
        </div>
        <div class="footer-info">
            <p class="shop-name">${main.name}</p>
            <p class="shop-address">${main.address}</p>
            <p class="shop-phone">${main.mobile}</p>
        </div>
        <div class="floating-level">
            <div class="bottom-actions">
                <img  src="${ctx}/images/to_top.svg" class="to-top-tag">
            </div>
        </div>
    </div>
    <div class="bottom-fence bottom-fence">
        <div  class="bottom-fence-container">
            <div  class="bottom-item active" style="width: 33.33%;">
                <div  class="icon-box">
                    <svg  viewBox="0 0 44 39">
                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"
                           transform="translate(-10.000000, -21.000000)">
                            <path fill="#FFC400"
                                  d="M36,56 L36,54 C36,51.790861 34.209139,50 32,50 C29.790861,50 28,51.790861 28,54 L28,56 C28,57.1045695 27.1045695,58 26,58 L15,58 C13.8954305,58 13,57.1045695 13,56 L13,36.9434589 C13,34.2712105 14.3342513,31.7754123 16.5563475,30.2910944 L29.745157,21.4812215 C31.0879426,20.5842663 32.8383526,20.5826768 34.182765,21.4771918 L47.4315635,30.2923804 C49.6606374,31.7755116 51,34.2754082 51,36.9528042 L51,56 C51,57.1045695 50.1045695,58 49,58 L38,58 C36.8954305,58 36,57.1045695 36,56 Z"></path>
                        </g>
                    </svg>
                </div>
                <span >首页</span>
            </div>
            <div  class="bottom-item" style="width: 33.33%;">
                <div  class="icon-box">
                    <svg  viewBox="0 0 44 39">
                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"
                           transform="translate(-10.000000, -21.000000)">
                            <path fill="#C4C4CC"
                                  d="M10,55 L10,41 C10,38.3875623 11.6696153,36.1650842 14,35.3414114 L14,35 C14,27.2680135 20.2680135,21 28,21 L36,21 C43.7319865,21 50,27.2680135 50,35 L50,35.3414114 C52.3303847,36.1650842 54,38.3875623 54,41 L54,55 L54,56 C54,58.209139 52.209139,60 50,60 C47.790861,60 46,58.209139 46,56 L46,55 L18,55 L18,56 C18,58.209139 16.209139,60 14,60 C11.790861,60 10,58.209139 10,56 L10,55 Z M46,35 C46,29.4771525 41.5228475,25 36,25 L28,25 C22.4771525,25 18,29.4771525 18,35 L46,35 Z M19,42 C17.3431458,42 16,43.3431458 16,45 C16,46.6568542 17.3431458,48 19,48 L21,48 C22.6568542,48 24,46.6568542 24,45 C24,43.3431458 22.6568542,42 21,42 L19,42 Z M43,42 C41.3431458,42 40,43.3431458 40,45 C40,46.6568542 41.3431458,48 43,48 L45,48 C46.6568542,48 48,46.6568542 48,45 C48,43.3431458 46.6568542,42 45,42 L43,42 Z"></path>
                        </g>
                    </svg>
                </div>
                <span >新车</span>
            </div>
            <div  class="bottom-item" style="width: 33.33%;">
                <div  class="icon-box">
                    <svg  viewBox="0 0 44 39">
                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"
                           transform="translate(-10.000000, -21.000000)">
                            <path fill="#C4C4CC"
                                  d="M44,43 L54,43 L54,53 C54,56.8659932 50.8659932,60 47,60 L44,60 L21,60 C17.1340068,60 14,56.8659932 14,53 L14,24 C14,21.790861 15.790861,20 18,20 L40,20 C42.209139,20 44,21.790861 44,24 L44,43 Z M44,47 L44,53 C44,54.6568542 45.3431458,56 47,56 C48.6568542,56 50,54.6568542 50,53 L50,47 L44,47 Z M23,30 L23,34 L35,34 L35,30 L23,30 Z M23,38 L23,42 L35,42 L35,38 L23,38 Z"></path>
                        </g>
                    </svg>
                </div>
                <span >我的</span>
            </div>
        </div>
    </div>
</div>
<script>
    /*回到顶部*/
    document.querySelector('.to-top-tag').onclick = function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    };
</script>
</body>
</html>