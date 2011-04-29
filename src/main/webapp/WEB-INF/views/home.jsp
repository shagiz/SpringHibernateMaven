<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<title>Home</title>
</HEAD>
<BODY>

<h2>Home page</h2>
<H3>Check for data list</H3>
<ul>
<li><a href="listdata">File list</a></li>
</ul>

<H3>Upload file</H3>
<form action="upload" enctype="multipart/form-data" method="post">
	File *.xls: <INPUT type="file" name="myFile"><BR>
	<BR><INPUT type="submit" value="Send">
</form>
	
</BODY>
</HTML>