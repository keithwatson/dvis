<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<html>
<head>
	<title>Bar Chart</title>
	<script type="text/javascript" src="/Visualisation/scripts/protovis-r3.2.js"></script>
</head>

<body>
	<div id="center">
	<div id="fig">
		<script type="text/javascript+protovis">${script}</script>
	</div>
	</div>
</body>
</html>