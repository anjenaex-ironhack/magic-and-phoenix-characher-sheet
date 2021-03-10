import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerMainViewComponentComponent } from './player-main-view-component.component';

describe('PlayerMainViewComponentComponent', () => {
  let component: PlayerMainViewComponentComponent;
  let fixture: ComponentFixture<PlayerMainViewComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerMainViewComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerMainViewComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
