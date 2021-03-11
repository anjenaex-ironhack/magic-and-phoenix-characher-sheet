import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from 'src/app/models/game';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.sass']
})
export class MainViewComponent implements OnInit {

  gameList: Game[] = [];

  //Este id tiene que venir del login
  userId: number =  1;

  form: FormGroup;

  tokenField: FormControl;

  constructor(
    private gameService: GameService,
    private router:Router
  ) {
    this.tokenField = new FormControl('', [Validators.required]);

    this.form = new FormGroup ({
      token: this.tokenField
    })
   }

  ngOnInit(): void {
    //meter aqui un this.showgamelist to molon cuando funcione
  }

  joinGame(form: FormGroup): void {
    
    //Esta funcion tiene que hacer que se actualize el campo gameList de un usuario, metiendole el game con el token adecuado
    this.gameService.joinGame(this.userId, form.value.token);

    this.showGameList();

  }

  showGameList():void{

    this.gameService.showUserGames(this.userId).subscribe(resp => {
      this.gameList = resp;
    });
    
  }

  goToCreateGame(): void {
    this.router.navigateByUrl("create-game")
  }
}
