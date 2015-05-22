<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
		<script src="../js/highcharts.js"></script>
		<script src="../js/highcharts-3d.js"></script>
		<style type="text/css">
			#container {
				height: 400px; 
				min-width: 310px; 
				max-width: 800px;
				margin: 0 auto;
			}
		</style>
		<script type="text/javascript">
			pintaGrafico = function () {
			    $('#container').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Monthly Average Rainfall'
			        },
			        subtitle: {
			            text: 'Source: WorldClimate.com'
			        },
			        xAxis: {
			            categories: [
			                'Jan',
			                'Feb',
			                'Mar',
			                'Apr',
			                'May',
			                'Jun',
			                'Jul',
			                'Aug',
			                'Sep',
			                'Oct',
			                'Nov',
			                'Dec'
			            ],
			            crosshair: true
			        },
			        yAxis: {
			            min: 0,
			            title: {
			                text: 'Rainfall (mm)'
			            }
			        },
			        tooltip: {
			            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
			            footerFormat: '</table>',
			            shared: true,
			            useHTML: true
			        },
			        plotOptions: {
			            column: {
			                pointPadding: 0.2,
			                borderWidth: 0
			            }
			        }/*,
			        series: [{
			            name: 'Publicados',
			            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
	
			        }, {
			            name: 'Canjeados',
			            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
	
			        }]*/
			    });
			};
			
			
			$(document).ready(function() {
				$.post("/canjehoras/graficas/datosGraficas.html",
						{ 
						},
						function (respuesta) {
							var chart = $('#container').highcharts();
							if(chart!=null){
								chart.destroy();
							}
							
							pintaGrafico();
							chart = $('#container').highcharts();
							chart.addSeries(respuesta.series);
							
						}
			, "json");
			
				
			});
			
		</script>
	</head>
	<body>



<div id="container" style="height: 400px"></div>
	</body>
</html>
