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
		<div class="container">	
			<div class="custom-calendar-wrap custom-calendar-full">
				<div class="custom-header clearfix">
					<h3 class="custom-month-year">
						<span id="custom-month" class="custom-month"></span>
						<span id="custom-year" class="custom-year"></span>
						<nav>
							<span id="custom-prev" class="custom-prev"></span>
							<span id="custom-next" class="custom-next"></span>
							<span id="custom-current" class="custom-current" title="Got to current date"></span>
						</nav>
					</h3>
				</div>
				<div id="calendar" class="fc-calendar-container"></div>
			</div>
		</div><!-- /container -->
	
	</section>	

	<script type="text/javascript" src="../js/jquery.calendario.js"></script>
	<script type="text/javascript" src="../js/data.js"></script>
	<script type="text/javascript">	
	
		  $(function() {
		
			var cal = $( '#calendar' ).calendario( {
					onDayClick : function( $el, $contentEl, dateProperties ) {
						
						for( var key in dateProperties ) {
							console.log( key + ' = ' + dateProperties[ key ] );
						}

					},
					caldata : codropsEvents
				} ),
				$month = $('#custom-month').html( cal.getMonthName() ),
				$year = $('#custom-year').html( cal.getYear() );

			$('#custom-next').on( 'click', function() {
				cal.gotoNextMonth( updateMonthYear );
			} );
			$('#custom-prev').on('click', function() {
				cal.gotoPreviousMonth( updateMonthYear );
			} );
			$('#custom-current').on('click', function() {
				cal.gotoNow( updateMonthYear );
			} );

			function updateMonthYear() {				
				$month.html(cal.getMonthName());
				$year.html(cal.getYear());
			}

			// you can also add more data later on. As an example:
			/*
			someElement.on( 'click', function() {
				
				cal.setData( {
					'03-01-2013' : '<a href="#">testing</a>',
					'03-10-2013' : '<a href="#">testing</a>',
					'03-12-2013' : '<a href="#">testing</a>'
				} );
				// goes to a specific month/year
				cal.goto( 3, 2013, updateMonthYear );
				
			} );
			*/
		cal.setData( {"05-15-2015" : "<div onclick=\"mostrarEvento();\" style=\"width:100%; height 20px; background:#F1AB37\">11:00-12:00</div>"} );
		});
	</script>

	<%@ include file="comunes/include-pie.jsp"%>
</body>
</html>