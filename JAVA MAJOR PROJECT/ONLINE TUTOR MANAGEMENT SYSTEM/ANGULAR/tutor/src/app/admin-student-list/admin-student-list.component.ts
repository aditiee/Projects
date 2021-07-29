import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TutorService } from './../tutor.service';
import { Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-admin-student-list',
  templateUrl: './admin-student-list.component.html',
  styleUrls: ['./admin-student-list.component.css']
})
export class AdminStudentListComponent implements OnInit {

  userInfo:any;
   displayedColumns: string[] = ['sn','Name', 'Email', 'Mobile','Actions'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private tutorService:TutorService,private router:Router) { }

  ngOnInit(): void {
    this.getStudents();
  }


  private getStudents(){
    this.tutorService.getStudentList().subscribe(data => {
      this.userInfo=data;

      this.userInfo=new MatTableDataSource(this.userInfo);
     this.userInfo.paginator=this.paginator;
     this.userInfo.sort=this.sort;
    });
  }


  deleteStudent(userId : any ){
  
    this.tutorService.deleteStudent(userId).subscribe(data => {
      console.log(data);
      this.getStudents();
    })
  }
}
