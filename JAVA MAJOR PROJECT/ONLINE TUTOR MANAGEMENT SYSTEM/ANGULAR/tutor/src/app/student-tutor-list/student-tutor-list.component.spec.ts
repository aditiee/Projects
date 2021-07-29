import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentTutorListComponent } from './student-tutor-list.component';

describe('StudentTutorListComponent', () => {
  let component: StudentTutorListComponent;
  let fixture: ComponentFixture<StudentTutorListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentTutorListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentTutorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
