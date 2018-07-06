<%-- 
    Document   : BookingForm6
    Created on : 1 Jul, 2018, 1:02:46 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/index-style.css">
        <link rel="stylesheet" type="text/css" href="css/login-style.css">
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
        <li><a href="menu.jsp">Home</a></li>
        <li><a href="#movies">Movies</a></li>
        <li><a href="#comingsoon">Coming Soon</a></li>
        <li><a href="#contact">Contact</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Profile
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Changepassword.jsp">Change Password</a></li>
            <li><a href="LogoutController">Logout</a></li> 
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
    
        <br>
        <br>
    <center>   
    ${result}
    </center>
    <!-- Same NavBAr output-->
    
    <div id="movies" class="container text-center">
  <h3>Todays Shows</h3><br>
  
  
  <div class="row1">
  <div class="column1">
    <h5 align="left">Avengers- Infinity War</h5>
<div class="container1">
  <img src="images/infi%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="BookingForm1.jsp">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Thor Ragnarok</h5>
<div class="container1">
  <img src="images/thor%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="thor%20ragnarok.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Black Panther</h5>
<div class="container1">
  <img src="images/black%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="black%20panther.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Spider-Man: Homecoming</h5>
<div class="container1">
  <img src="images/spider%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="spiderman.html">Book</a>
    </div>
  </div>
</div>
  </div>
      
      <div class="row1">
  <div class="column1">
    <h5 align="left">Doctor Strange</h5>
<div class="container1">
  <img src="images/doctor%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="doctor%20strange.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Captain America: Civil War</h5>
<div class="container1">
  <img src="images/civil%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="civil%20war.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Ant Man</h5>
<div class="container1">
  <img src="images/ant%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="ant%20man.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Avengers- Age Of Ultron</h5>
<div class="container1">
  <img src="images/ageultron%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="age%20of%20ultron.html">Book</a>
    </div>
  </div>
</div>
  </div>
          
<div class="row1">
  <div class="column1">
    <h5 align="left">Guardians of the Galaxy Vol. 2</h5>
<div class="container1">
  <img src="images/guardian2%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="guardian2.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Guardians of the Galaxy</h5>
<div class="container1">
  <img src="images/guardian%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="guardian.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Captain America: Winter Soldier</h5>
<div class="container1">
  <img src="images/winter%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="winter%20soldier.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Thor- The Dark World</h5>
<div class="container1">
  <img src="images/thor2%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="thor%20the%20dark%20world.html">Book</a>
    </div>
  </div>
</div>
  </div>
    
    
<div class="row1">
  <div class="column1">
    <h5 align="left">Iron Man 3</h5>
<div class="container1">
  <img src="images/iron3%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="iron%20man%203.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">The Avengers</h5>
<div class="container1">
  <img src="images/avengers1%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="the%20avengers.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Thor</h5>
<div class="container1">
  <img src="images/thor1%20logo.jpeg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="thor.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">The Incredible Hulk</h5>
<div class="container1">
  <img src="images/hulk%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="hulk.html">Book</a>
    </div>
  </div>
</div>
  </div>
    
    
    <div class="row1">
  <div class="column1">
    <h5 align="left">Iron Man 2</h5>
<div class="container1">
  <img src="images/iron%202%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="iron%20man%202.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Iron Man</h5>
<div class="container1">
  <img src="images/iron%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="iron%20man.html">Book</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Captain America The First Avenger</h5>
<div class="container1">
  <img src="images/captain%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="captain%20america.html">Book</a>
    </div>
  </div>
</div>
  </div>
      
</div>

<div id="myModal1" class="modal1">
  <span class="close cursor1" onclick="closeModal()">&times;</span>
  <div class="modal-content1">

    <div class="mySlides1">
      <div class="numbertext1">1 / 4</div>
      <img src="img_nature_wide.jpg" style="width:100%">
    </div>

    <div class="mySlides1">
      <div class="numbertext1">2 / 4</div>
      <img src="img_snow_wide.jpg" style="width:100%">
    </div>

    <div class="mySlides1">
      <div class="numbertext1">3 / 4</div>
      <img src="img_mountains_wide.jpg" style="width:100%">
    </div>
    
    <div class="mySlides1">
      <div class="numbertext1">4 / 4</div>
      <img src="img_lights_wide.jpg" style="width:100%">
    </div>
    
    <a class="prev1" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next1" onclick="plusSlides(1)">&#10095;</a>

    <div class="caption-container1">
      <p id="caption1"></p>
    </div>


    <div class="column1">
      <img class="demo cursor1" src="img_nature_wide.jpg" style="width:100%" onclick="currentSlide(1)" alt="Nature and sunrise">
    </div>
    <div class="column1">
      <img class="demo cursor1" src="img_snow_wide.jpg" style="width:100%" onclick="currentSlide(2)" alt="Snow">
    </div>
    <div class="column1">
      <img class="demo cursor1" src="img_mountains_wide.jpg" style="width:100%" onclick="currentSlide(3)" alt="Mountains and fjords">
    </div>
    <div class="column1">
      <img class="demo cursor1" src="img_lights_wide.jpg" style="width:100%" onclick="currentSlide(4)" alt="Northern Lights">
    </div>
  </div>
</div>    

  
  
  
  
  </div>

<!-- Container (TOUR Section) -->
<div id="comingsoon" class="bg-1">
    <h3>Upcoming Movies</h3><br>
    
    <div class="row1">
  <div class="column1">
    <h5 align="left">Ant Man and The Wasp</h5>
<div class="container1">
  <img src="images/ant%20wasp.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="#">Watch Trailer</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Captain Marvel</h5>
<div class="container1">
  <img src="images/marvel.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="#">Watch Trailer</a>
    </div>
  </div>
</div>
  </div>
  <div class="column1">
    <h5 align="left">Avengers Infinity War 2</h5>
<div class="container1">
  <img src="images/infi%202%20logo.jpg" alt="Avatar" class="image1" style="width:100%">
  <div class="middle1">
    <div class="text1"><a href="#">Watch Trailer</a>
    </div>
  </div>
</div>
  </div>  
</div>
    
<!-- NAVBAR OUTPUT ENDS-->    
    
    
    <center>
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
