import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorFeedbackComponent } from './tutor-feedback.component';

describe('TutorFeedbackComponent', () => {
  let component: TutorFeedbackComponent;
  let fixture: ComponentFixture<TutorFeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorFeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
