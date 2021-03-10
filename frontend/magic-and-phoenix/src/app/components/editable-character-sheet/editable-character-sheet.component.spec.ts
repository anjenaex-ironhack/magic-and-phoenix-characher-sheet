import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableCharacterSheetComponent } from './editable-character-sheet.component';

describe('EditableCharacterSheetComponent', () => {
  let component: EditableCharacterSheetComponent;
  let fixture: ComponentFixture<EditableCharacterSheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditableCharacterSheetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableCharacterSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
