<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="views/css/home.css">
    <link rel="stylesheet" href="views/css/headerhome.css">
    <link rel="icon" href="demo_icon.gif" type="image/gif" sizes="16x16">
</head>
<style>

@charset "ISO-8859-1";
.row {
  width: 100%;
  padding-left: 10%;
  padding-right: 10%;
  background-color: whitesmoke;
}

img {
  width: 100%;
  height: 100%;
  margin: auto;
}

.card h-100:hover {
          box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}@charset "ISO-8859-1";
* {
  margin: 0;
  padding: 0;
}

#navbarNav {
  -webkit-box-pack: end;
      -ms-flex-pack: end;
          justify-content: flex-end;
}

.header {
  min-height: 500px;
  width: 100%;
    background-image: linear-gradient(rgba(4, 9, 30, 0.7)), src('onlinetutor.jpeg');
  background-position: center;
  background-size: cover;
  position: relative;
}

.text-box {
  width: 100%;
  color: #fff;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
  text-align: center;
}

.text-box h1 {
  font-size: 54px;
}

.text-box p {
  margin: 10px 0 40px;
  font-size: 14px;
  color: #fff;
}

.visit-lnk {
  display: inline-block;
  text-decoration: none;
  color: #fff;
  border: 1px solid #fff;
  padding: 12px 34px;
  font-size: 13px;
  background: transparent;
  position: relative;
  cursor: pointer;
}

.collapse ul li :hover {
  background: black;
  -webkit-transition: 0.5s;
  transition: 0.5s;
 
}

.visit-lnk:hover {
  border: 1px solid #f44336;
  background: #f44336;
  -webkit-transition: 1s;
  transition: 1s;
   color:#fff;
}

nav.fa {
  display: none;
}

@media (max-width: 700px) {
  .text-box h1 {
    font-size: 20px;
  }
  .nav-links ul li {
    display: block;
  }
  .nav-links {
    position: absolute;
    background: #f44336;
    height: 100vh;
    width: 200px;
    top: 0;
    right: -200px;
    text-align: left;
    z-index: 2;
    -webkit-transition: 1s;
    transition: 1s;
  }
  nav.fa {
    display: block;
    color: #fff;
    margin: 10px;
    font-size: 22px;
    cursor: pointer;
  }
  .nav-links ul {
    padding: 30px;
  }
}

.card {
  width: 80%;
  margin: auto;
  text-align: center;
  padding-top: 60px;
}

h2 {
  font-size: 36px;
  font-weight: 600;
}

p {
  font-size: 14px;
  font-weight: 300;
  line-height: 22px;
  padding: 10px;
}

.row {
  margin-top: 5%;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
      -ms-flex-pack: justify;
          justify-content: space-between;
}

</style>
<body>
    <section class="header " >
        <nav class="navbar navbar-expand-sm navbar-dark" style="background-color:gray;">

            <a href="../html/home.html" class="navbar-brand-mb-0 h1 outline-none">


            </a>
            <button type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" class="navbar-toggler" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
            <div class="collapse navbar-collapse" id="navbarNav">
               </ul>
                    <li class="nav-item active" style="list-style:none">
                        <a href="Register.jsp" class="btn btn-outline-info">
                SignUp
            </a>&nbsp;&nbsp;
                    </li>
                    <li class="nav-item active" style="list-style:none">
                        <a href="login.jsp" class="btn btn-info" style="margin-right:10px;color:#fff">
                Login
            </a>
                    </li>
                </ul>

            </div>
        </nav>
        <div class="text-box">
          <img src="https://www.henryharvin.com/blog/wp-content/uploads/2020/07/16x9-Large.jpg" style="height:70vh;width:200vh;padding-top:70px;">
        </div>
    </section>

    <div class="row row-cols-1 row-cols-md-3 g-3">
        <div class="col">
            <div class="card h-100">
                <img src="https://miro.medium.com/max/8642/1*iIXOmGDzrtTJmdwbn7cGMw.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Java Programming for Complete Beginners</h5>
                    <p class="card-text">Learn Java Programming with 200+ examples. For Java Beginners. Learn Java Object Oriented Programming Now.
R</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">27 Jan 2021 </small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://1.bp.blogspot.com/-pdqcVeIQp64/XDX7TzdRdcI/AAAAAAAAM8E/ZmGuB6caZqIGmEflGHcj3zgXJJrmqRLdgCLcBGAs/w1200-h630-p-k-no-nu/Free%2BCourses%2Bto%2Blearn%2BJavaScript.jpg
" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">The Complete JavaScript Course 2021: From Zero to Expert!</h5>
                    <p class="card-text">The modern JavaScript course for everyone! Master JavaScript with projects, challenges and theory. Many courses in one!(..)</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">3rd Apr 2021</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://1.bp.blogspot.com/-rW-NHfrk7Vw/X9yreK_mc-I/AAAAAAAABRQ/Xz9hPD7TnwAmocM3qSWIHnQADIgc29qRQCLcBGAsYHQ/s690/GE8151-Problem%2BSolving-and-Python-Programming-%2528PSPP%2529-MCQ-PDF-Material-with-Answers.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                <h5 class="card-title">The Python Mega Course: Build 10 Real World Applications
                </h5>
                    <p class="card-text">Go from zero to hero in Python in weeks! Learn Python the easy way by building real-life Python programs!
                    </p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">2 may 2021</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://miro.medium.com/max/1200/1*pE2fOVDikEUwiQJlh4ggzg.jpeg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">The Complete 2021 Web Development Bootcamp
                    </h5>
                    <p class="card-text">Become a full-stack web developer with just one course. HTML, CSS, Javascript, Node, React, MongoDB and more!</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">25 Apr 2021</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="
https://www.drupal.org/files/project-images/bootstrap-stack.png" class="card-img-top" alt="..." width="100px">
                <div class="card-body">
                    <h5 class="card-title">Bootstrap & jQuery - Certification Course for Beginners
                    </h5>
                    <p class="card-text">Learn to Create fully Animated, Interactive, Mobile Responsive Web Pages using Bootstrap & jQuery Library.
Rating:</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">20 August 2020</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://1.bp.blogspot.com/-nxid6Xlc4tk/WZdTjNSFYeI/AAAAAAAAFnk/DAH_PDBuU2AnHjF7eEf6JzoKO9yXguUhACLcBGAs/s1600/Top%2B10%2Bvideo%2Btutorial%2Bto%2Blearn%2BC%2BProgramming.jpg" class="card-img-top" alt="..." width="100px">
                <div class="card-body">
                <h5 class="card-title">C Programming For Beginners - Master the C Language
                </h5>
                    <p class="card-text">C Programming will increase career options. Become a better dev in other languages by learning C. Pointers explained</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">9 Apr 2021</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://www.tutorialrepublic.com/lib/images/sql-illustration.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">The Complete Oracle SQL Bootcamp (2021)
                    </h5>
                    <p class="card-text">Become an In-demand SQL Professional & Pass Oracle SQL 1Z0-071 (OCA) Certification Exam Confidently!</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">20 August 2019</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPJ0WXstey5lCVFpLUWALEcXcGJQc4VY1Zn7jquD9fpoWvB7YuAbB3vwzWE0ahEQ2uozw&usqp=CAU" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Spring Boot Fundamentals with Unit Testing (MockMVC/Mockito)
                    </h5>
                    <p class="card-text">Develop backend Rest Services/API from scratch and build Unit Tests & Integration Tests using Spring Boot
                    </p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">20 August 2019</small>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <img src="https://www.freecodecamp.org/news/content/images/2020/04/Copy-of-Copy-of-Travel-Photography-1.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">The Complete Angular Course: Beginner to Advanced
                    </h5>
                    <p class="card-text">The most comprehensive Angular 4 (Angular 2+) course. Build a real e-commerce app with Angular, Firebase and Bootstrap 4</p>
                </div>
                <div class="card-footer">
                    <a href="login.jsp" class="btn btn-primary">View More</a>
                    <small class="text-muted">20 August 2019</small>
                </div>
            </div>
        </div>
    </div>

    <embed type="text/html" src="footer.jsp" width="100%" height="925px">

</body>