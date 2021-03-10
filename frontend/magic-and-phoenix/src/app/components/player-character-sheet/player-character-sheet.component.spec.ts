import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerCharacterSheetComponent } from './player-character-sheet.component';

describe('PlayerCharacterSheetComponent', () => {
  let component: PlayerCharacterSheetComponent;
  let fixture: ComponentFixture<PlayerCharacterSheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerCharacterSheetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerCharacterSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
