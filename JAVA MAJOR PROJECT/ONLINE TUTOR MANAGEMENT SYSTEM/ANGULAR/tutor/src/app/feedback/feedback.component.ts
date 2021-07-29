import { UserInfo } from './../user-info';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'; 
import { Feedback, TutorService } from '../tutor.service';
import { FormBuilder, FormGroup,  Validators } from '@angular/forms';
@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  currentRate: number = 0; 
  userDetails: any; 
  userDet: any; 
  profiledata!: UserInfo; 
  feedback: Feedback = new Feedback(); 
  formData: FormData = new FormData(); 
  tutor: any; 
  tutorData: any; 
  tutorId: any; 
  date1: Date = new Date(); 
  registerForm!: FormGroup; 
  submitted = false; 
  materialName!: any;
  //rating fields 
  stars: number[] = [1, 2, 3, 4, 5]; 
  selectedValue: number = 1;
  constructor(private service: TutorService, private router: Router, private _activeRoute: ActivatedRoute, private _fromBuilder: FormBuilder) { 
    this.userDetails = sessionStorage.getItem('token'); 
    this.userDet = JSON.parse(this.userDetails); 
    this.profiledata = this.userDet.userinfo; 
    this.tutor = sessionStorage.getItem('tutorId'); 
    this.tutorData = JSON.parse(this.tutor); 
    this.tutorId = this.tutorData.tutorId; 
  }
 //function to count stars 
  countStar(star: any) { 
    this.selectedValue = star; 
 
  } 
  ngOnInit(): void { 
 
    console.log("userid ....." + this.userDet.userinfo.userId); 
    console.log("id.." + this.tutorId); 
    this.registerForm = this._fromBuilder.group({ 
      feedback: ['', [Validators.required]], 
      rating: ['', [Validators.required]] 
 
    }); 
  } 
 
 
  ratings() { 
    this.currentRate; 
    console.log(this.currentRate); 
  } 
 
 
  // convenience getter for easy access to form fields 
  get f() { return this.registerForm.controls; } 
 
  onSubmit() { 
    this.submitted = true; 
 
    this.feedback.adminId = this.tutorId; 
    this.feedback.userId = this.userDet.userinfo.userId; 
    this.feedback.createdOn = this.date1.toString(); 
    this.feedback.rating = this.selectedValue; 
    this.feedback.remarks = this.registerForm.get('feedback')?.value 
 
    console.log(this.feedback) 
    this.service.sendFeedback(this.feedback).subscribe(data => { 
 
      this.router.navigate(['/sidebar/student-tutor-list']); 
 
    }) 
 
  } 
 

}
