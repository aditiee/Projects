import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-delete-tutor',
  templateUrl: './delete-tutor.component.html',
  styleUrls: ['./delete-tutor.component.scss']
})
export class DeleteTutorComponent implements OnInit {

  subscription: Subscription | undefined;
  tutors:any;

  constructor(private _adminService:AdminService, private _router:Router) { }

  ngOnInit(): void {
    this.subscription=this._adminService
    .getTutorApproveList()
    .subscribe((res:any)=>{
      this.tutors=res;
      console.log(this.tutors);
      if(this.tutors.length==0){
        alert("No record found");
      }
    });
    
  }
  delete(itemId:number){
      this.subscription=this._adminService.deleteTutor(itemId)
      .subscribe((res:any)=>{
        this._router.navigate(['admin/navbar'])
        console.log("Deleted");
      })
  }

}

// approve(itemId:number){
//   this.subscription=this._adminService.approveTutorPending(itemId)
//   .subscribe((res:any)=>{
//     //location.reload();
//     this._router.navigate(['admin/navbar'])
//     //console.log("approved");
//   });
//   console.log("Clcicked" ,itemId);
// }
