/**
 * 
 */

<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=e0ebd4d3aa03af7354a601561f14770b"></script>
	<script type="text/javascript">
		//��ȡ�û����ڳ�����Ϣ
function showCityInfo() { 
	//���س��в�ѯ���
	var cityname = "";
	AMap.service(["AMap.CitySearch"], function() {
		//ʵ�������в�ѯ��
		var citysearch = new AMap.CitySearch();
		//�Զ���ȡ�û�IP�����ص�ǰ����
		citysearch.getLocalCity(function(status, result){
			if(status === 'complete' && result.info === 'OK'){
				if(result && result.city && result.bounds) {
					var cityinfo = result.city;
					var citybounds = result.bounds;
					//alert("����ǰ���ڳ��У�" + cityinfo + "");
					//��ͼ��ʾ��ǰ����
					cityname = cityinfo;
				}
			}else{
				//alert("����ǰ���ڳ��У�" + result.info + "");
				cityname =  result.info;
			}
		});
	});
	return cityname;
}
	</script>
