import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload-status',
  templateUrl: './upload-status.component.html',
  styleUrls: ['./upload-status.component.css']
})
export class UploadStatusComponent implements OnInit {

  userList:any=[];
    trainingList:any=[];
    contentList:any=[];
    req:any=[];
    merged:any=[];
  constructor(public tutorService:TutorService) { }

  ngOnInit(): void {
   this.uploadStatusList();
  }

  uploadStatusList()
  {
    this.tutorService.getUploadStatus().subscribe((data:any)=>{
       
     this.userList=data.userList;
     this.trainingList=data.trainingList;
     this.contentList=data.contentList;
    
       if(this.contentList!=null && this.userList!=null && this.trainingList!=null){
  this.req=this.contentList.map((itm:any) => ({...itm, ...this.userList.find((elm:any) => 
    elm.userId == itm.tutorId)}))
  this.merged=this.req.map((itm:any) => ({...itm, ...this.trainingList.find((elm:any) => 
    elm.trainingInfoId == itm.trainingInfoId)}))
       }
  console.log(this.merged);
},
    err => {
        console.log(err);
      }
    )
  }
}
