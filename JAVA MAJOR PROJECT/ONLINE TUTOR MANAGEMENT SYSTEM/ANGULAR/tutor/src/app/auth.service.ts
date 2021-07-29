import { UserInfo } from './user-info';
import { Login } from './login';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) { }

    login(data:any): Observable<Login> {
    
    return this.http.post<Login>(
      'http://localhost:8080/userLogin', data
    );
  }

}
