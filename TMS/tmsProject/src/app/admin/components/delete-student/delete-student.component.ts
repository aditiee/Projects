import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.scss']
})
export class DeleteStudentComponent implements OnInit {

  subscription: Subscription | undefined;
  student:any;
  constructor(private _adminService:AdminService, private _router:Router) { }

  ngOnInit(): void {
    this.subscription=this._adminService
    .getStudentApproveList()
    .subscribe((res:any)=>{
      this.student=res;
      console.log(this.student);
      if(this.student.length==0){
        alert("No record found");
      }
    });
  }

  delete(itemId:number){
    this.subscription=this._adminService.deleteStudent(itemId)
    .subscribe((res:any)=>{
      this._router.navigate(['admin/navbar'])
      console.log("Deleted");
    })
}

}
