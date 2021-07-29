import { Login } from './../login';
import { Router } from '@angular/router';
import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

   
  constructor(public auth: AuthService, private router: Router, private breakpointObserver: BreakpointObserver) { }

   userDetails:any = sessionStorage.getItem('token');
    userDet:any=JSON.parse(this.userDetails);
  ngOnInit(): void {
  }
 
    logout() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

    isAdmin() {
    const user: Login = this.userDet;
    if (user && user.role === 1) {
      return true;
    } else {
      return false;
    }
  }

    isStudent() {
    const user: Login = this.userDet;
    if (user && user.role === 3) {
      return true;
    } else {
      return false;
    }
  }

  isTutor() {
    const user: Login = this.userDet;
    if (user && user.role === 2) {
      return true;
    } else {
      return false;
    }
  }

    isLoggedIn(): boolean {
    const user: Login = this.userDet;
    if (user && user.statusCode === 200) {
      return true;
    } else {
      return false;
    }
  }

}
