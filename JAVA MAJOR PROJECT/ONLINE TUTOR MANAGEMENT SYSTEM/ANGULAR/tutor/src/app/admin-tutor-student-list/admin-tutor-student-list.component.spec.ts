import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTutorStudentListComponent } from './admin-tutor-student-list.component';

describe('AdminTutorStudentListComponent', () => {
  let component: AdminTutorStudentListComponent;
  let fixture: ComponentFixture<AdminTutorStudentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminTutorStudentListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTutorStudentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
