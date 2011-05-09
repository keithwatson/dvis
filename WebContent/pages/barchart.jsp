<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<html>
<head>
	<title>Bar Chart</title>
	<script type="text/javascript" src="/Visualisation/scripts/protovis-d3.2.js"></script>
	<script type="text/javascript" src="/Visualisation/scripts/Visualisation.js"></script>
</head>


<body>
<!-- hidden span only used to get string length in pixels -->
<span id="ruler" style="visibility: hidden; white-space: nowrap; font-size: 10px"></span>



	<div id="center">
	<div id="fig">
		<script type="text/javascript+protovis">${script}</script>
	</div>
	</div>
</body>
</html>