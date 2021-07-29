import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../services/student.service';

@Component({
  selector: 'app-studentnavbar',
  templateUrl: './studentnavbar.component.html',
  styleUrls: ['./studentnavbar.component.scss']
})
export class StudentnavbarComponent implements OnInit {

  studentNav: any[] = [];
  // searchQuery: any;

  constructor(private _studServ: StudentService) { }

  ngOnInit(): void {
    this.studentNav = [
      {
        name: 'search',
        route: '/student/search',
        data: null,
      },
      {
        name: 'View Tutors',
        route: 'student/viewtutor',
        data: null,
      },
      {
        name: 'Logout',
        route: '',
        data: null,
      }
    ];
  }
  search(){
    this._studServ.getTutorList().subscribe(res=> {
      console.log(res);
      
    })
  }
  

}
