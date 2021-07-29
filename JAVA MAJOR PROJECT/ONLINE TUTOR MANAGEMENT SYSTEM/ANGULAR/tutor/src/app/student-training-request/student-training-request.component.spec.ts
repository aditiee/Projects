import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentTrainingRequestComponent } from './student-training-request.component';

describe('StudentTrainingRequestComponent', () => {
  let component: StudentTrainingRequestComponent;
  let fixture: ComponentFixture<StudentTrainingRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentTrainingRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentTrainingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
