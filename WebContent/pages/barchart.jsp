<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<html>
<head>
<title>Bar Chart</title>
<script type="text/javascript" src="/Visualisation/scripts/protovis-r3.2.js"></script>
<style type="text/css">
#fig {
	width: 430px;
	height: 275px;
}
</style>
</head>
<body>
<div id="center">
<div id="fig">
	<script type="text/javascript+protovis">

		<%= request.getAttribute("script") %>
	
    </script></div>
</div>
</body>
</html>