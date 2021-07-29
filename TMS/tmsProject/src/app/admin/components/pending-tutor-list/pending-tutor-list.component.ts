import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-pending-tutor-list',
  templateUrl: './pending-tutor-list.component.html',
  styleUrls: ['./pending-tutor-list.component.scss']
})
export class PendingTutorListComponent implements OnInit {
  subscription: Subscription | undefined;
  tutors:any;

  pendingTutorNav: any[] = [];
  constructor(private _adminService:AdminService, private _router:Router) { }

  ngOnInit(): void {

    this.pendingTutorNav = [
      {
        name: 'Home',
        route: '/admin/navbar',
        data: null,
      },
      {
        name: 'Logout',
        route: '',
        data: null,
      }
    ];


    this.subscription=this._adminService
    .getTutorPendingList()
    .subscribe((res:any)=>{
      this.tutors=res;
      console.log(this.tutors);
      if(this.tutors.length==0){
        alert("No record found");
      }
    });
  }

  approve(itemId:number){
    this.subscription=this._adminService.approveTutorPending(itemId)
    .subscribe((res:any)=>{
      //location.reload();
      this._router.navigate(['admin/navbar'])
      //console.log("approved");
    });
    console.log("Clcicked" ,itemId);
  }


}
