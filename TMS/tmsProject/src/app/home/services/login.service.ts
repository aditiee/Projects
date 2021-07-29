import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { 
    console.log(sessionStorage.getItem('token'));
  }

  getToken() {
    return sessionStorage.getItem('token');
  }

  authenticate(userEmail: string, userPassword: string): Observable<any> {
    return this.httpClient
      .post<any>(environment.baseURL + `authenticate`, {
        userEmail,
        userPassword,
      })
      .pipe(
        map((userData) => {
          sessionStorage.setItem('userId', userData.userId);
          sessionStorage.setItem('userEmail', userEmail);
          let tokenStr = 'Bearer ' + userData.jwttoken;
          sessionStorage.setItem('token', tokenStr);
          sessionStorage.setItem('userName', userData.userName);
          return userData;
        })
      );
  }

  register(user: any): Observable<any> {
    return this.httpClient.post<any>(environment.baseURL + `register`, user);
    // .pipe(
    // catchError(this.handleError('addHero', hero))
    // );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    const email = sessionStorage.getItem('userEmail');
    sessionStorage.removeItem('username');
    this.httpClient.post<any>(environment.baseURL + `logoutt`, { email });
  }

  loggedIn(){
    return !!sessionStorage.getItem('token');
  }

}
