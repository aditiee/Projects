import { UserInfo } from './../user-info';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-subject',
  templateUrl: './add-subject.component.html',
  styleUrls: ['./add-subject.component.css']
})
export class AddSubjectComponent implements OnInit {

   userDetails:any;
  userDet:any;
  profiledata:UserInfo;
  
  constructor(private tutorService:TutorService,private router :Router) {

    this.userDetails= sessionStorage.getItem('token');
  this.userDet=JSON.parse(this.userDetails);
  this.profiledata=this.userDet.userinfo;

   }

  ngOnInit(): void {
  }

  addNewSubject(addSubject:NgForm) {
    console.log(addSubject.value);
    this.tutorService.addSubject(addSubject.value).subscribe(res => {
      addSubject.reset();
      this.router.navigate([`sidebar/add-training`]);
    },
      err => {
        console.log(err);
      });
  }
}
