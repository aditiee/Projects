import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})

export class BasicAuthHttpInterceptorService implements HttpInterceptor {

  constructor(private _loginService: LoginService) { }

  token=sessionStorage.getItem('token');
 
  

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    if (sessionStorage.getItem('userEmail') && sessionStorage.getItem('token')) {
      //Set the header for every request and response
      req = req.clone({
        setHeaders: {
          Authorization:`${this.token}`

        }
      })
    }
    return next.handle(req);
  }
  
}

