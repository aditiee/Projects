import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TutorService } from './../tutor.service';
import { UserInfo } from './../user-info';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-download-status',
  templateUrl: './download-status.component.html',
  styleUrls: ['./download-status.component.css']
})
export class DownloadStatusComponent implements OnInit {
  
  userDetails:any;
    userDet:any;
    userList:any=[];
    trainingList:any=[];
    contentList:any=[];
    mappingList:any=[];
    profileData:UserInfo;
    req:any=[];
    merged:any=[];
    finalstatus:any=[];
    displayedColumns: string[] = ['sn','ContentName', 'TrainingName', 'StudentName','DownloadedOn'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;

  constructor(public tutorService:TutorService) {
    this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo;
     this.downloadStatus(this.profileData);
   }

  ngOnInit(): void {
  }

  downloadStatus(userinfo:UserInfo)
  {
    this.tutorService.getDownloadStatus(userinfo).subscribe((data:any)=>{
       
     this.userList=data.userList;
     this.trainingList=data.trainingList;
     this.contentList=data.contentList;
     this.mappingList=data.mappingList;
    //  console.log(this.user);
    for (var i = 0, len = this.contentList.length; i < len; i++) {
  delete this.contentList[i].tutorId;
  delete this.contentList[i].trainingInfoId;
     }
 for (var i = 0, len = this.trainingList.length; i < len; i++) {
  delete this.trainingList[i].tutorId;
 }
       if(this.trainingList!=null && this.userList!=null && this.contentList!=null && this.mappingList!=null){
  this.req=this.mappingList.map((itm:any) => ({...itm, ...this.contentList.find((elm:any) => 
    elm.trainingContentId == itm.trainingContentId)}));
  this.merged=this.req.map((itm:any) => ({...itm, ...this.trainingList.find((elm:any) => 
    elm.trainingInfoId == itm.trainingInfoId)}));
    this.finalstatus=this.merged.map((itm:any) => ({...itm, ...this.userList.find((elm:any) => 
    elm.userId == itm.studentId)}))
       }
         this.finalstatus=new MatTableDataSource(this.finalstatus);
     this.finalstatus.paginator=this.paginator;
     this.finalstatus.sort=this.sort;

},
    err => {
        console.log(err);
      }
    )
  }
}
