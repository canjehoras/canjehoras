<!doctype html>
<%@ include file="comunes/include-taglib.jspf"%>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" name="viewport"	content="text/html; charset=UTF-8; width=device-width, maximum-scale=1">
		
		<link href="../css/calendar.css" rel="stylesheet" type="text/css"> 
	</head>
	<body>
		<%@ include file="comunes/include-cabecera.jsp"%>
		
		<section id="categoria" class="content">
			<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		</section>	
	
		<script src="http://code.highcharts.com/highcharts.js"></script>
		<script src="http://code.highcharts.com/modules/exporting.js"></script>
	
		<script type="text/javascript">	
			$(function () {
			    $('#container').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Numero de canjeos por usuario ${sessionScope.usuario.nombre}'
			        },
			        xAxis: {
			            categories: [
			                'Enero',
			                'Febrero',
			                'Marzo',
			                'Abril',
			                'Mayo',
			                'Junio',
			                'Julio',
			                'Agosto',
			                'Septiembre',
			                'Octubre',
			                'Noviembre',
			                'Diciembre'
			            ],
			            crosshair: true
			        },
			        yAxis: {
			            min: 0,
			            title: {
			                text: 'CANJEOS (Horas)'
			            }
			        },
			        tooltip: {
			            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			                '<td style="padding:0"><b>{point.y:.1f} trueques</b></td></tr>',
			            footerFormat: '</table>',
			            shared: true,
			            useHTML: true
			        },
			        plotOptions: {
			            column: {
			                pointPadding: 0.2,
			                borderWidth: 0
			            }
			        },
			        series: ${series}
			    });
			});
		</script>
	
		<%@ include file="comunes/include-pie.jsp"%>
	</body>
</html>