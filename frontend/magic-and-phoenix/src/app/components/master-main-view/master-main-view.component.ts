import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { CharacterService } from 'src/app/services/character.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-master-main-view',
  templateUrl: './master-main-view.component.html',
  styleUrls: ['./master-main-view.component.sass']
})
export class MasterMainViewComponent implements OnInit {

  name: string = "";
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  userId: number = 0;

  pxToIncrease!: number;

  characterList: Character[] = [];


  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private characterServcie: CharacterService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.showCharacterList();
    this.init();
  }

  init() {

    this.authService.getUserId().subscribe(resp => {
      this.userId =  resp;
    });
    this.authService.getUsername().subscribe(resp => {
      this.name = resp;
    });
    
  }
  logout():void {
    this.authService.deleteToken();
    this.router.navigateByUrl("/login");
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
