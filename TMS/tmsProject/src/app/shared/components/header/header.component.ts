import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Input() navItems: any;
  logo="../assets/logo.png"

  constructor(private _router: Router) { }

  ngOnInit(): void {
  }

  navigateTo(route: any) {
    this._router.navigate([route]);
  }
}
