//地图
//基本地图加载
var map/* = new AMap.Map("container", {
    resizeEnable: true,
    zoom:12,//map区域级别
    // center: [116.397428, 39.90923]  //城市经纬度
})*/;
function getPoint(ctx){
    map = new AMap.Map("container", {
        resizeEnable: true,
        zoom:12,//map区域级别
        // center: [116.397428, 39.90923]  //城市经纬度
    });
    /* 切换城市 */
    /*AMap.event.addDomListener(
     document.getElementById('query'), 'click', function() {
     var cityName = document.getElementById('cityName').value;
     // 城市为空 为哈尔滨
     if (!cityName) {
     cityName = '哈尔滨市';
     }
     //set城市
     map.setCity(cityName);
     });*/

    /* POI信息 _ 出发地_Start*/
    AMapUI.loadUI(['misc/PoiPicker'], function(PoiPicker) {
        var poiPicker = new PoiPicker({
            //city:'北京',
            //input: 'pickerInput'
            input: 'fromadd'
        });

        //初始化poiPicker
        poiPickerReady_fromadd(poiPicker);
    });
    function poiPickerReady_fromadd(poiPicker) {
        window.poiPicker = poiPicker;
        var marker = new AMap.Marker();
        var infoWindow = new AMap.InfoWindow({
            offset: new AMap.Pixel(0, -20)
        });
        //选取了某个POI
        poiPicker.on('poiPicked', function(poiResult) {
            var source = poiResult.source,
                poi = poiResult.item,
                frominfo = {
                    source: source,
                    id: poi.id,
                    name: poi.name,
                    location: poi.location.toString(),
                    address: poi.address
                };
            // 将出发地址 放入 input中
            $("#fromadd").val(frominfo.address);
            // 将经纬度 放入 input中
            var from = frominfo.location.split(',');
            $("#fromlon").val(from[0]);
            $("#fromlat").val(from[1]);
                /*alert("==>"+from[0]);
                alert(from[1]);*/
                if($("#tolon").val()!="" && $("#tolat").val()!=""){
                    $.post(ctx+"/torder/getKm_Duration",{fromlon:$("#fromlon").val(),fromlat:$("#fromlat").val(),tolon:$("#tolon").val(),tolat:$("#tolat").val()},function (d) {
                        if(d=="ajaxfail"){
                            Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                                if(btn=="yes"){
                                    window.location.href="${ctx}/sys/index";
                                }
                            });
                        }else {
                            var km_d = d.split(',');
                            $("#km").val(km_d[0]);
                            $("#duration").val(km_d[1]);
                            //alert(d);
                        }
                    });
                }
            marker.setMap(map);
            infoWindow.setMap(map);
            marker.setPosition(poi.location);
            infoWindow.setPosition(poi.location);
            //infoWindow.setContent('POI信息: <pre>' + JSON.stringify(info, null, 2) + '</pre>');
            infoWindow.open(map, marker.getPosition());
            //map.setCenter(marker.getPosition());
        });
        poiPicker.onCityReady(function() {
            poiPicker.suggest('美食');
        });
    }
    /* POI信息 _ 出发地_End*/

    // 目的地_Start
    AMapUI.loadUI(['misc/PoiPicker'], function(PoiPicker) {
        var poiPicker = new PoiPicker({
            //city:'北京',
            //input: 'pickerInput'
            input: 'toadd'
        });

        //初始化poiPicker
        poiPickerReady_toadd(poiPicker);
    });
    function poiPickerReady_toadd(poiPicker) {
        window.poiPicker = poiPicker;
        var marker = new AMap.Marker();
        var infoWindow = new AMap.InfoWindow({
            offset: new AMap.Pixel(0, -20)
        });
        //选取了某个POI
        poiPicker.on('poiPicked', function(poiResult) {
            var source = poiResult.source,
                poi = poiResult.item,
                toinfo = {
                    source: source,
                    id: poi.id,
                    name: poi.name,
                    location: poi.location.toString(),
                    address: poi.address
                };
            // 将目的地 放入 input中
            $("#toadd").val(toinfo.name);
            //将经纬度 放入 input中
            var to = toinfo.location.split(',');
            $("#tolon").val(to[0]);
            $("#tolat").val(to[1]);
                //alert("toadd==>"+info.location);
            if($("#fromlon").val()!="" && $("#fromlat").val()!=""){
                $.post(ctx+"/torder/getKm_Duration",{fromlon:$("#fromlon").val(),fromlat:$("#fromlat").val(),tolon:$("#tolon").val(),tolat:$("#tolat").val()},function (d) {
                    if(d=="ajaxfail"){
                        Showbo.Msg.confirm1("会话过期,请重新登录!",function(btn){
                            if(btn=="yes"){
                                window.location.href="${ctx}/sys/index";
                            }
                        });
                    }else {
                        var km_d = d.split(',');
                        $("#km").val(km_d[0]);
                        $("#duration").val(km_d[1]);
                    }
                });
            }
            marker.setMap(map);
            infoWindow.setMap(map);
            marker.setPosition(poi.location);
            infoWindow.setPosition(poi.location);
            //infoWindow.setContent('POI信息: <pre>' + JSON.stringify(info, null, 2) + '</pre>');
            infoWindow.open(map, marker.getPosition());
            //map.setCenter(marker.getPosition());
        });
        poiPicker.onCityReady(function() {
            poiPicker.suggest('美食');
        });
    }
    // 目的地_End
}

function getMap() {
    $("#map_model h4").text("拾取坐标点");
    $(".button-group").css({"display":"none"});
    map = new AMap.Map("container", {
        resizeEnable: true,
        zoom:12,//map区域级别
    });

    //绘制初始路径
    var path = [];
    path.push([$("#fromlon").val(), $("#fromlat").val()]);
     //path.push([116.321354, 39.896436]);
     path.push([$("#tolon").val(), $("#tolat").val()]);

    /*path.push([126.637469,45.7261]); // 文昌街
    //path.push([116.321354, 39.896436]);
    path.push([126.689599,45.726271]); //通乡商店*/
    var aa = map.plugin(["AMap.DragRoute"], function() {
        route = new AMap.DragRoute(map, path, AMap.DrivingPolicy.LEAST_FEE); //构造拖拽导航类
        route.search(); //查询导航路径并开启拖拽导航
        AMap.event.addListener(route, "complete",function(data){
            //alert(data['data']['destination'].lat);
            global_fromlat = data['data']['destination'].lat;
            global_fromlon = data['data']['destination'].lng;
            global_tolon = data['data']['origin'].lng;
            global_tolat = data['data']['origin'].lat;
            //console.log(data['data']['destination']);//origin
        });
    });

    $('#map_model').modal();
}

function wayMap(first,lineArray) {
    $("#map_model h4").text("轨迹回放");
    $(".button-group").css({"display":"block"});
    map = new AMap.Map("container", {
        resizeEnable: true,
        zoom:12,//map区域级别
    });
    var marker, lineArr = []; // marker:移动轨迹点, lineArr:移动轨迹
    //map.on("complete", completeEventHandler);
    AMap.event.addDomListener(document.getElementById('start'), 'click', function() {
        marker.moveAlong(lineArr, 500);
    }, false);
    AMap.event.addDomListener(document.getElementById('stop'), 'click', function() {
        marker.stopMove();
    }, false);

    // 地图图块加载完毕后执行函数
    //function completeEventHandler() {
    // 改变样式和大小的(CarLogo)
    marker = new AMap.Marker({
        map: map,
        //position: [126.72558,45.734584],  // 起点
        position: first,
        icon: "http://webapi.amap.com/images/car.png",
        offset: new AMap.Pixel(-26, -13),
        autoRotation: true
    });

    //var lngX = 121.50457499999999, latY = 31.242533333333334;
    //lineArr.push([126.72558,45.734584],[126.724207,45.730285],[126.721568,45.730098],[126.716482,45.730779],[126.710592,45.731716],[126.705925,45.732419],[126.699842,45.731356],[126.694252,45.730173],[126.688448,45.728952],[126.677301,45.726653],[126.673814,45.729304],[126.671915,45.734007],[126.668889,45.738013],[126.663782,45.742266],[126.657141,45.747575],[126.649674,45.753467],[126.643365,45.757307],[126.636724,45.760076],[126.635544,45.763183]);
    for(var i=0;i<lineArray.length;i++ ){
        lineArr.push(eval('('+lineArray[i]+')'));
    }

    // 绘制轨迹
    var polyline = new AMap.Polyline({
        map: map,
        path: lineArr,
        strokeColor: "#00A",  //线颜色
        strokeOpacity: 1,     //线透明度
        strokeWeight: 3,      //线宽
        strokeStyle: "solid"  //线样式
    });
    map.add(marker);
    map.add(polyline);
    $('#map_model').modal();
}