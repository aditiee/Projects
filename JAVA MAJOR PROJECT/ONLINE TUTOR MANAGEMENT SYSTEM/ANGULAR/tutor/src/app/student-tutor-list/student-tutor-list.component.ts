import { Router } from '@angular/router';
import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-tutor-list',
  templateUrl: './student-tutor-list.component.html',
  styleUrls: ['./student-tutor-list.component.css']
})
export class StudentTutorListComponent implements OnInit {

  Search =" ";
   userList:any=[];
    trainingList:any=[];
    subjectList:any=[];
    req:any=[];
    merged:any=[];
   gridColumns=3;
  constructor(private tutorService:TutorService,private router:Router ) {
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


 loadTraining(training:any)
  {
      // this.tutorService.singleTrainingData(training);
      this.router.navigate(['/sidebar/student-training-request',training]);
  }
}