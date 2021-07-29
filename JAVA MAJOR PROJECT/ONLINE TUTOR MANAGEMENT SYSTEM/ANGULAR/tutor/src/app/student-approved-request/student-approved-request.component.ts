import { TrainingRequest } from './../training-request';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TrainingInfo } from './../training-info';
import { Router } from '@angular/router';
import { TutorService } from './../tutor.service';
import { UserInfo } from './../user-info';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-student-approved-request',
  templateUrl: './student-approved-request.component.html',
  styleUrls: ['./student-approved-request.component.css']
})
export class StudentApprovedRequestComponent implements OnInit {

   userDetails:any;
    userDet:any;
    userList:any=[];
    trainingList:any=[];
    requestList:any=[];
    profileData:UserInfo;
    req:any=[];
    merged:any=[];

displayedColumns: string[] = ['sn','TrainingName', 'TutorName', 'RequestDate','Action'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private tutorService:TutorService,private router:Router) {
    this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo;
     this.approvedRequestList(this.profileData);
   }

   approvedRequestList(userinfo:UserInfo)
   {
     this.tutorService.approvedRequestList(userinfo).subscribe((data:any)=>{
       
     this.userList=data.userList;
     this.trainingList=data.trainingList;
     this.requestList=data.requestList;

     for (var i = 0, len = this.trainingList.length; i < len; i++) {
  delete this.trainingList[i].tutorId;
         }
    //  console.log(this.user);
       if(this.requestList!=null && this.userList!=null && this.userList!=null){
  this.req=this.requestList.map((itm:any) => ({...itm, ...this.trainingList.find((elm:any) => 
    elm.trainingInfoId == itm.trainingInfoId)}))
  this.merged=this.req.map((itm:any) => ({...itm, ...this.userList.find((elm:any) => 
    itm.tutorId == elm.userId)}))
       }
   this.merged=new MatTableDataSource(this.merged);
     this.merged.paginator=this.paginator;
     this.merged.sort=this.sort;
},
    err => {
        console.log(err);
      }
    )
   }

  ngOnInit(): void {
  }

   loadContents(training:TrainingInfo)
  {
      // this.tutorService.singleTrainingData(training);
      this.router.navigate(['/sidebar/student-training-contents',training.trainingInfoId]);
  }

  feedback(training: TrainingRequest) { 
    console.log("iddd " + training.tutorId); 
    var tutorId = JSON.stringify(training); 
    console.log("tutorId" + tutorId) 
    sessionStorage.setItem('tutorId', tutorId); 
    this.router.navigate(['/sidebar/sendFeedback']); 
  }
}
