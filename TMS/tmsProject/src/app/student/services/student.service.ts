import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Itutor } from 'src/app/utilities/itutor';
import { environment } from 'src/environments/environment';
// export type ResponseType = 'blob';
@Injectable({
  providedIn: 'root'
})
export class StudentService {
  
  token = sessionStorage.getItem('token');
  constructor(private _http: HttpClient) { }

  getTutorList(): Observable<any> {
    return this._http.get<any>(environment.baseURL + `student/getAllTutor`);
  }

  getEnroll(t: Itutor, userId: any): Observable<any> {
    return this._http.post<any>(environment.baseURL + `student/enroll?userId=${userId}`,t);
  }

  getMaterial(userId: number): Observable<any>{
    return this._http.get<any>(environment.baseURL + `student/materialList?userId=${userId}`);
  }

  searchMaterial(searchtext: string): Observable<any>{
    return this._http.get<any>(environment.baseURL + `student/searchtutor?searchtext=${searchtext}`);
  //  return fetch(environment.baseURL + `student/materialList`)
  //     .then(response => response.json())
  }

  postFeedback(data:any){
    return this._http.post<any>(environment.baseURL + `feedback/save`,
      data
    );
  }

  downloadMaterial(materialId: number): Observable<Blob>{
    return this._http.get<Blob>(environment.baseURL + `student/download?materialId=${materialId}`,{headers: {'Authorization':`Bearer ${this.token}`}, responseType: 'blob' as 'json'});
  }



}
