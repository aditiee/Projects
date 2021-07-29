import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingStudentListComponent } from './pending-student-list.component';

describe('PendingStudentListComponent', () => {
  let component: PendingStudentListComponent;
  let fixture: ComponentFixture<PendingStudentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingStudentListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingStudentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
