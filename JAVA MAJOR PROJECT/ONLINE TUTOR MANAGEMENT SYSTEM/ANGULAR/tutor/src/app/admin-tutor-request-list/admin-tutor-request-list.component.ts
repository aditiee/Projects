import { TutorService } from './../tutor.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-admin-tutor-request-list',
  templateUrl: './admin-tutor-request-list.component.html',
  styleUrls: ['./admin-tutor-request-list.component.css']
})
export class AdminTutorRequestListComponent implements OnInit {

    tutors:any = [];
  displayedColumns: string[] = ['Name', 'Email', 'Contact', 'Actions'];

  tutordata!: MatTableDataSource<any>;
  @ViewChild(MatSort)
  sort!: MatSort;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  searchKey: string = "";

  constructor(private tutorService:TutorService) { }

  ngOnInit(): void {
    this.getTutorRequests();
  }

  getTutorRequests() {
    this.tutorService.getTutorRequests().subscribe(data => {
      this.tutors = data;
      console.log(this.tutors);
      this.tutordata = new MatTableDataSource(this.tutors);
      this.tutordata.paginator = this.paginator;
      this.tutordata.sort = this.sort;
    });
  }

    acceptTutorRequest(id: number, tutor: any) {
    this.tutorService.acceptTutorRequest(id, tutor).subscribe(data => {
      this.getTutorRequests();
    });
  }

  deleteTutorRequest(id: number) {
    this.tutorService.deleteTutorRequest(id).subscribe(data => {
      this.getTutorRequests();
    });
  }
}
