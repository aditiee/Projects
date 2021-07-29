import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { TutorService } from './../tutor.service';
import { Component, OnInit, ViewChild } from '@angular/core';

import {ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-training-contents',
  templateUrl: './training-contents.component.html',
  styleUrls: ['./training-contents.component.css']
})
export class TrainingContentsComponent implements OnInit {

  contentList:any=[];
  id:any;
   displayedColumns: string[] = ['sn','ContentName', 'UploadedOn', 'Action'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private tutorService:TutorService,private router:Router,private _activeRoute:ActivatedRoute) { 
     
    this._activeRoute.params.subscribe(res=>{
      this.id=res.id;
      
    })
    this.getAllContents();
  }

  ngOnInit(): void {
  }

  getAllContents()
  {
   this.tutorService.singleTrainingData(this.id).subscribe(resp=>{
        this.contentList=resp.contentList;



         this.contentList=new MatTableDataSource(this.contentList);
     this.contentList.paginator=this.paginator;
     this.contentList.sort=this.sort;
       
   });
      
   }
  deleteContent(contentId:number)
  {
    this.tutorService.deleteContent(contentId).subscribe(res=>{
     this.getAllContents();
    },
  err=>{
    console.log(err);
  }
  );
}

upload(id:any)
{
  
  this.router.navigate([`sidebar/uploadcontent`,this.id]);
}
}

