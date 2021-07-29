import { Injectable,RendererFactory2 } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService {

  constructor(private auth: AuthService) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedRoleArray = route.data.expectedRole;
        const userDetails:any = localStorage.getItem('token');
        const userDet:any=JSON.parse(userDetails);
        let expectedRole;
        for (const index in expectedRoleArray) {
            if (userDet && userDet.role === index) {
                expectedRole = index;
            }
        }
        if (userDet && userDet.role === expectedRole) {
            console.log('user loggedIn');
            return true;
        } else {
            console.log(expectedRole);
            console.log(userDet.role);
            console.log('user not loggedin');
            return false;
        }
    }
}
