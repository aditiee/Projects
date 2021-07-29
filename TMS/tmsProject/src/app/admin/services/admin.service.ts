import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LoginService } from 'src/app/home/services/login.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private _http: HttpClient, private _loginService: LoginService) {}

  getTutorPendingList(): Observable<any> {
    return this._http.get<any>(environment.baseURL + `admin/allTutorPending`);
  }

  getStudentPendingList(): Observable<any> {
    return this._http.get<any>(environment.baseURL + `admin/allStudentPending`);
  }

  approveTutorPending(id:number): Observable<any> {
    return this._http.put<any>(environment.baseURL + `admin/approvePendingUser?userId=`+id,id);
  }

  approveStudentPending(id:number): Observable<any> {
    return this._http.put<any>(environment.baseURL + `admin/approvePendingUser?userId=`+id,id);
  }

  getTutorApproveList(): Observable<any>{
    return this._http.get<any>(environment.baseURL + `admin/allTutorApprove`);
  }

  getStudentApproveList(): Observable<any>{
    return this._http.get<any>(environment.baseURL + `admin/allStudentApprove`);
  }

  deleteTutor(id:number):Observable<any>{
    return this._http.delete<any>(environment.baseURL + `admin/deleteTutor?userId=`+id);
  }

  deleteStudent(id:number):Observable<any>{
    return this._http.delete<any>(environment.baseURL + `admin/deleteStudent?userId=`+id);
  }
}
