import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../home/services/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private _loginServ:LoginService, private _router:Router){}

  canActivate(): boolean{
    if(this._loginServ.loggedIn()){
      return true;
    }
    else{
      this._router.navigate(['/login']);
    }
    return false;

  }
  
}
