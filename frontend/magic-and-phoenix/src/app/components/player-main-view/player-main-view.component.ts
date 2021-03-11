import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-player-main-view',
  templateUrl: './player-main-view.component.html',
  styleUrls: ['./player-main-view.component.sass']
})
export class PlayerMainViewComponent implements OnInit {

  characterList: Character[] = []

  constructor(
    private router: Router,
    private characterServcie: CharacterService
  ) { }

  ngOnInit(): void {
    //meter un this.showCharacterList to molon aqui
  }

  goToCreateCharacter(): void {
    this.router.navigateByUrl("game/:gameId/character/create")
  }
  //go back to main-view
  goBack(): void {
    this.router.navigateByUrl("select-game");
  }

  //give info to the characterList propertie
  showCharacterList(): void {

  }

  selectCharacter(): void {
    
  }

  

}
