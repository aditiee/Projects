import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TrainingRequest } from './../training-request';
import { UserInfo } from './../user-info';
import { TutorService } from './../tutor.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { map } from 'rxjs/operators';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-tutor-students-request',
  templateUrl: './tutor-students-request.component.html',
  styleUrls: ['./tutor-students-request.component.css']
})
export class TutorStudentsRequestComponent implements OnInit {
   userDetails:any;
    userDet:any;
    userList:any=[];
    trainingList:any=[];
    requestList:any=[];
    profileData:UserInfo;
    req:any=[];
    merged:any=[];
    
    displayedColumns: string[] = ['sn','Name','TrainingName', 'RequestDate','Action'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(public tutorService:TutorService) {
     this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo;
     this.studentRequestList(this.profileData); 
   
   }

   studentRequestList(userinfo:UserInfo)
   {
     this.tutorService.studentRequestList(userinfo).subscribe((data:any)=>{
       
     this.userList=data.userList;
     this.trainingList=data.trainingList;
     this.requestList=data.requestList;
    //  console.log(this.user);
     for (var i = 0, len = this.userList.length; i < len; i++) {
  delete this.userList[i].createdOn;
     }
 for (var i = 0, len = this.trainingList.length; i < len; i++) {
  delete this.trainingList[i].createdOn;
 }
       if(this.requestList!=null && this.userList!=null && this.userList!=null){
  this.req=this.requestList.map((itm:any) => ({...itm, ...this.trainingList.find((elm:any) => 
    elm.trainingInfoId == itm.trainingInfoId)}))
  this.merged=this.req.map((itm:any) => ({...itm, ...this.userList.find((elm:any) => 
    elm.userId == itm.raisedBy)}))
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
  


approveRequest(request:TrainingRequest)
{
this.tutorService.approveStudentRequest(request).subscribe(res=>{
  this.studentRequestList(this.profileData);
},
err=>{
  console.log(err);
}
);
}

deleteRequest(request:number)
{
    this.tutorService.deleteStudentRequest(request).subscribe(res=>{
      this.studentRequestList(this.profileData);
    },
  err=>{
    console.log(err);
  }
  )
}
}
