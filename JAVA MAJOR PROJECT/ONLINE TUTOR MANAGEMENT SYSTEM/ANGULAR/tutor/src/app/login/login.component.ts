import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
error:any = null;

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

   loginUser(loginForm: NgForm) {
    
    this.error = null;
    this.auth.login(loginForm.value).subscribe(
      response => {
        console.log('error message', response.description);
        this.error = response.description;
        loginForm.reset();
        if (response.statusCode === 200 && response.role===1) {
          console.log('inside admin');
          const user = JSON.stringify(response);
          sessionStorage.setItem('token', user);
          this.router.navigateByUrl('/sidebar/admin-student-request-list');
        } else if (response.statusCode === 200 && response.role===2) {
          console.log('inside tutor');
          const user = JSON.stringify(response);
          sessionStorage.setItem('token', user);
          this.router.navigateByUrl('/sidebar/tutor-students-request');
        } else if (response.statusCode === 200 && response.role===3) {
          console.log('inside student');
          const user = JSON.stringify(response);
          sessionStorage.setItem('token', user);
           this.router.navigateByUrl('/sidebar/student-tutor-list');
        }

      },
      err => {
        console.log(err);
       this.error = err.error.error.message;
        loginForm.reset();
      }
    );
  }
}
