<html>
<head>
	<link rel="stylesheet" title="Data Visualisation" type="text/css" href="stylesheets/main.css">
</head>

<body>
	<header>
		<h1>Data Visualisation</h1>
	</header>

	<section class="main">
		<p>Welcome.</p>
		<p>Please upload your CSV file, in the following format</p>

		<img class="image" src="images/barchart.png"></img>

		<form class="fileUploadForm" action="fileUpload" enctype="multipart/form-data" method="post">
			<input type="file" name="uploadFile" /> <input type="submit" class="white button" value="Upload File"/>
			
			<!-- Error Message -->
			<p class="errorMessage" style="display: none">Please enter a valid filename</p>
		</form>
	</section>
	
</body>

</html>
