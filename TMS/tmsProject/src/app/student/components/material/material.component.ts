import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { StudentService } from '../../services/student.service';
import { saveAs  } from 'file-saver';

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.scss']
})
export class MaterialComponent implements OnInit {


  //feedback from fields
  title = 'angulartoastr';
  showModal!: boolean;
  registerForm!: FormGroup;
  submitted = false;

  studentId: any = sessionStorage.getItem('userId');
  studentName: any = sessionStorage.getItem('userName');
  tutorId!: any;
  tutorName!: any;
  technologyName!: any;
  materialName!: any;
  feedback!: any;

  //create downloadable link
  downloadURL!:string;


  student_Id = this.studentId;
  student_Name = sessionStorage.getItem('userName');


  
  //rating fields
  stars: number[] = [1, 2, 3, 4, 5];
  selectedValue: number = 1;

  userId !: any;
  materialList !: any[];
  constructor(private _studentServ: StudentService, private _fromBuilder: FormBuilder) { }

  ngOnInit(): void {
    this._studentServ.getMaterial(this.userId).subscribe((res) => {
      this.materialList = res;
    });

    this.userId = sessionStorage.getItem('userId');

    this.registerForm = this._fromBuilder.group({
      feedback: ['', [Validators.required]],
      rating: ['', [Validators.required]]

    });
  }

  getMaterialList() {
    this._studentServ.getMaterial(this.userId).subscribe((res) => {
      this.materialList = res;
      
    });


  }

  show(m: any) {


    this.showModal = true; // Show-Hide Modal Check

    //assign tutor id through response
    this.tutorId = m.belongsToTutor.userId;
    this.tutorName = m.belongsToTutor.userName;
    this.technologyName = m.belongsTechnology.technologyName;
    this.materialName = m.fileName;

  }


  //Bootstrap Modal Close event
  hide() {
    this.showModal = false;
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    // console.log(this.feedbackObj);
    if (this.registerForm.invalid) {
      return;
    }
    if (this.submitted) {
      this.showModal = false;
    }
    const data:JSON = <JSON>(<unknown>{
      tutorId: this.tutorId,
      studentId: this.student_Id,
      tutorName: this.tutorName,
      studentName: this.student_Name,
      technologyName: this.technologyName,
      materialName: this.materialName,
      rating: this.selectedValue,
      remarks: this.registerForm.get('feedback')?.value
    })
    this._studentServ.postFeedback(data).subscribe((res) =>{

    
    });

  }

  //function to count stars
  countStar(star: any) {
    this.selectedValue = star;
    
  }

  downloadMaterial(materialId: number){
    this._studentServ.downloadMaterial(materialId).subscribe(data =>{
      // const blob = new Blob([data], {type:'application/pdf'});
      // const url = window.URL.createObjectURL(blob);
      // window.open(url);
      saveAs(new Blob([data],{type:'application/text'}));
    })
  }



 


}
