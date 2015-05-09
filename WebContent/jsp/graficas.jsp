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
			
			<div id="chart1" style="height:300px; width:1000px"></div>




			function graficaPulsaciones (clase) {
			    $.getJSON("graficas.do", { method: 'listaLecturas', random: Math.random()},
			        function(respuesta) {

			        var vector = new Array();
			        for (var i = 0; i < respuesta.lecturas.length; i++) {   
			            var indice = parseInt(i) + 1;
			            var ind = parseInt(i);
			            vector[ind] = respuesta.lecturas[i].pulsacion;
			        }
			       
			        $(document).ready(function(){
			          // var line1 = [[9, 3.5], [15, 4.4], [22, 6.0], [38, 9.1], [51, 12.0], [62, 14.4]];
			            var line1 = vector;
			           
			            var plot2 = $.jqplot('chart1', [line1], {
			                title: 'GRÁFICA PULSACIONES',
			                axes:{                   
			                  xaxis:{
			                      pad: 0,
			                      showTicks: false,
			                      showTickMarks: false,
			                      label: '',
			                      labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
			                  },
			                  yaxis:{
			                     // showTicks: false,
			                      //showLabel: false,
			                     // showTickMarks: false,
			                      //min: 40,
			                      //max: 120,
			                      label: '',
			                        labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
			                      ticks: [40, 50, 60, 70, 80, 90, 100, 110, 120],                     
			                      tickOptions: {
			                          formatString: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%.0f&nbsp;',
			                         textColor: '#888'
			                      }
			                        //renderer: $.jqplot.CategoryAxisRenderer,
			                        //ticks:[40, 50, 60],
			                      //labelRenderer: $.jqplot.CanvasAxisLabelRenderer
			                  }
			                }
			            });
			         
			        });
			       
			    });
			}
		</script>
		
		
		
	
		<%@ include file="comunes/include-pie.jsp"%>
	</body>
</html>