import { TutorService } from './../tutor.service';
import { Router } from '@angular/router';
import { Register } from './../register';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
 register:Register=new Register();
  constructor(private router:Router,private tutorService:TutorService) { }
registerForm: any;
  ngOnInit(): void {

    this.registerForm=new FormGroup({
      "firstName":new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]*'),Validators.maxLength(10)]),
      "middleName":new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]*'),Validators.maxLength(10)]),
      "lastName":new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]*'),Validators.maxLength(10)]),
      "emailId":new FormControl('',[Validators.required,Validators.email,Validators.pattern('^[^\\s@]+@[^\\s@]+\\.[^\\s@]{2,}$')]),
      "mobileNumber":new FormControl('',[Validators.required,Validators.pattern('[0-9]{10}')]),
      "Password":new FormControl('',[Validators.required,Validators.minLength(6)]),
      "role":new FormControl('',[Validators.required]),
      "confirmPassword":new FormControl('',[Validators.required])
    })
  }

   get firstname(){return this.registerForm.get('firstName');}
  get middlename(){return this.registerForm.get('middleName');}
  get lastname(){return this.registerForm.get('lastName');}
  get emailid(){return this.registerForm.get('emailId');}
  get mobilenumber(){return this.registerForm.get('mobileNumber');}
  get password(){return this.registerForm.get('Password');}
  get confirmpassword(){return this.registerForm.get('confirmPassword');}
  get Role(){return this.registerForm.get('role');}

  submitData()
  {
    console.log(this.register);
    this.tutorService.createRegister(this.register).subscribe( data =>{
      console.log(data);
      this.router.navigate(['login']);
      
    },
    error => console.log(error));
    
  }

  reset(){
    this.registerForm.reset();
  }
}
