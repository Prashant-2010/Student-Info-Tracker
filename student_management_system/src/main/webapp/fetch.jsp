<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management System</title>
    <link rel="stylesheet" type="text/css" href="style.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
</head>
<body>
	<div class="bigcontainer">
        <div class="navcontainer">
            <nav>
                <label class="logo">Student Management System</label>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#" onclick="showForm('admin-page')">Welcome Admin</a></li>
                    <li><a href="#" onclick="showForm('user-form')">Biodata</a></li>
                    <li><a href="#" onclick="showForm('attendance-form')">Attendance</a></li>
                    <li><a href="#" onclick="showForm('academics-form')">Academics</a></li>
                    <!-- Add this button inside your <ul> element -->
                    <li><button type="button" onclick="viewRecords()">View Records</button></li>
                </ul>
            </nav>
        </div>
        <!-- Add your content here -->
        <div id="fetchDataResult"></div>
    </div>
    <script>
        function viewRecords() {
            // Perform an AJAX request to fetch and display records
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'DisplayAdminBio', true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    // Display the fetched records in a result div
                    document.getElementById('fetchDataResult').innerHTML = xhr.responseText;
                }
            };
            xhr.send();
        }
    </script>
</body>
</html>
