import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDownloadStatusComponent } from './admin-download-status.component';

describe('AdminDownloadStatusComponent', () => {
  let component: AdminDownloadStatusComponent;
  let fixture: ComponentFixture<AdminDownloadStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDownloadStatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDownloadStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
