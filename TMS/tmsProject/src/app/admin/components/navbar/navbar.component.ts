import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  adminNav: any[] = [];

  constructor() { }

  ngOnInit(): void {
    this.adminNav = [
      {
        name: 'Pending Tutors',
        route: '/admin/pendingtutor',
        data: null,
      },
      {
        name: 'Pending student',
        route: '/admin/pendingstudent',
        data: null,
      },
      {
        name:'Delete Tutor',
        route:'/admin/deletetutor',
        data:null,
      },
      {
        name:'Delete Student',
        route:'/admin/deletestudent',
        data:null,
      },
      {
        name: 'Logout',
        route: '',
        data: null,
      }
    ];
  }

}
