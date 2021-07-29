<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
      <title>Footer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel='shortcut icon' type='image/x-icon' href='/favicon.ico' />
   <link rel="stylesheet" href="views/css/footer.css">
  </head>
  <style>
  @charset "ISO-8859-1";
.container {
  color: white;
}

.section-header h3 {
  font-size: 36px;
  color: #283d50;
  text-align: center;
  font-weight: 500;
  position: relative;
}

.section-header p {
  text-align: center;
  margin: auto;
  font-size: 15px;
  padding-bottom: 60px;
  color: #556877;
  width: 50%;
}

footer {
  width: 100%;
  background-image: -webkit-gradient(linear, left top, left bottom, from(rgba(4, 9, 30, 0.7))), url(../images/hm3.jpg);
  background-image: linear-gradient(rgba(4, 9, 30, 0.7)), url(../images/hm3.jpg);
  background-position: center;
  background-size: cover;
  position: relative;
}

.fadeInUp {
  -webkit-animation-name: fadeInUp;
          animation-name: fadeInUp;
}

#team .member {
  text-align: center;
  margin-bottom: 20px;
  position: relative;
  border-radius: 50%;
  overflow: hidden;
}

#team .member .member-info {
  opacity: 0;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  position: absolute;
  bottom: 0;
  top: 0;
  left: 0;
  right: 0;
  -webkit-transition: all 0.2s;
  transition: all 0.2s;
}

#team .member .member-info-content {
  margin-top: 50px;
  -webkit-transition: margin 0.2s;
  transition: margin 0.2s;
}

#team .member:hover .member-info {
  background: rgba(0, 62, 128, 0.7);
  opacity: 1;
  -webkit-transition: 0.4s;
  transition: 0.4s;
  height: 200px;
  width: 200px;
  border-radius: 50%;
}

.member img {
  height: 200px;
  width: 200px;
  border-radius: 50%;
}

#team .member h4 {
  font-weight: 700;
  margin-bottom: 2px;
  font-size: 18px;
  color: #fff;
}

#team .member span {
  font-style: italic;
  display: block;
  font-size: 13px;
  color: #fff;
}

#team .member .social a {
  -webkit-transition: none;
  transition: none;
  color: #fff;
}
  
  </style>
<body>
    <!-- Footer -->
<footer class="text-center text-lg-start ">
  <section id="team">
    <div class="container">
        <div class="section-header">
            <h3>Team</h3>
            <p>Meet our team</p>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-6 wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/rAInTHU.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Abhishek Mande</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/TCoUOUM.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Azharuddin Jalgaaonkar</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
              <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/TCoUOUM.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Hardik Mehta</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
              <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/TCoUOUM.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Joshua Nandrekar</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/rAInTHU.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Aditi Gudadhe</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
              <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/rAInTHU.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Parajakta Bidwe</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
                <div class="member"> <img src="https://i.imgur.com/TCoUOUM.jpg" class="img-fluid" alt="">
                    <div class="member-info">
                        <div class="member-info-content">
                            <h4>Priya Sakpal</h4> <span>Software Engineer</span>
                            <div class="social"> <a href=""><em class="fa fa-twitter"></em></a> <a href=""><em class="fa fa-facebook"></em></a> <a href=""><em class="fa fa-google-plus"></em></a> <a href=""><em class="fa fa-linkedin"></em></a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  <!-- Section: Links  -->
  <section class="">
    <div class="container text-center text-md-start mt-5">
      <!-- Grid row -->
      <div class="row mt-3">
        <!-- Grid column -->
        
        <!-- Grid column -->

        <!-- Grid column -->
        
        <!-- Grid column -->
        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">
            Useful links
          </h6>
          <a href="RegistrationPage.jsp" class="text-reset">Register</a>
          </p>
          <p>
            <a href="" class="text-reset">Login</a>
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">
            Contact
          </h6>
          <p><em class="fas fa-home me-3"></em> Pune, Maharashtra -India</p>
          <p>
            <em class="fas fa-envelope me-3"></em>
            group10@cybage.com
          </p>
          <p><em class="fas fa-phone me-3"></em> + 01 234 567 88</p>
          <p><em class="fas fa-print me-3"></em> + 01 234 567 89</p>
        </div>
        <!-- Grid column -->
      </div>
      <!-- Grid row -->
    </div>
  </section>
  <!-- Section: Links  -->

  <!-- Copyright -->
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
    © 2021 Copyright:
    <a class="text-reset fw-bold" href="../html/home.html">group10OnlineTutor.com</a>
  </div>
  <!-- Copyright -->
</footer>
<!-- Footer -->
</body>