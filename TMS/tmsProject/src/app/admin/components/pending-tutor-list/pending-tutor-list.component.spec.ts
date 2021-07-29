import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingTutorListComponent } from './pending-tutor-list.component';

describe('PendingTutorListComponent', () => {
  let component: PendingTutorListComponent;
  let fixture: ComponentFixture<PendingTutorListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingTutorListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingTutorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
