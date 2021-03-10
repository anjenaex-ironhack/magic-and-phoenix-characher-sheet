import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterMainViewComponent } from './master-main-view.component';

describe('MasterMainViewComponent', () => {
  let component: MasterMainViewComponent;
  let fixture: ComponentFixture<MasterMainViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MasterMainViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MasterMainViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
