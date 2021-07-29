import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../../services/student.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  
  searchQuery :string = "";
  searchData: any[]= [];
  filteredSearchData: any[]= [];
  pageNumber = 10;


  title = 'angulartoastr';
  showModal!: boolean;
  registerForm!: FormGroup;
  submitted = false;

  constructor(private _studentServ: StudentService,private _fromBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this._fromBuilder.group({ 
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
  });
  }

  getSearchData(){
    this._studentServ.searchMaterial(this.searchQuery).subscribe((res) =>{
      this.searchData = res;
      // this.filteredSearchData =this.searchData.slice(0,this.pageNumber);
    });

   

  }

  show()
  {
    this.showModal = true; // Show-Hide Modal Check
    
  }
  //Bootstrap Modal Close event
  hide()
  {
    this.showModal = false;
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
    if(this.submitted)  
    {
      this.showModal = false;
    }
   
}


}
