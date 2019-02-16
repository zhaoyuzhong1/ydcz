<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="弹个车长春高新区世兴行光谷大街店、新车报价、 新车4S门店-长春世兴行光谷大街店、新车购车优惠、置换购车">
    <meta name="description"
          content="弹个车长春高新区世兴行光谷大街店,长春世兴行光谷大街店-可信赖的品牌4S店，门店地址：吉林省长春市高新区光谷大街268号富祥小区正门；联系电话：15543177272;新款车系车型报价">
    <meta name="viewport"
          content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,minimal-ui,viewport-fit=cover">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta content="telephone=no" name="format-detection">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>${car.title}</title>
    <link rel="stylesheet" href="${ctx}/css/swiper.min.css">
    <link href="${ctx}/css/app.css" rel="stylesheet">
    <link href="${ctx}/css/car_details.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <div class="car-detail">
        <div class="basic-info-section">
            <div class="swiper-container swiper-container-horizontal">
                <div class="swiper-wrapper">
                    <c:forEach items="${cis}" var="ci">
                        <div class="swiper-slide">
                            <img src="${ctx}${ci.imgpath}" class="slide-image">
                        </div>
                    </c:forEach>
                    <%--<div class="swiper-slide">--%>
                        <%--<img src="${ctx}/images/car17.jpg" class="slide-image">--%>
                    <%--</div>--%>
                </div>
                <div class="swiper-pagination swiper-pagination-fraction"><span
                        class="swiper-pagination-current">1</span> / <span class="swiper-pagination-total">2</span>
                </div>
            </div>


            <div class="pear-detail-bubble-clues bubble-clues" style="top: 16px;">
            </div>

            <div class="pear-detail-car-info">
                <div class="main">
                    <div class="car-name"><b>${car.title}</b> <span
                            class="feature-tags"></span></div>
                    <div class="car-attributes">
                        <div class="left-texts">
                            <div class="color">${car.color}</div>
                            <div class="guide-price">
                                <div class="price-text">厂商指导价: ${car.guiprice}万</div>
                                <img src="images/help.png" class="price-question"></div>
                        </div>
                        <div class="sold-number"><span>已售${car.sailnum}台</span></div>
                    </div>
                </div>
                <div class="pear-detail-service-charge"></div>
            </div>
            <div class="summary-rows"></div>
        </div>
        <!--car轮播-->
        <div class="finance-section pear-detail-finance-scheme">
            <div class="switch-tabs">
                <div class="switch-tab active"><span>标准方案</span></div>
                <div class="switch-tab">
                    <img src="${ctx}/images/kexuan.png" class="tab-icon">
                    <span>1年后可退车方案</span>
                </div>
            </div>
            <div class="scheme-card">
                <div class="title left-ico">
                    <div class="title-text">先用1年</div>
                    <div class="lease-tags">
                        <div class="lease-tag"><img
                                src="images/han.png" width="14"
                                height="14" class="word-icon"> <span class="tag-text">购置税</span></div>
                        <div class="lease-tag"><img
                                src="images/song.png" width="14"
                                height="14" class="word-icon"> <span class="tag-text">1年保险</span></div>
                    </div>
                </div>
                <div class="payment">
                    <div class="item">
                        <div class="t1">
                            首付&nbsp;</div>
                        <div class="t2 fs-20"><b>${car.downpay}万</b></div>
                    </div>
                    <div class="item">
                        <div class="t1">
                            月供&nbsp;</div>
                        <div class="t2 fs-20"><b>${car.monpay}元</b></div>
                    </div>
                    <div class="item">
                        <div class="t1">期数</div>
                        <div class="t2 fs-20"><b>12期</b></div>
                    </div>
                </div>
                <div class="tips tips1">
                    <div class="fee delivery-fee-tip">
                        <div>需向门店支付交车服务费4000元</div>
                        <img src="${ctx}/images/help.png" width="14">
                    </div>
                </div>
                <div class="title left-ico"><span class="title-text">1年后</span>
                </div>
                <div class="tips">
                    <div class="final-payment"><span>尾款购车&nbsp;175800元</span>
                        <span class="final-payment-type">(支持3年36期分期)</span></div>
                    <div class="last-pay">
                        <svg width="26px" height="26px" viewBox="0 0 26 26" version="1.1"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                             class="alert-icon">
                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                <g transform="translate(-32.000000, -547.000000)">
                                    <g transform="translate(32.000000, 547.000000)">
                                        <circle fill="#FF4D30" cx="13" cy="13" r="13"></circle>
                                        <circle fill="#FFFFFF"
                                                transform="translate(13.500000, 18.500000) scale(-1, 1) translate(-13.500000, -18.500000) "
                                                cx="13.5" cy="18.5" r="1.5"></circle>
                                        <rect fill="#FFFFFF"
                                              transform="translate(13.500000, 10.000000) scale(-1, 1) translate(-13.500000, -10.000000) "
                                              x="12" y="5" width="3" height="10" rx="1.5"></rect>
                                    </g>
                                </g>
                            </g>
                        </svg>
                        <span>该方案不支持续租或退还车辆</span></div>
                </div>
                <div class="detail-link">
                    <div class="link-button">查看方案详情</div>
                </div>
            </div>
            <div class="pear-detail-service-charge"></div>
        </div>
        <div class="detail-car-shop">
            <div class="detail-content">
                <div class="shop-info">
                    <div class="title">
                        <div class="name">${main.name}</div>
                        <div class="go-shop">
                            <div>进店</div>
                            <img src="${ctx}/images/jindian.png" class="right-arrow">
                        </div>
                    </div>
                    <div class="addr">${main.address}</div>
                    <div class="shop-tag">
                        <img src="${ctx}/images/shouquan.png">
                    </div>
                </div>
                <div class="person-info">
                    <div class="info-left">
                        <img src="${ctx}/images/yanfu.jpg" class="person-headimg">

                        <div class="person-intro">
                            <div class="person-intro-name">${shop.linkman}</div>
                            <div class="person-intro-no">${shop.mobile}</div>
                        </div>
                    </div>
                    <img src="${ctx}/images/phone.png" class="info-right"></div>
            </div>
        </div>
        <div class="configure-section">


            <div class="buy-car-knowledge anchor">
                <div class="pear-detail-wrapper">
                    <div class="top">
                        <div class="title"><span>为什么选弹个车</span></div>
                    </div>
                    <div class="pear-detail-why-choose"><p class="choose-title">由阿里巴巴和蚂蚁金服</p>

                        <p class="choose-title">联合战略投资</p>

                        <div class="vs-module">
                            <div class="left-vs"><p class="vs-top">弹个车</p>

                                <p class="vs-bottom">1成首付开创者</p></div>
                            <div class="right-vs"><p>其他贷款买车</p></div>
                            <div class="middle-vs">VS</div>
                        </div>
                        <section class="choose-list">
                            <div class="choose-item">
                                <div class="choose-left"><p class="p-weight">首付低</p>

                                    <p class="normal">首付只需10%</p>

                                    <p class="normal">包购置税</p>

                                    <p class="normal">送1年保险</p>

                                    <p class="normal">所有费用全部透明公示</p></div>
                                <div class="choose-right"><p class="p-weight">首付高</p>

                                    <p class="normal">首付至少30%</p>

                                    <p class="normal">自己缴纳购置税及保险</p>

                                    <p class="normal">还有验车整备费、装饰费等隐形杂费</p></div>
                                <div class="clear-div"></div>
                            </div>
                            <div class="choose-item">
                                <div class="choose-left"><p class="p-weight">月供低</p>

                                    <p class="normal">第1年月供低</p>

                                    <p class="normal">后3年还款灵活</p>

                                    <p class="normal">压力小</p></div>
                                <div class="choose-right"><p class="p-weight">月供高</p>

                                    <p class="normal">36期月供固定</p>

                                    <p class="normal">每月资金紧张</p>

                                    <p class="normal">压力大</p></div>
                                <div class="clear-div"></div>
                            </div>
                            <div class="choose-item">
                                <div class="choose-left"><p class="p-weight">手续简便</p>

                                    <p class="normal">支付宝扫码征信</p>

                                    <p class="normal">只需15分钟完成在线审批</p>

                                    <p class="normal">0保证金</p>

                                    <p class="normal"></p></div>
                                <div class="choose-right"><p class="p-weight">手续复杂还收费</p>

                                    <p class="normal">多种纸质证明，流程繁琐</p>

                                    <p class="normal">等待时间2周以上</p>

                                    <p class="normal">需手续费，审批苛刻</p></div>
                                <div class="clear-div"></div>
                            </div>
                            <div class="choose-item">
                                <div class="choose-left"><p class="p-weight">省时省力省钱</p>

                                    <p class="normal">专员代办所有购车手续</p>

                                    <p class="normal">客户坐等提车</p></div>
                                <div class="choose-right"><p class="p-weight">费事费力费钱</p>

                                    <p class="normal">自己准备材料</p>

                                    <p class="normal">提车,上牌,交税,保险</p></div>
                                <div class="clear-div"></div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
            <div class="pear-detail-wrapper">
                <div class="top">
                    <div class="title"><span>购买须知</span></div>
                </div>
                <div class="pear-detail-purchase-notes">
                    <div class="cell-list">
                        <div class="key">车辆归属</div>
                        <div class="value ">第一年用车期间，车辆及车牌所有权归属浙江大搜车融资租赁有限公司</div>
                    </div>
                    <div class="cell-list">
                        <div class="key">资料</div>
                        <div class="value ">您只需提供有效驾驶证</div>
                    </div>
                    <div class="cell-list">
                        <div class="key">购置税</div>
                        <div class="value ">弹个车方案已含购置税，您无需支付额外费用</div>
                    </div>
                    <div class="cell-list">
                        <div class="key">保险</div>
                        <div class="value">
                            弹个车送1年车险，含交强险、第三者责任险（30万）、车上人员责任险（司机）、车损险及以上几项险种的不计免陪险；提供盗抢险和涉水险理赔服务。如需增加其他保险险种，可联系顾问办理，增加险种费用由用户自己承担
                        </div>
                    </div>
                    <div class="cell-list">
                        <div class="key">上牌</div>
                        <div class="value">上牌手续由弹个车负责办理，客户无需支付任何费用
                            <span class="blue-btn">查看上牌城市</span></div>
                    </div>
                    <div class="cell-list">
                        <div class="key">还款</div>
                        <div class="value ">购车后每月还款可通过支付宝的账户余额、余额宝或绑定的银行卡内直接扣除还款金额</div>
                    </div>
                </div>
            </div>
            <div class="pear-detail-wrapper">
                <div class="top">
                    <div class="title"><span>只需4步爱车提回家</span></div>
                </div>
                <div class="pear-detail-pick-car">
                    <div class="cell-list"><img
                            src="${ctx}/images/yugou.png" alt="在线预约"
                            class="icon">

                        <div class="cell">
                            <div class="cell-title">在线预约</div>
                            <div class="cell-content">在线预约成功后，我们的销售顾问会在24小时内为您安排1对1服务</div>
                        </div>
                    </div>
                    <div class="cell-list"><img
                            src="${ctx}/images/zhifubao.png" alt="支付宝信用评估"
                            class="icon">

                        <div class="cell">
                            <div class="cell-title">支付宝信用评估</div>
                            <div class="cell-content">支付宝扫描销售顾问出示的专属二维码,根据您的信用评估购车方案</div>
                        </div>
                    </div>
                    <div class="cell-list"><img
                            src="${ctx}/images/shoufu.png" alt="支付首付等待提车"
                            class="icon">

                        <div class="cell">
                            <div class="cell-title">支付首付等待提车</div>
                            <div class="cell-content">下载弹个车APP查看订单<br>并支付首付</div>
                        </div>
                    </div>
                    <div class="cell-list"><img
                            src="${ctx}/images/tiche.png" alt="到店提车"
                            class="icon">

                        <div class="cell">
                            <div class="cell-title">到店提车</div>
                            <div class="cell-content">弹个车会为您免费办理保险及上牌手续，收到提车通知后即可到指定门店提车</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="help-find-card help-find-card">
            <img width="100%" height="100%" class="oss-image saler-head" src="${ctx}/images/yanfu.jpg" lazy="loading">
            <div class="flip-text">
                <div class="flip-text-head">hi~想弹什么车？</div>
                <div class="flip-text-sub-head">提交心愿车单，专属顾问帮您找</div>
            </div>
            <img src="${ctx}/images/xiangyou.png" class="right-arrow">
        </div>
        <div>
            <div class="position-holder"></div>
            <div class="jaw-holder"></div>
            <div class="footer-shop-collect-phone-ask">
                <div class="splite-line"></div>
                <div class="left-actions">
                    <div class="left-action">
                        <div class="action-icon"><img src="${ctx}/images/zaixianyuyue.png">
                        </div>
                        <span class="action-name">进店</span>
                    </div>
                    <div class="left-action">
                        <div class="action-icon">
                            <img src="${ctx}/images/shoucang.png">
                        </div>
                        <span class="action-name">收藏</span>
                    </div>
                    <div class="left-action">
                        <div class="action-icon">
                            <img src="${ctx}/images/dianhua.png">
                        </div>
                        <span class="action-name">电话</span></div>
                </div>
                <div class="main-action">立即咨询</div>
            </div>
        </div>
        <div class="floating-level">
            <div class="bottom-actions">
                <img src="${ctx}/images/to_top.svg" class="to-top-tag">
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/js/swiper.min.js"></script>
<script>
    /*轮播*/
    var swiper = new Swiper('.swiper-container', {
        autoplay: 3000,
        pagination: '.swiper-pagination',
        paginationType: 'fraction'
    });
</script>

<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script>
    /*回到顶部*/
    document.querySelector('.to-top-tag').onclick = function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    };

    /*点击切换标准方案*/
    $('.switch-tabs .switch-tab').on('click', function () {
        $('.switch-tabs .switch-tab').removeClass('active');
        $(this).addClass('active');
    });
</script>
</body>
</html>