import { UserInfo } from './../user-info';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-training',
  templateUrl: './add-training.component.html',
  styleUrls: ['./add-training.component.css']
})
export class AddTrainingComponent implements OnInit {

  subjectList:any=[];
  response:any;
   userDetails:any;
  userDet:any;
  profiledata:UserInfo 
  constructor(private tutorService:TutorService,private router:Router) {
    this.userDetails= sessionStorage.getItem('token');
  this.userDet=JSON.parse(this.userDetails);
  this.profiledata=this.userDet.userinfo;

   }

  getSubject(){
    return this.tutorService.subjectList().subscribe(res=>{
      this.subjectList=res.subjectList;
      
    });
    }
  ngOnInit(): void {
   
    this.getSubject();
  }

 addNewTraining(addTraining:NgForm) {
    console.log(addTraining.value);
    this.tutorService.addTraining(addTraining.value).subscribe(res => {
      this.response = res;
      addTraining.reset();
      this.router.navigate([`sidebar/tutor-trainings`]);
    },
      err => {
        console.log(err);
      });
  }
}
