import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { UserInfo } from './../user-info';
import { TutorService } from './../tutor.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-tutor-students',
  templateUrl: './tutor-students.component.html',
  styleUrls: ['./tutor-students.component.css']
})
export class TutorStudentsComponent implements OnInit {

  userDetails:any;
    userDet:any;
     profileData:UserInfo;
      userList:any=[];
      displayedColumns: string[] = ['sn','Name', 'Email', 'Mobile'];
    
  @ViewChild(MatSort) 
  sort!: MatSort; 
 
  @ViewChild(MatPaginator) 
  paginator!: MatPaginator;
  constructor(public tutorService:TutorService) { 
    this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo;
     this.studentList(this.profileData);
  }

  ngOnInit(): void {
  }

  studentList(userinfo:UserInfo)
  {
    this.tutorService.studentList(userinfo).subscribe((data:any)=>{
       
     this.userList=data.userList;
     
     this.userList=new MatTableDataSource(this.userList);
     this.userList.paginator=this.paginator;
     this.userList.sort=this.sort;
},
    err => {
        console.log(err);
      }
    )

  }
}
