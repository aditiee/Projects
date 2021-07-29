import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';
import { Login } from './../login';
import { Router } from '@angular/router';
import { AuthService } from './../auth.service';
import { Observable } from 'rxjs';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { OwlOptions } from 'ngx-owl-carousel-o';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    userDetails:any = sessionStorage.getItem('token');
    userDet:any=JSON.parse(this.userDetails);
     userList:any=[];
    trainingList:any=[];
    subjectList:any=[];
    req:any=[];
    merged:any=[];
  constructor(public auth: AuthService, private router: Router, private breakpointObserver: BreakpointObserver,public tutorService:TutorService) { 
    this.StudentTutorList();
  }

  ngOnInit(): void {
  }

   StudentTutorList()
 {
    this.tutorService.studentTutorList().subscribe((data:any)=>{
       
     this.userList=data.userList;
     this.trainingList=data.trainingList;
     this.subjectList=data.subjectList;
     for (var i = 0, len = this.userList.length; i < len; i++) {
  delete this.userList[i].createdOn;
 }
     for (var i = 0, len = this.subjectList.length; i < len; i++) {
  delete this.subjectList[i].createdOn;
 }
console.log(this.subjectList);
    //  console.log(this.user);
       if(this.trainingList!=null && this.userList!=null && this.subjectList!=null){
  this.req=this.trainingList.map((itm:any) => ({...itm, ...this.userList.find((elm:any) => 
    elm.userId == itm.tutorId)}))
  this.merged=this.req.map((itm:any) => ({...itm, ...this.subjectList.find((elm:any) => 
     itm.subjectId==elm.subjectId)}))
       }
  console.log(this.merged);
},
    err => {
        console.log(err);
      }
    )
 }

    isAdmin() {
    const user: Login = this.userDet;
    if (user && user.role === 1) {
      return true;
    } else {
      return false;
    }
  }

    isStudent() {
    const user: Login = this.userDet;
    if (user && user.role === 3) {
      return true;
    } else {
      return false;
    }
  }
  
  isTutor() {
    const user: Login = this.userDet;
    if (user && user.role === 2) {
      return true;
    } else {
      return false;
    }
  }

    isLoggedIn(): boolean {
    const user: Login = this.userDet;
    if (user && user.statusCode === 200) {
      return true;
    } else {
      return false;
    }
  }

  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navSpeed: 200,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 3
      },
      940: {
        items: 4
      }
    },
    nav:true
  }
  
}
