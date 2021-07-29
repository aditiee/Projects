import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-pending-student-list',
  templateUrl: './pending-student-list.component.html',
  styleUrls: ['./pending-student-list.component.scss']
})
export class PendingStudentListComponent implements OnInit {

  subscription: Subscription | undefined;
  student:any;
  constructor(private _adminService:AdminService, private _router:Router) { }

  ngOnInit(): void {
    this.subscription=this._adminService
    .getStudentPendingList()
    .subscribe((res:any)=>{
      this.student=res;
      console.log(this.student);
      if(this.student.length==0){
        alert("No record found");
      }
    });
  }

  approve(itemId:number){
    this.subscription=this._adminService.approveStudentPending(itemId)
    .subscribe((res:any)=>{
      //location.reload();
      this._router.navigate(['admin/navbar'])
      //console.log("approved");
    });
    console.log("Clcicked" ,itemId);
  }
}
