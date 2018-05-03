
<head>
		<title>后台店主页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript"  src="${rc.contextPath}/asset/js/jquery.min-1.7.2.js"></script>
		<style type="text/css">
			table.gridtable {
				font-family: verdana,arial,sans-serif;
				font-size:11px;
				color:#333333;
				border-width: 1px;
				border-color: #666666;
				border-collapse: collapse;
			}
			table.gridtable th {
				border-width: 1px;
				padding: 8px;
				border-style: solid;
				border-color: #666666;
				background-color: #dedede;
			}
			table.gridtable td {
				border-width: 1px;
				padding: 8px;
				border-style: solid;
				border-color: #666666;
				background-color: #ffffff;
			}
		</style>
</head>
<script>
function test(){
		var requestParam = $("#requestParam").val();
		if(requestParam==""){
			alert("请输入请求参数!");
			return;
		}
		$("#responseParam").html("");
		$.post("${rc.contextPath}/api/sub.htm",$.parseJSON(requestParam),function(data){
			$("#responseParam").val(data)
		});
}
</script>
<body>
<div>
	<button onclick="test();">店主测试</button>
</div><br>
<div>
<table class="gridtable" style="width: 1000px;text-align: center;">
		<tr>
			<th width="500">请求参数</th>
			<th>响应参数</th>
		</tr>
		<tr>
			<td height="400">
			<textarea id="requestParam" name="requestParam"  style="width:100%;height:100%">{
    "source": "Android",
    "code": "test1001",
    "imei": "dcbffbc2-95bb-3f6e-83c6-d7274f2bf8e2",
    "token": "577b476883ef48428d5aa174be1104f1",
    "timestamp": 1452235442266,
    "mak": "61c4994d5641e08fa95d96727a43a8e4",
    "sourceShopId": 1,
    "loginShopId": 1,
    "data": "{\"limit\":100}"
}
			</textarea></td>
			<td><textarea id="responseParam"  name="responseParam"  style="width:100%;height:100%"></textarea></td>
		</tr>
</table>
</div>
</body>