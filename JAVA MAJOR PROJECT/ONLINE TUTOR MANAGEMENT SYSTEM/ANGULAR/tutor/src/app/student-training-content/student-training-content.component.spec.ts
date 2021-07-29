import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentTrainingContentComponent } from './student-training-content.component';

describe('StudentTrainingContentComponent', () => {
  let component: StudentTrainingContentComponent;
  let fixture: ComponentFixture<StudentTrainingContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentTrainingContentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentTrainingContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
