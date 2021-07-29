import { TutorService } from './../tutor.service';
import { Component, OnInit,ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-admin-student-request-list',
  templateUrl: './admin-student-request-list.component.html',
  styleUrls: ['./admin-student-request-list.component.css']
})
export class AdminStudentRequestListComponent implements OnInit {

  students: any = [];
  displayedColumns: string[] = ['Name', 'Email', 'Contact', 'Actions'];
   studentdata!: MatTableDataSource<any>;
  @ViewChild(MatSort)
  sort!: MatSort;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  searchKey: string = "";
  constructor(private tutorService:TutorService) { }

  ngOnInit(): void {
    this.getStudentRequests();
  }

  getStudentRequests() {
this.tutorService.getStudentRequests().subscribe(data => {
  this.students=data;
  this.studentdata = new MatTableDataSource(this.students);
  this.studentdata.paginator = this.paginator;
  this.studentdata.sort = this.sort;
});
  }

acceptStudentRequest(id:number,student:any){
    this.tutorService.acceptStudentRequest(id,student).subscribe(data => {
      this.getStudentRequests();
    });
  }

   deleteStudentRequest(id:number){
     
    this.tutorService.admindeleteStudentRequest(id).subscribe(data => {
      this.getStudentRequests();
    });
  }
}
