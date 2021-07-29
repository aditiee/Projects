import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Itutor } from 'src/app/utilities/itutor';
import { StudentService } from '../../services/student.service';

@Component({
  selector: 'app-tutorlist',
  templateUrl: './tutorlist.component.html',
  styleUrls: ['./tutorlist.component.scss']
})
export class TutorlistComponent implements OnInit, OnDestroy {

  public tutorList!: Itutor[] ;
  userId!: any;
  searchQuery: string = "";
  isEnrolled: boolean = false;
  status: string = "Enroll";
  


  constructor(private _studentServ: StudentService) { }
 
  ngOnInit(): void {
   
    this._studentServ.getTutorList().subscribe((data) =>{
      this.tutorList = data;
      console.log(data);
    })

    

  }

  getEnroll(t: Itutor){
    this.userId = sessionStorage.getItem('userId')
    this._studentServ.getEnroll(t,this.userId).subscribe(res =>{
      console.log(res);
      
    });

    t.isEnrolled = true;


  }

  ngOnDestroy(): void {
    
  }

}
  
  






