<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성수 DAY1 여행 코스</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72fa81817487692b6dc093004af97650"></script>

<style>

body{
 margin:0;
 font-family:Arial;
 background:#f5f5f5;
}

#map{
 width:100%;
 height:600px;
 margin-top:80px;
}

/* 상단 검색 */
.search-box{
 position:absolute;
 top:20px;
 left:50%;
 transform:translateX(-50%);
 background:white;
 padding:12px 20px;
 border-radius:30px;
 box-shadow:0 3px 10px rgba(0,0,0,.3);
 z-index:9999;
}

/* overlay */
.overlay-wrap{
 font-size:14px;
 text-align:center;
}

.marker{
 width:38px;
 height:38px;
 border-radius:50%;
 color:#000;
 font-weight:bold;
 line-height:38px;
 margin:0 auto;
 box-shadow:0 2px 6px rgba(0,0,0,.4);
}

.label{
 margin-top:5px;
 background:#fff;
 padding:6px 10px;
 border-radius:15px;
 white-space:nowrap;
 box-shadow:0 2px 6px rgba(0,0,0,.25);
 color:#000
}

.caption p{
 overflow:hidden;
 white-space:nowrap;
 text-overflow:ellipsis;
}

</style>
</head>

<body>

<!-- ================= 검색 ================= -->

<div class="search-box">
<form method="get" action="/">
 <input type="text" name="title"
        class="input-sm"
        placeholder="여행지 검색">
 <button class="btn btn-danger btn-sm">검색</button>
</form>
</div>

<!-- ================= 지도 ================= -->

<div id="map"></div>

<script>

//////////////////////////////////////////////////
// DB → JS 데이터 변환
//////////////////////////////////////////////////

const courseList=[
<c:forEach var="vo" items="${list}">
{
 no:${vo.rank},
 title:'${vo.title}',
 lat:${vo.y},
 lng:${vo.x},
 color:'${vo.color}'
},
</c:forEach>
];

//////////////////////////////////////////////////
// 지도 중심 자동 이동
//////////////////////////////////////////////////

let centerLat=37.5448;
let centerLng=127.0433;

if(courseList.length>0){
 centerLat=courseList[0].lat;
 centerLng=courseList[0].lng;
}

const map=new kakao.maps.Map(
 document.getElementById('map'),
 {
   center:new kakao.maps.LatLng(centerLat,centerLng),
   level:4
 });

//////////////////////////////////////////////////
// 마커 + 경로
//////////////////////////////////////////////////

let overlays=[];
let path=[];

courseList.forEach(item=>{

 const position=
   new kakao.maps.LatLng(item.lat,item.lng);

 path.push(position);

 const content=
   '<div class="overlay-wrap">'
   +'<div class="marker" style="background:'+item.color+'">'
   +item.no
   +'</div>'
   +'<div class="label">'+item.title+'</div>'
   +'</div>';

 const overlay=new kakao.maps.CustomOverlay({
   position:position,
   content:content,
   yAnchor:1,
   zIndex:10
 });

 overlay.setMap(map);
 overlays.push(overlay);

});

//////////////////////////////////////////////////
// 경로선
//////////////////////////////////////////////////

const polyline=new kakao.maps.Polyline({
 path:path,
 strokeWeight:5,
 strokeColor:'#1e90ff',
 strokeOpacity:0.9
});

polyline.setMap(map);

//////////////////////////////////////////////////
// 지도 자동 맞춤 (검색 결과)
//////////////////////////////////////////////////

if(courseList.length>0){

 const bounds=new kakao.maps.LatLngBounds();

 courseList.forEach(c=>{
   bounds.extend(
     new kakao.maps.LatLng(c.lat,c.lng)
   );
 });

 map.setBounds(bounds);
}

//////////////////////////////////////////////////
// 이동거리 계산
//////////////////////////////////////////////////

if(courseList.length>1){

 const distance=(polyline.getLength()/1000).toFixed(2);

 console.log("총 이동거리:",distance+"km");
}

</script>

<div style="height:50px"></div>

<!-- ================= 카드 리스트 ================= -->

<div class="container">
 <div class="row">

 <c:forEach var="vo" items="${list}">

  <div class="col-md-4">
   <div class="thumbnail">

    <a href="#">
     <img src="${vo.image1}" style="width:100%;height:230px;object-fit:cover">

     <div class="caption">
      <p>${vo.title}</p>
     </div>
    </a>

   </div>
  </div>

 </c:forEach>

 </div>
</div>

</body>
</html>