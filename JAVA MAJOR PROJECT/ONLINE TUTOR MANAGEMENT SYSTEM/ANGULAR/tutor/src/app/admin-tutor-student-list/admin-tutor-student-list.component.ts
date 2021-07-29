import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { TutorService } from './../tutor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-admin-tutor-student-list',
  templateUrl: './admin-tutor-student-list.component.html',
  styleUrls: ['./admin-tutor-student-list.component.css']
})
export class AdminTutorStudentListComponent implements OnInit {
  id:any;
  studentList:any=[];
  displayedColumns: string[] = ['sn','Name', 'Email', 'Mobile'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(private _activeRoute:ActivatedRoute,private router:Router,private tutorService:TutorService) {

    this._activeRoute.params.subscribe(res=>{
      this.id=res.id;
      
    });
    this.getAllStudents();

   }

  ngOnInit(): void {
  }

  getAllStudents()
  {
    
    this.tutorService.getAllStudentsByTutor(this.id).subscribe(resp=>{
        
        this.studentList=resp.userList;
        
        this.studentList=new MatTableDataSource(this.studentList);
     this.studentList.paginator=this.paginator;
     this.studentList.sort=this.sort;
   });
    
  }
  
}
