import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorStudentsRequestComponent } from './tutor-students-request.component';

describe('TutorStudentsRequestComponent', () => {
  let component: TutorStudentsRequestComponent;
  let fixture: ComponentFixture<TutorStudentsRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorStudentsRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorStudentsRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
