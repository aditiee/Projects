import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTutorRequestListComponent } from './admin-tutor-request-list.component';

describe('AdminTutorRequestListComponent', () => {
  let component: AdminTutorRequestListComponent;
  let fixture: ComponentFixture<AdminTutorRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminTutorRequestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTutorRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
