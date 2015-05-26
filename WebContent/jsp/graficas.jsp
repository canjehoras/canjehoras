<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
		<style type="text/css">
			#container {
				height: 400px; 
				min-width: 310px; 
				max-width: 800px;
				margin: 0 auto;
			}
		</style>
		<script type="text/javascript">
			pintaGrafico = function (series) {
			    $('#container').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Canjes por mes'
			        },
			        subtitle: {
			            text: ''
			        },
			        xAxis: {
			            categories: [
			                'Ene',
			                'Feb',
			                'Mar',
			                'Apr',
			                'May',
			                'Jun',
			                'Jul',
			                'Ago',
			                'Sep',
			                'Oct',
			                'Nov',
			                'Dic'
			            ],
			            crosshair: true
			        },
			        yAxis: {
			            min: 0,
			            title: {
			                text: 'Canjes'
			            }
			        },
			        tooltip: {
			            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			                '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
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
			        series: series
			    });
			};
			
			
			$(document).ready(function() {
				$.post("/canjehoras/graficas/datosGraficas.html",
						{ 
						},
						function (respuesta) {
							
							pintaGrafico(respuesta.series);
							
						}
			, "json");
			
				
			});
			
		</script>
	</head>
	<body>

		<div id="container" style="height: 400px; margin-top: 20px;"></div>

	</body>
</html>
