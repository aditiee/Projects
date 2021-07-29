import { UserInfo } from './../user-info';
import { Router, ActivatedRoute } from '@angular/router';
import { TutorService, TrainingContent } from './../tutor.service';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-uploadcontent',
  templateUrl: './uploadcontent.component.html',
  styleUrls: ['./uploadcontent.component.css']
})
export class UploadcontentComponent implements OnInit {

  id:any;
   userDetails:any;
    userDet:any;
     profileData:UserInfo;
  selectedFiles!: FileList; 
  trainingContent: TrainingContent = new TrainingContent(); 
  formData: FormData = new FormData(); 
  trainingId: any; 
  
  constructor(private tutorService:TutorService,private router:Router,private _activeRoute:ActivatedRoute) { 
     
    this._activeRoute.params.subscribe(res=>{
      this.id=res.id;
      
    })
    this.userDetails= sessionStorage.getItem('token');
    this.userDet=JSON.parse(this.userDetails);
    this.profileData=this.userDet.userinfo.userId;
    
  }

  ngOnInit(): void {
    this.trainingId = this.id; 
    console.log("trainingId..." + this.trainingId) 
    console.log(" tutor id " + this.userDet.userinfo.userId)
  }

  // addNewContent(uploadContent:NgForm)
  // {
  //   this.router.navigate([`sidebar/training-contents`,this.id]);
  // }
selectFile(event: any) { 
    this.selectedFiles = event.target.files; 
    console.log(this.selectedFiles) 
  } 
  addNewContent() { 
    //  this.trainingContent.trainingInfoId=this.trainingId; 
    //  this.trainingContent.tutorId= this.userDet.userinfo.userId; 
    //  this.trainingContent.file = this.selectedFiles; 
    //  this.trainingContent.uploadedOn= new Date(); 
    var date = new Date(); 
   
    this.formData.append('trainingInfoId', this.trainingId); 
    this.formData.append('tutorId', this.userDet.userinfo.userId); 
   
 
    Array.from(this.selectedFiles) 
      .forEach((file) => { 
        this.formData.append('file', file); 
       
      }) 
    this.tutorService.uploadContent(this.formData).subscribe((event: any) => { 
       
      console.log(event); 
      // if (event.type == HttpEventType.UploadProgress) { 
      //   console.log("upload progress " + event.type); 
      // } 
      // else if (event.type == HttpEventType.Response) { 
      //   console.log("response  " + event.body); 
      // } 
      this.tutorService.trainingId = this.trainingId; 
    this.router.navigate([`sidebar/training-contents`,this.trainingId]);
 
    }) 
 
 
  } 
}

  
