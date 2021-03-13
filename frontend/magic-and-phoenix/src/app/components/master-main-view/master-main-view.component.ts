import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { CharacterService } from 'src/app/services/character.service';

@Component({
  selector: 'app-master-main-view',
  templateUrl: './master-main-view.component.html',
  styleUrls: ['./master-main-view.component.sass']
})
export class MasterMainViewComponent implements OnInit {

  name: string = "Antonio";
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  userId: number = 1;

  pxToIncrease!: number;

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
    this.characterServcie.getCharacterListByGameId(this.gameId).subscribe(resp => {
      this.characterList = resp;
      console.log(resp);
    });
  }
  increaseGroupPx(px: number): void {
    this.characterList.forEach(character => {
      this.characterServcie.updateCharacterPx(character.id, px).subscribe(resp => {
        console.log(resp);
      }
      )
    })
  }

}
