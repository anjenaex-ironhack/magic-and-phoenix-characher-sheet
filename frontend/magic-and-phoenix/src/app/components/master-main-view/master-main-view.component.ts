import { Component, OnInit } from '@angular/core';
import { Character } from 'src/app/models/character';

@Component({
  selector: 'app-master-main-view',
  templateUrl: './master-main-view.component.html',
  styleUrls: ['./master-main-view.component.sass']
})
export class MasterMainViewComponent implements OnInit {

  characterSheetList: Character[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  increasePx(): void {

  }

}
