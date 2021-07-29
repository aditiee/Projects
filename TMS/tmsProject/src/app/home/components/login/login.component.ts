import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomvalidationService } from '../../services/customvalidation.service';
import { LoginService } from '../../services/login.service';

declare var $: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginform:FormGroup;
  registerform:FormGroup;
  submitted=false;
  constructor(private loginService:LoginService, private router:Router,private fb:FormBuilder, private customValidator:CustomvalidationService) 
  { 
    this.loginform=this.fb.group({
      emailld: ['', [Validators.required, Validators.email]],
      password:['',Validators.required]
    });
    this.registerform=this.fb.group({

      email: [
              '',
              Validators.compose([
                Validators.required,
                Validators.email
                //this.customValidator.userNameValidator.bind(this.customValidator),
              ]),
            ],
      username: ['', [Validators.required]],
      password: [
              '',
              Validators.compose([
                Validators.required
                //this.customValidator.patternValidator(),
              ]),
            ],
      confirmPassword: ['', [Validators.required]],
      role: ['', Validators.required],
      },
      {
        validator: this.customValidator.MatchPassword('password','confirmPassword')
      }
    );
  }

  get f() { return this.registerform.controls; }
  get l() { return this.loginform.controls; }


  ngOnInit(): void {

    // this.loginform=this.fb.group({
    //   emailld: ['', [Validators.required, Validators.email]],
    //   password: [
    //     '',
    //     Validators.compose([
    //       Validators.required,
    //       this.customValidator.patternValidator(),
    //     ]),
    //   ],
    // });

    // this.registerform = this.fb.group(
    //   {
    //     email: [
    //       '',
    //       Validators.compose([
    //         Validators.required,
    //         Validators.email,
    //         this.customValidator.userNameValidator.bind(this.customValidator),
    //       ]),
    //     ],
    //     username: ['', [Validators.required]],
    //     password: [
    //       '',
    //       Validators.compose([
    //         Validators.required,
    //         this.customValidator.patternValidator(),
    //       ]),
    //     ],
    //     confirmPassword: ['', [Validators.required]],
    //     role: ['', Validators.required],
    //   },
    //   {
    //     validator: this.customValidator.MatchPassword(
    //       'password',
    //       'confirmPassword'
    //     ),
    //   }
    // );
  }

  ngAfterViewInit() {
    
    $(document).ready(function(){
    $('.login-info-box').fadeOut();
    $('.login-show').addClass('show-log-panel');

    $('.login-reg-panel input[type="radio"]').on('change', function () {
      if ($('#log-login-show').is(':checked')) {
        $('.register-info-box').fadeOut();
        $('.login-info-box').fadeIn();

        $('.white-panel').addClass('right-log');
        $('.register-show').addClass('show-log-panel');
        $('.login-show').removeClass('show-log-panel');
      } else if ($('#log-reg-show').is(':checked')) {
        $('.register-info-box').fadeIn();
        $('.login-info-box').fadeOut();

        $('.white-panel').removeClass('right-log');

        $('.login-show').addClass('show-log-panel');
        $('.register-show').removeClass('show-log-panel');
      }
    });
  })
}

  login() {
    if (!this.loginform.valid) {
      console.log(this.loginform.value);
      
      return;
    }

   //this.loginService.authenticate(this.loginform.value.emailld,this.loginform.value.password).subscribe((data)=>{console.log(data.role);})

    this.loginService
      .authenticate(this.loginform.value.emailld, this.loginform.value.password)
      .subscribe((data) => {
        console.log(data.role);
        if (data.role == 'ADMIN') {
            //if admin role found
            this.router.navigate(['/admin/navbar'], {
              state: { userId: data.userId, userName: data.userName },
            })
        }else if (data.role == 'TUTOR') {
              this.router.navigate(['/tutor/navbar'], {
                state: { userId: data.userId, userName: data.userName },
              })
        }  
        else if (data.role == 'STUDENT') {
            this.router.navigate(['/student/navbar'], {
              state: { userId: data.userId, userName: data.userName },
            });
        } else {
          this.router.navigate([''], {
            state: { userId: data.userId, userName: data.userName },
          });
        }
      });
  }
  

  register() {
    console.log(this.registerform);

    if (!this.registerform.valid) {
      console.log('inside if');
      console.log(this.registerform);
      return;
    }

    const user: JSON = <JSON>(<unknown>{
      username: this.registerform.value.username,
      password: this.registerform.value.password,
      userEmail: this.registerform.value.email,
      userRole: this.registerform.value.role,
    });
    console.log('Sdddddf');
    this.loginService.register(user).subscribe((data) => {
      console.log(data);
      //this.router.navigate(['/login']);
      //location.reload();
    });
  }
}


