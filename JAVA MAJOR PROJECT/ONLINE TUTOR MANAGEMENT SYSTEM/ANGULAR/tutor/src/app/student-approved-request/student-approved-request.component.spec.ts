import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentApprovedRequestComponent } from './student-approved-request.component';

describe('StudentApprovedRequestComponent', () => {
  let component: StudentApprovedRequestComponent;
  let fixture: ComponentFixture<StudentApprovedRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentApprovedRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentApprovedRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
