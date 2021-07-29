import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteTutorComponent } from './delete-tutor.component';

describe('DeleteTutorComponent', () => {
  let component: DeleteTutorComponent;
  let fixture: ComponentFixture<DeleteTutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteTutorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteTutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
