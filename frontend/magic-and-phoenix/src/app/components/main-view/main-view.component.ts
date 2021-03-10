import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.sass']
})
export class MainViewComponent implements OnInit {

  games: Game[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  showGameList():void{
    
  }

}
