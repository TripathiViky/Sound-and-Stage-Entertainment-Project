<%-- 
    Document   : NewSeat
    Created on : 24 Jun, 2018, 3:28:53 AM
    Author     : Vikas
--%>
<jsp:useBean id="obt" class="models.TheaterModel"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin: Movies</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/index-style.css">
        <link rel="stylesheet" type="text/css" href="css/common-page.css">
        <style>
body {
      font: 400 15px/1.8 Lato, sans-serif;
      color: #777;
  }
  h3, h4 {
      margin: 10px 0 30px 0;
      letter-spacing: 10px;      
      font-size: 20px;
      color: #111;
  }
  .container {
      padding: 80px 120px;
  }
  .person {
      border: 10px solid transparent;
      margin-bottom: 25px;
      width: 80%;
      height: 80%;
      opacity: 0.7;
  }
  .person:hover {
      border-color: #f1f1f1;
  }
  .carousel-inner img {
     /* -webkit-filter: grayscale(90%);
      filter: grayscale(90%); /* make all photos black and white */ 
      width: 100%; /* Set width to 100% */
      margin: auto;
      height: 300px;
  }
  .carousel-caption h3 {
      color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  .bg-1 {
      background: #2d2d30;
      color: #bdbdbd;
  }
  .bg-1 h3 {color: #fff;}
  .bg-1 p {font-style: italic;}
  .list-group-item:first-child {
      border-top-right-radius: 0;
      border-top-left-radius: 0;
  }
  .list-group-item:last-child {
      border-bottom-right-radius: 0;
      border-bottom-left-radius: 0;
  }
  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
  }
  .btn {
      padding: 10px 20px;
      background-color: #333;
      color: #f1f1f1;
      border-radius: 0;
      transition: .2s;
  }
  .btn:hover, .btn:focus {
      border: 1px solid #333;
      background-color: #fff;
      color: #000;
  }
  .modal-header, h4, .close {
      background-color: #333;
      color: #fff !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-header, .modal-body {
      padding: 40px 50px;
  }
  .nav-tabs li a {
      color: #777;
  }
  #googleMap {
      width: 100%;
      height: 400px;
      -webkit-filter: grayscale(100%);
      filter: grayscale(100%);
  }  
  .navbar {
      font-family: Montserrat, sans-serif;
      margin-bottom: 0;
      background-color: #2d2d30;
      border: 0;
      font-size: 18px !important;
      letter-spacing: 4px;
      opacity: 0.9;
      height: 7%;
  }
  .navbar li a, .navbar .navbar-brand { 
      color: #d5d5d5 !important;
  }
  .navbar-nav li a:hover {
      color: #fff !important;
  }
  .navbar-nav li.active a {
      color: #fff !important;
      background-color: #29292c !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
  }
  .open .dropdown-toggle {
      color: #fff;
      background-color: #555 !important;
  }
  .dropdown-menu li a {
      color: #000 !important;
  }
  .dropdown-menu li a:hover {
      background-color: red !important;
  }
  footer {
      background-color: #2d2d30;
      color: #f5f5f5;
      padding: 32px;
  }
  footer a {
      color: #f5f5f5;
  }
  footer a:hover {
      color: #777;
      text-decoration: none;
  }  
  .form-control {
      border-radius: 0;
  }
  textarea {
      resize: none;
  }
  
  
  * {
  box-sizing: border-box;
}

.row1 > .column1 {
  padding: 0 8px;
  
}

.row1:after {
  content: "";
  display: table;
  clear: both;
}

.column1 {
  float: left;
  width: 25%;
}

/* The Modal (background) */
.modal1 {
  display: none;
  position: fixed;
  z-index: 1;
  padding-top: 100px;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: black;
}

/* Modal Content */
.modal-content1 {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  width: 90%;
  max-width: 1200px;
}

.mySlides1 {
  display: none;
}

/* Next & previous buttons */
.prev1,
.next1 {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;
}

/* Position the "next button" to the right */
.next1 {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev1:hover,
.next1:hover {
  background-color: rgba(0, 0, 0, 0.8);
}

/* Number text (1/3 etc) */
.numbertext1 {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

img1 {
  margin-bottom: -4px;
}

.caption-container1 {
  text-align: center;
  background-color: black;
  padding: 2px 16px;
  color: white;
}

.demo1 {
  opacity: 0.6;
}

.active1,
.demo1:hover {
  opacity: 1;
}

img1.hover-shadow {
  transition: 0.3s;
}

.hover-shadow:hover {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

/*here come imag fading*/


.container1 {
    position: relative;
    width: 100%;
}

.image1 {
  opacity: 1;
  display: block;
  width: 100px;
  height: 170px;
  transition: .5s ease;
  backface-visibility: hidden;
}

.middle1 {
  transition: .5s ease;
  opacity: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
}

.container1:hover .image1 {
  opacity: 0.3;
}

.container1:hover .middle1 {
  opacity: 1;
}

.text1 {
  background-color: #4CAF50;
  color: white;
  font-size: 16px;
  padding: 16px 32px;
}
      
      /*Social MEdia button ===============================================================*/
      
      .fa {
  padding: 20px;
  font-size: 30px;
  width: 50px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}

.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}

.fa-linkedin {
  background: #007bb5;
  color: white;
}

.fa-youtube {
  background: #bb0000;
  color: white;
}
           .maintable{
           width: 100%;
           height: 30%
           }
           
   input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
    
input[type=submit] {
    width: 30%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 14px 110px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    
}

input[type=submit]:hover {
    background-color: #45a049;
}

.forum1 {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 50px;
}

        </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">Sound & Stage Entertainment</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Home.jsp">Home</a></li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Profile
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="ChangePassword.jsp">Change Password</a></li>
            <li><a href="RegisterPOS.jsp">Register POS</a></li>
            <li><a href="ViewLogByUser.jsp">Log Records</a></li>
            <li><a href="../LogoutController">Logout</a></li> 
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Theater
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="NewTheatre.jsp">Add</a></li>
            <li><a href="NewTheatre.jsp">Edit</a></li>
            <li><a href="NewTheatre.jsp">Delete</a></li>  
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Hall
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="NewHall.jsp">Add</a></li>
            <li><a href="NewHall1.jsp">Edit</a></li>
            <li><a href="NewHall1.jsp">Delete</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Seat
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="NewSeat.jsp">Add</a></li>
            <li><a href="NewSeat2.jsp">Edit</a></li>
            <li><a href="NewSeat2.jsp">Delete</a></li>  
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">ShowPlan
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="NewShowPlan1.jsp">Add</a></li>
            <li><a href="NewShowPlan1.jsp">Edit</a></li>
            <li><a href="NewShowPlan1.jsp">Delete</a></li>  
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Movies
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="NewMovie1.jsp">Add</a></li>
            <li><a href="NewMovie2.jsp">Edit</a></li>
            <li><a href="NewMovie2.jsp">Delete</a></li> 
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Snacks
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="NewSnack1.jsp">Add</a></li>
            <li><a href="NewSnack2.jsp">Edit</a></li>
            <li><a href="NewSnack2.jsp">Delete</a></li> 
          </ul>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<!--Main Content-->
<br>
<br>
<div class="forum1">

<form name="form1" method="post" action="NewSeat1.jsp" >
            <table id="maintable" align="center">
                <tr>
                    <td>select theater</td>
                    <td><%= obt.getCombo("cmbtheatercode") %></td>
                </tr> 
                <tr><td colspan="2"><input type="submit" value="submit" /></td></tr>
            </table>
                    
        </form>

</div>
<!--Main Content Ends-->


<!-- NAVBAR OUTPUT ENDS-->    
    
    
    <center>
        <br>
        <div class="register-footer">
    <footer>
    <a href="#" class="fa fa-facebook"></a>
<a href="#" class="fa fa-twitter"></a>
<a href="#" class="fa fa-google"></a>
<a href="#" class="fa fa-linkedin"></a>
<a href="#" class="fa fa-youtube"></a>

    </footer>
     <footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p> <b>Copyright @ 1995 Sound & Stage Entertainment &nbsp; All trademarks acknowledged.</b></p> 
</footer>       
            
    </center>
</body>
</html>
