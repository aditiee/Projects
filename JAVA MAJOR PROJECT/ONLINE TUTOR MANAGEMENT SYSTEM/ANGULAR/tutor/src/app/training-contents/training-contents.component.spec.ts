import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingContentsComponent } from './training-contents.component';

describe('TrainingContentsComponent', () => {
  let component: TrainingContentsComponent;
  let fixture: ComponentFixture<TrainingContentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainingContentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainingContentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
