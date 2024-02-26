<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<html>

<head>  
    <title>Dashboard</title>
    <link rel="stylesheet" href="dash.css">
      <link rel="stylesheet" href="style.css">

	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <style>
     p {
            font-size: 18px;
            color: #007bff;
           
            text-align:center;
        }
        .content{
        display:flex;
        gap:15vw;
        height:500px;
      
        }
 .menu-item{
    padding: 1em;
    border:1px solid white;
    width:100%; 
    background-color:black;
    color:white;
}
        .bigcontainer{
        width:100%;
        height:100%;
        }
        .maincontent{
        width:100%;
        min-height:700px;
        background-color:azure;
        }
        .navcontainer{
        width:100%;
        height:50px;
        }
    
    </style>
</head>
<body>
<div class="bigcontainer">
	<div class="navcontainer">
	<nav>
		<label class="logo">Student Management System</label>

		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="adminLogin.html">Admin</a></li>
			<li><a href="dashboard.jsp">student</a></li>
			<li><a href="sign.html" class="btn btn-success">Login</a></li>
		</ul>
	</nav>

    </div>
    <%-- Retrieve and display UserName from the session --%>
    <%
        String userName = (String)session.getAttribute("userName");
        out.println("<p style='color:black' class='title'>Welcome " + userName +"</p>");
        
    %>
    
 
    <%-- Add the rest of your dashboard content here --%>
    <div class="maincontent">
<div class="content">
    <ul class="menu">
             
             <div id="fetchDataText"><li class="menu-item">Biodata</li>
    </div>
           <div id="fetchDataText1">  <li class="menu-item" >Academics</li> </div>
         <div id="fetchDataText2">      <li class="menu-item">Attendance</li> </div>
            <div> <li class="menu-item">Achievements</li> </div>
           <div>  <li class="menu-item">Extra-Curricular</li> </div>
           <div>  <li class="menu-item">Performance</li> </div>
         </ul>
           <div id="fetchDataResult"></div>
            
    </div>
   
</div>

   <footer>
		<h3 class="footer_text">All @copyright:2023 reserved </h3>
	</footer>
	</div>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Get the clickable text element
            var fetchDataText = document.getElementById('fetchDataText');

            // Add a click event listener
            fetchDataText.addEventListener('click', function () {
                // Perform an AJAX request to the FetchData servlet
                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'FetchData', true);
                xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                var currentUsername = '<%= session.getAttribute("userName") %>';
                xhr.send('userName=' + encodeURIComponent(currentUsername));
                // Handle the response from the servlet
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        // Display the fetched data in a result div
                        document.getElementById('fetchDataResult').innerHTML = xhr.responseText;
                       
                    }
                };
              //  <!-- Add this line inside the click event listener in your script -->
                

                // Send the request
                xhr.send();
            });
        });
        document.addEventListener('DOMContentLoaded', function () {
            // Get the clickable text element
            var fetchDataText1 = document.getElementById('fetchDataText1');

            // Add a click event listener
            fetchDataText1.addEventListener('click', function () {
                // Perform an AJAX request to the FetchData servlet
                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'FetchAcademics', true);
                xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                var currentUsername = '<%= session.getAttribute("userName") %>';
                xhr.send('userName=' + encodeURIComponent(currentUsername));
                // Handle the response from the servlet
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        // Display the fetched data in a result div
                        document.getElementById('fetchDataResult').innerHTML = xhr.responseText;
                       
                    }
                };
                <!-- Add this line inside the click event listener in your script -->
                

                // Send the request
                xhr.send();
            });
        });
        document.addEventListener('DOMContentLoaded', function () {
            // Get the clickable text element
            var fetchDataText2 = document.getElementById('fetchDataText2');

            // Add a click event listener
            fetchDataText2.addEventListener('click', function () {
                // Perform an AJAX request to the FetchData servlet
                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'Student_Attendence', true);
                xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                var currentUsername = '<%= session.getAttribute("userName") %>';
                xhr.send('userName=' + encodeURIComponent(currentUsername));
                // Handle the response from the servlet
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        // Display the fetched data in a result div
                        document.getElementById('fetchDataResult').innerHTML = xhr.responseText;
                       
                    }
                };
                <!-- Add this line inside the click event listener in your script -->
                

                // Send the request
                xhr.send();
            });
        });
    </script>
</body>
</html>
