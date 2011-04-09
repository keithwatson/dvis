<html>
<head>
	<link rel="stylesheet" title="Data Visualisation" type="text/css" href="../stylesheets/main.css">
</head>

<body>
	<header>
		<h1>Parse CSV File</h1>
	</header>

	<section class="main">
		<p>Welcome.</p>
		<p>Please upload your CSV file. Once uploaded, you can select columns you wish to use to chart.</p>

		<form class="fileUploadForm" action="fileUpload" enctype="multipart/form-data" method="post">
			<input type="file" name="uploadFile" /> <input type="submit" class="white button" value="Upload File"/>
			
			<!-- Error Message -->
			<p class="errorMessage" style="display: none">Please enter a valid filename</p>
			
		</form>
	</section>

	<div class="verticalbreak"></div>
</body>

</html>
