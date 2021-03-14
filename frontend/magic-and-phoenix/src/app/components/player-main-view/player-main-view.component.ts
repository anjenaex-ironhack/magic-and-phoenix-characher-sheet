import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { CharacterService } from '../../services/character.service';
import { Auth } from '../../interfaces/auth';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-player-main-view',
  templateUrl: './player-main-view.component.html',
  styleUrls: ['./player-main-view.component.sass']
})
export class PlayerMainViewComponent implements OnInit {

  name: string = "";
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  userId: number = 0;

  characterList: Character[] = [];


  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private characterServcie: CharacterService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    //this.showCharacterList(1);
    this.init();
    
  }

  init() {

    this.authService.getUserId().subscribe(resp => {
      this.userId =  resp; 
      console.log(resp)
      this.showCharacterList(resp);
      
    });
    this.authService.getUsername().subscribe(resp => {
      this.name = resp;
    });
    
  }
  logout():void {
    this.authService.deleteToken();
    this.characterList = [];

    this.router.navigateByUrl("/login");
  }
  
  //go back to main-view
  goBack(): void {
    this.router.navigateByUrl("select-game");
  }

  //give info to the characterList properties
  showCharacterList(userId: number): void {
    const checkHasGameId: boolean = this.activatedRoute.snapshot.paramMap.has('gameId');
       this.characterServcie.getPlayerCharacterList(this.gameId, userId).subscribe(resp => {
      this.characterList = resp;
      console.log(resp)
    });
  }

}
