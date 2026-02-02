<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성수 DAY1 여행 코스</title>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72fa81817487692b6dc093004af97650"></script>

<style>
body { margin:0; font-family: Arial, sans-serif; }

#map { width:100%; height:650px; }

/* 상단 버튼 */
.category {
  position:absolute;
  top:20px;
  left:50%;
  transform:translateX(-50%);
  background:#fff;
  padding:10px 16px;
  border-radius:30px;
  box-shadow:0 2px 8px rgba(0,0,0,.3);
  z-index:9999;
}

/* 🔥 카카오맵 font-size 0 강제 무력화 */
.overlay-wrap {
  font-size: 14px;
  text-align: center;
}

/* 번호 마커 */
.marker {
  width:36px;
  height:36px;
  border-radius:50%;
  color:#000;
  font-weight:bold;
  line-height:36px;
  margin:0 auto;
  box-shadow:0 2px 6px rgba(0,0,0,.4);
}

/* 명칭 */
.label {
  margin-top:4px;
  background:#fff;
  color:#000;
  padding:6px 10px;
  border-radius:14px;
  white-space:nowrap;
  box-shadow:0 2px 6px rgba(0,0,0,.25);
}
</style>
</head>

<body>

<div class="category">DAY 1 성수 코스</div>
<div id="map"></div>

<script>
const map = new kakao.maps.Map(document.getElementById('map'), {
  center: new kakao.maps.LatLng(37.5448,127.0433),
  level: 5
});

const courseList = [
  { no:1, title:'성수 연무장길', lat:37.5446, lng:127.0453, color:'#b04cff' },
  { no:2, title:'아모레 성수', lat:37.5459, lng:127.0478, color:'#b04cff' },
  { no:3, title:'성수동 수제화 거리', lat:37.5439, lng:127.0442, color:'#b04cff' },
  { no:4, title:'성수 셀프 포토부스', lat:37.5427, lng:127.0431, color:'#ff4c4c' },
  { no:5, title:'서울숲', lat:37.5443, lng:127.0370, color:'#2ecc71' }
];

let overlays = [];
let polyline = null;

function draw(){
  const path = [];

  courseList.forEach(item => {
    path.push(new kakao.maps.LatLng(item.lat, item.lng));

    const content = 
      '<div class="overlay-wrap">'
        +'<div class="marker" style="background:"'+item.color+'">'
        +item.no
        +'</div>'
        +'<div class="label">'+item.title+'</div>'
      +'</div>';

    const overlay = new kakao.maps.CustomOverlay({
      position: new kakao.maps.LatLng(item.lat, item.lng),
      content: content,
      yAnchor: 1,
      zIndex: 10
    });

    overlay.setMap(map);
    overlays.push(overlay);
  });

  polyline = new kakao.maps.Polyline({
    path: path,
    strokeWeight: 4,
    strokeColor: '#1e90ff'
  });
  polyline.setMap(map);
}

draw();
</script>

</body>
</html>
