import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTutorTrainingListComponent } from './admin-tutor-training-list.component';

describe('AdminTutorTrainingListComponent', () => {
  let component: AdminTutorTrainingListComponent;
  let fixture: ComponentFixture<AdminTutorTrainingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminTutorTrainingListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTutorTrainingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
