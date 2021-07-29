import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminStudentRequestListComponent } from './admin-student-request-list.component';

describe('AdminStudentRequestListComponent', () => {
  let component: AdminStudentRequestListComponent;
  let fixture: ComponentFixture<AdminStudentRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminStudentRequestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminStudentRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
