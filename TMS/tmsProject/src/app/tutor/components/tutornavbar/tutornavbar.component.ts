import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tutornavbar',
  templateUrl: './tutornavbar.component.html',
  styleUrls: ['./tutornavbar.component.scss']
})
export class TutornavbarComponent implements OnInit {

  tutorNav: any[] = [];
  constructor() { }

  ngOnInit(): void {
  }

}
