import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TrainingInfo } from './../training-info';
import { TutorService } from './../tutor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-admin-tutor-training-list',
  templateUrl: './admin-tutor-training-list.component.html',
  styleUrls: ['./admin-tutor-training-list.component.css']
})
export class AdminTutorTrainingListComponent implements OnInit {
id:any;
trainingList:any=[];
subjectList:any=[];
merged:any=[];

displayedColumns: string[] = ['sn','TrainingName', 'Subject', 'CreatedOn','Actions'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private _activeRoute:ActivatedRoute,private router:Router,private tutorService:TutorService) {

    this._activeRoute.params.subscribe(res=>{
      this.id=res.id;
    });
   this.getAllTrainings();

   }

  ngOnInit(): void {
  }


  getAllTrainings()
  {
    
    this.tutorService.getAllTrainingsByTutor(this.id).subscribe(resp=>{
        
        this.trainingList=resp.trainingList;
        this.subjectList=resp.subjectList;

         for (var i = 0, len = this.subjectList.length; i < len; i++) {
  delete this.subjectList[i].createdOn;
         }

         
         if(this.trainingList!=null && this.subjectList!=null){
  
  this.merged=this.trainingList.map((itm:any) => ({...itm, ...this.subjectList.find((elm:any) => 
    elm.subjectId ==itm.subjectId)}))
       }

       this.merged=new MatTableDataSource(this.merged);
     this.merged.paginator=this.paginator;
     this.merged.sort=this.sort;
   });
}

loadContent(training:TrainingInfo)
  {
      // this.tutorService.singleTrainingData(training);
      this.router.navigate(['/sidebar/student-training-contents',training.trainingInfoId]);
  }

}