import { TrainingRequest } from './../training-request';
import { UserInfo } from './../user-info';
import { Router, ActivatedRoute } from '@angular/router';
import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-training-request',
  templateUrl: './student-training-request.component.html',
  styleUrls: ['./student-training-request.component.css']
})
export class StudentTrainingRequestComponent implements OnInit {
  traininginfo:any=[];
 
userDetails:any;
    userDet:any;
     raisedBy:number;
     isFollow:boolean=false;
   request=<TrainingRequest>{};
  constructor(private tutorService:TutorService,private router:Router,private _activeRoute:ActivatedRoute) { 
      this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.raisedBy=this.userDet.userinfo.userId;
  
    this._activeRoute.params.subscribe(res=>{
      this.traininginfo=res;
      
    })
  }

  ngOnInit(): void {
  }

  sendRequest(training:any)
  {
     this.request.trainingInfoId=training.trainingInfoId;
     this.request.tutorId=training.tutorId;
     this.request.raisedBy=this.raisedBy;
      this.tutorService.sendRequest(this.request).subscribe(res=>{
      
      },
       err =>{
         console.log(err);
       }
       );
  }
    
    
}
