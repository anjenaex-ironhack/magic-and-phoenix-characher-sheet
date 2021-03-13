import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-player-main-view',
  templateUrl: './player-main-view.component.html',
  styleUrls: ['./player-main-view.component.sass']
})
export class PlayerMainViewComponent implements OnInit {

  name: string = "Antonio";
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  userId: number = 1;

  characterList: Character[] = [];


  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private characterServcie: CharacterService
  ) { }

  ngOnInit(): void {
    this.showCharacterList();
  }
  
  //go back to main-view
  goBack(): void {
    this.router.navigateByUrl("select-game");
  }

  //give info to the characterList properties
  showCharacterList(): void {
    const checkHasGameId: boolean = this.activatedRoute.snapshot.paramMap.has('gameId');
       this.characterServcie.getPlayerCharacterList(this.gameId, this.userId).subscribe(resp => {
      this.characterList = resp;
      console.log(resp)
    });
  }

}
