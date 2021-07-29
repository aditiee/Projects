import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorTrainingsComponent } from './tutor-trainings.component';

describe('TutorTrainingsComponent', () => {
  let component: TutorTrainingsComponent;
  let fixture: ComponentFixture<TutorTrainingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorTrainingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorTrainingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
