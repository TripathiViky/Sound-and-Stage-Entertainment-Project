<%-- 
    Document   : menu
    Created on : 2 Jul, 2018, 12:08:17 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sound And Stage Entertainment</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/index-style.css">
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
            <li><a href="BookingForm1.jsp">Book Movies</a></li>
            <li><a href="Changepassword.jsp">Change Password</a></li>
            <li><a href="LogoutController">Logout</a></li> 
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="images/infinity1.jpg" alt="New York" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Avenger Infinity War</h3>
          <p>The Avenger and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.</p>
        </div>      
      </div>

      <div class="item">
        <img src="images/civil%20war.jpg" alt="Chicago" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Captain America: Civil War</h3>
          <p>Political involvement in the Avengers' activities causes a rift between Captain America and Iron Man.</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="images/dr%20strange.jpg" alt="Los Angeles" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Doctor Strange</h3>
          <p>While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<!-- Container (The Band Section) -->
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

<!-- Container (Contact Section) -->
<div id="contact" class="container" align="left">
  
<h3>Contact Us Via</h3>
<div id="insidecontact" align="left">
<a href="#" class="fa fa-facebook"></a>
<a href="#" class="fa fa-twitter"></a>
<a href="#" class="fa fa-google"></a>
</div>

    
</div>

<!-- Add Google Maps -->
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p> <b>Copyright @ 1995 Sound & Stage Entertainment &nbsp; All trademarks acknowledged.</b></p> 
</footer>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
});
</script>

</body>
</html>
