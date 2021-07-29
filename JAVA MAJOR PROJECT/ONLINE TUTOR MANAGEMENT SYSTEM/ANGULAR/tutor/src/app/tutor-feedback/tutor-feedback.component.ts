import { Feedbackresponse } from './../feedbackresponse';
import { TutorService } from './../tutor.service';
import { Component, OnInit } from '@angular/core';
import { Feedback } from '../feedback';
import { UserInfo } from '../user-info';
import {FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
@Component({
  selector: 'app-tutor-feedback',
  templateUrl: './tutor-feedback.component.html',
  styleUrls: ['./tutor-feedback.component.css']
})
export class TutorFeedbackComponent implements OnInit {
 
   feedbackResponse!: Feedbackresponse;
  feedbackArray!:Feedback[];
  studentArray!:UserInfo[];
  finalArray:any;
  constructor(private tutorService:TutorService) { }

  ngOnInit(): void {
  }

  getAllFeedbackByTutor(id:number){
    this.tutorService.getAllFeedbackByTutor(id).subscribe(data => {
      this.feedbackResponse = data;
      this.feedbackArray=this.feedbackResponse.feedbacks;
      this.studentArray=this.feedbackResponse.userinfo;
      console.log(this.feedbackArray);

      console.log(this.studentArray);

      
     // console.log(this.range.value);

    });
  }
}
