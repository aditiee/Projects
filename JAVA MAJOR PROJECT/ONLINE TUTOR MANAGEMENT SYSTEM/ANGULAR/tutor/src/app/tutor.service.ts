import { Feedbackresponse } from './feedbackresponse';
import { Register } from './register';
import { Injectable } from '@angular/core';
import { HttpClient ,HttpEventType} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

export class TrainingContent 
{ 
  constructor( 
    public trainingInfoId?: number, 
    public tutorId?: number, 
    public uploadedOn? : string, 
    public file? : FileList){} 
}

export class Feedback { 
 
  constructor( 
    public adminId?: number, 
    public userId?: number, 
    public remarks?: string, 
    public createdOn?: string, 
    public rating?: number 
  ) { } 
 
}

@Injectable({
  providedIn: 'root'
})
export class TutorService {
  trainingId:any;
  constructor(private http: HttpClient, private router: Router) { }
  contentList:any=[];

  //regiter
   createRegister(register: Register): Observable<any>{
    return this.http.post<any>(`http://localhost:8080/registeration_request`, register);
  }

  //tutorServices
  studentRequestList(data:any):Observable<any> {
    return this.http.post<any>('http://localhost:8080/getStudentRequestsForTutor',data);

  }

  approveStudentRequest(data:any)
  {
    return this.http.put('http://localhost:8080/approveStudentRequest', data);
  }

  deleteStudentRequest(data:number)
  {
    return this.http.delete('http://localhost:8080/deleteStudentRequest'+'/'+data);
  }

  tutorTrainingList(data:any):Observable<any>
  {
    return this.http.post<any>('http://localhost:8080/getAllTrainingsForTutor',data);
  }

  singleTrainingData(data:any){
    return this.http.get<any>('http://localhost:8080/getContentForTraining'+'/'+data)
    
  }
  
  studentList(data:any):Observable<any> {
    return this.http.post<any>('http://localhost:8080/getStudentsForTutor',data);

  }

  deleteContent(data:number)
  {
    return this.http.delete('http://localhost:8080/deleteContent'+'/'+data);
  }

  subjectList():Observable<any>
  {
    return this.http.get<any>('http://localhost:8080/getAllSubject');
  }

  addTraining(data:any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/addTraining', data);
  }

  deleteTraining(data:number)
  {
    return this.http.delete('http://localhost:8080/deleteTraining'+'/'+data);
  }

  addSubject(data:any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/addSubject', data);
  }


  //studentServices
  studentTutorList(): Observable<any>
  {
     return this.http.get<any>('http://localhost:8080/getAllTutors');
  }

  sendRequest(data:any):Observable<any>
  {
          console.log(data);
      return this.http.post<any>('http://localhost:8080/sendRequest', data);
  }

  waitingRequestList(data:any):Observable<any> {
    return this.http.post<any>('http://localhost:8080/getWaitingRequestsForStudent',data);

  }

  approvedRequestList(data:any):Observable<any> {
    return this.http.post<any>('http://localhost:8080/getApprovedRequestsForStudent',data);
  }



  //adminServices
  private baseURL = "http://localhost:8080/";
   getStudentRequests(): Observable<any>{
    return this.http.get<any>(`http://localhost:8080/studentRequests`);
  }

   acceptStudentRequest(id:number,student:any):Observable<any>{
    return this.http.put(`${this.baseURL}/acceptStudentrequests/${id}`,student);

  }

   admindeleteStudentRequest(id:number){

    return this.http.delete(`${this.baseURL}/studentRequests/${id}`);
  }

   getTutorRequests(): Observable<any>{
    return this.http.get<any>(`${this.baseURL}/tutorRequests`);
  }

  acceptTutorRequest(id:number, tutor:any):Observable<any>{
    return this.http.put(`${this.baseURL}/acceptTutorRequests/${id}`,tutor);

  }
  deleteTutorRequest(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/tutorRequests/${id}`);
  }

  //hardik


  getTutorList(): Observable<any>{
    return this.http.get<any>(`${this.baseURL}/getAllTutorsforAdmin`);
  }


   getStudentList(): Observable<any>{
    return this.http.get<any>(`${this.baseURL}/getAllStudents`);
  }


  deleteTutor(userId:number): Observable<any>{
    return this.http.delete(`${this.baseURL}/deleteUser/${userId}`);
  }

  deleteStudent(userId:number): Observable<any>{
    return this.http.delete(`${this.baseURL}/deleteUser/${userId}`);
  }


  //prajakta
 
  getAllStudentsByTutor(data:any){
 return this.http.get<any>('http://localhost:8080/adminStudentsForTutor'+'/'+data);

}

getAllTrainingsByTutor(data:any){
  return this.http.get<any>('http://localhost:8080/adminTrainingsForTutor'+'/'+data);
}


//upload
uploadContent(data : any): Observable<HttpEventType> 
  { 
  return this.http.post<any>('http://localhost:8080/file/upload', data, { 
    reportProgress : true 
  }); 
  }


  getUploadStatus():Observable<any>
  {
   return this.http.get<any>('http://localhost:8080/uploadStatus');
  }

  getDownloadStatus(data:any):Observable<any>
  {
    return this.http.post<any>('http://localhost:8080/downloadStatus',data);
  }

  adminDownloadStatus():Observable<any>
  {
    console.log("azhat")
     return this.http.get<any>('http://localhost:8080/admindownloadStatus');
  }


  // downloadContent(data : any) 
  // { 
  //   return this.http.get("http://localhost:8080/file/download/" + data ,{ 
  //  "responseType" : "blob" 
  //   }); 
  // }


  downloadContent(fileName : any,trainingContentId:number ,trainingInfoId:number,tutorId:number,studentId:number) 
  { 
    return this.http.post("http://localhost:8080/file/download/",{fileName,trainingContentId,trainingInfoId,tutorId,studentId} ,{ 
   "responseType" : "blob" 
    }); 

  }

  sendFeedback(data: Feedback): Observable<any> { 
    return this.http.post<Feedback>("http://localhost:8090/feedback/save", data); 
  }


  private tutorURL ="http://localhost:8080/feedback/getAllFeedbackByTutor/";


   getAllFeedbackByTutor(id:number): Observable<any> {
    return this.http.get<any>("http://localhost:8080/feedback/getAllFeedbackByTutor/"+id );

  }

}
