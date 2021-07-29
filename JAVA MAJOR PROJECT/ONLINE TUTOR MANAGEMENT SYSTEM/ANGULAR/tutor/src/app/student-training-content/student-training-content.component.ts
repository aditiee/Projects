import { UserInfo } from './../user-info';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TutorService } from './../tutor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { saveAs } from 'file-saver';
@Component({
  selector: 'app-student-training-content',
  templateUrl: './student-training-content.component.html',
  styleUrls: ['./student-training-content.component.css']
})
export class StudentTrainingContentComponent implements OnInit {

  contentList:any=[];
  id:any;
  userDetails:any;
    userDet:any;
   profileData:any;
   tutorId:any;
displayedColumns: string[] = ['sn','ContentName', 'UploadedOn','Action'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private tutorService:TutorService,private router:Router,private _activeRoute:ActivatedRoute) {
    this._activeRoute.params.subscribe(res=>{
      this.id=res.id;
    })
    this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo.userId;
    this.getAllContents();

   }


     getAllContents()
  {
   this.tutorService.singleTrainingData(this.id).subscribe(resp=>{
        this.contentList=resp.contentList;
        this.tutorId=this.contentList[0].tutorId;
        this.contentList=new MatTableDataSource(this.contentList);
     this.contentList.paginator=this.paginator;
     this.contentList.sort=this.sort;
   
   });
    
   }
    
   downloadContent(file: any) { 
      
    this.tutorService.downloadContent(file.content,file.trainingContentId,this.id,this.tutorId,this.profileData).subscribe((blob: any) => { 
      console.log(blob); 
      saveAs(blob, file.content); 
 
      window.location.reload(); 
    }); 
  }
  ngOnInit(): void {
  }

}
