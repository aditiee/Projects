import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentWaitingRequestComponent } from './student-waiting-request.component';

describe('StudentWaitingRequestComponent', () => {
  let component: StudentWaitingRequestComponent;
  let fixture: ComponentFixture<StudentWaitingRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentWaitingRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentWaitingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
