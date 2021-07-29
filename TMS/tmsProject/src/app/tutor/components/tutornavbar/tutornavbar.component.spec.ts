import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutornavbarComponent } from './tutornavbar.component';

describe('TutornavbarComponent', () => {
  let component: TutornavbarComponent;
  let fixture: ComponentFixture<TutornavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutornavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutornavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
