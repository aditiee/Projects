import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { TrainingInfo } from './../training-info';
import { UserInfo } from './../user-info';
import { TutorService } from './../tutor.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { map } from 'rxjs/operators';
@Component({
  selector: 'app-tutor-trainings',
  templateUrl: './tutor-trainings.component.html',
  styleUrls: ['./tutor-trainings.component.css']
})
export class TutorTrainingsComponent implements OnInit {
userDetails:any;
    userDet:any;
    profileData:UserInfo;
    trainingList:any=[];
    subjectList:any=[];
    trainings:any=[];
  displayedColumns: string[] = ['sn','TrainingName', 'SubjectName', 'Date Created','Action'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(public tutorService:TutorService,private router:Router) { 

    this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo;
     
  }

  tutorTrainingList(userinfo:UserInfo)
  {
    this.tutorService.tutorTrainingList(userinfo).subscribe((data:any)=>{
      this.trainingList=data.trainingList;
      this.subjectList=data.subjectList;
       for (var i = 0, len = this.subjectList.length; i < len; i++) {
  delete this.subjectList[i].createdOn;
       }

         if(this.trainingList!=null && this.subjectList!=null){
  this.trainings=this.trainingList.map((itm:any) => ({...itm, ...this.subjectList.find((elm:any) => 
    elm.subjectId == itm.subjectId)}))
       }

     this.trainings=new MatTableDataSource(this.trainings);
     this.trainings.paginator=this.paginator;
     this.trainings.sort=this.sort;
    });
  }

  loadContents(training:TrainingInfo)
  {
      // this.tutorService.singleTrainingData(training);
      this.router.navigate(['/sidebar/training-contents',training.trainingInfoId]);
  }


  ngOnInit(): void {
    this.tutorTrainingList(this.profileData);
  }

  deleteTraining(training:TrainingInfo)
  {
    
    this.tutorService.deleteTraining(training.trainingInfoId).subscribe(res=>{
      this.tutorTrainingList(this.profileData);
    })
  }
}
