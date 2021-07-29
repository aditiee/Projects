import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { Login } from './../login';
import { Router } from '@angular/router';
import { AuthService } from './../auth.service';
import { Component, OnInit ,ViewChild} from '@angular/core';
import { map } from 'rxjs/operators';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(public auth: AuthService, private router: Router, private breakpointObserver: BreakpointObserver) { }
  userDetails:any = sessionStorage.getItem('token');
  userDet:any=JSON.parse(this.userDetails);


    logout() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

    isAdmin() {
    const user: Login = this.userDet;
    if (user && user.role===1) {
      return true;
    } else {
      return false;
    }
  }

    isStudent() {
    const user: Login =this.userDet;
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
    const user:  Login = this.userDet;
    if (user && user.statusCode === 200) {
     
      return true;
    } else {
      return false;
    }
  }
  ngOnInit(): void {
  }

}
