import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { UserInfo } from './../user-info';
import { Router } from '@angular/router';
import { TutorService } from './../tutor.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-admin-tutor-list',
  templateUrl: './admin-tutor-list.component.html',
  styleUrls: ['./admin-tutor-list.component.css']
})
export class AdminTutorListComponent implements OnInit {


  userInfo:any=[];
  displayedColumns: string[] = ['sn','Name', 'Email', 'Mobile','Students','Technologies','Actions'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private tutorService:TutorService,private router:Router) { }

  ngOnInit(): void {
   this.getTutors();
  }


  getTutors(){
    this.tutorService. getTutorList().subscribe(data => {
      this.userInfo=data;

      this.userInfo=new MatTableDataSource(this.userInfo);
     this.userInfo.paginator=this.paginator;
     this.userInfo.sort=this.sort;
    });
  }


  deleteTutor(userId : any ){
  
    this.tutorService.deleteTutor(userId).subscribe(data => {
      this.getTutors();
    })
  }

  viewStudentList(user:UserInfo)
  {
     this.router.navigate(['/sidebar/admin-tutor-student-list',user.userId]);
  }
  viewTrainingList(user:any)
  {
       this.router.navigate(['/sidebar/admin-tutor-training-list',user.userId]);
  }


}
