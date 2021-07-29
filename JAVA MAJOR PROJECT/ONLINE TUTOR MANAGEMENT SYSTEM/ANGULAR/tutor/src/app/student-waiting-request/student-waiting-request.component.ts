import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { UserInfo } from './../user-info';
import { Router } from '@angular/router';
import { TutorService } from './../tutor.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-student-waiting-request',
  templateUrl: './student-waiting-request.component.html',
  styleUrls: ['./student-waiting-request.component.css']
})
export class StudentWaitingRequestComponent implements OnInit {

  userDetails:any;
    userDet:any;
    userList:any=[];
    trainingList:any=[];
    requestList:any=[];
    profileData:UserInfo;
    req:any=[];
    merged:any=[];  
    displayedColumns: string[] = ['sn','TrainingName', 'TutorName', 'RequestDate'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private tutorService:TutorService,private router:Router) {
      this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo;
     this.waitingRequestList(this.profileData); 
   
   }

   waitingRequestList(userinfo:UserInfo)
   {
     this.tutorService.waitingRequestList(userinfo).subscribe((data:any)=>{
       
     this.userList=data.userList;
     this.trainingList=data.trainingList;
     this.requestList=data.requestList;
    //  console.log(this.user);
    for (var i = 0, len = this.trainingList.length; i < len; i++) {
  delete this.trainingList[i].tutorId;
         }
       if(this.requestList!=null && this.userList!=null && this.trainingList!=null){
  this.req=this.requestList.map((itm:any) => ({...itm, ...this.trainingList.find((elm:any) => 
    elm.trainingInfoId == itm.trainingInfoId)}))
  this.merged=this.req.map((itm:any) => ({...itm, ...this.userList.find((elm:any) => 
    elm.userId == itm.tutorId)}))
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


}
