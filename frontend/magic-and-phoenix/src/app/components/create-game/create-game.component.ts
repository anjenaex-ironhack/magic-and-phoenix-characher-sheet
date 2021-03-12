import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GameDTO } from '../../dto/game-dto'
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.sass']
})
export class CreateGameComponent implements OnInit {

  form: FormGroup;

  nameField: FormControl;
  tokenField: FormControl;

  //Esta id hay que sacarla de la persona que tiene iniciada la sesion
  userId: number = 1;

  constructor(
    private router: Router,
    private gameService: GameService
  ) {
    // Initialize Form Control fields
    this.nameField = new FormControl('', [ Validators.required]);
    this.tokenField = new FormControl('', [ Validators.required, Validators.minLength(7)]);
   

    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      token: this.tokenField
    })
   }

  ngOnInit(): void {
  }

  goBack(): void {
    this.router.navigateByUrl("select-game");
  }

  createGame(form: FormGroup): void {

    const game =  {
      name: form.value.name,
      masterId: this.userId,
      token: form.value.token
    };

    this.gameService.createGame(game).subscribe(resp => {
      console.log(resp);
    })

    alert(`token generated: ${form.value.token}`)
    
    this.router.navigateByUrl("select-game");
  }

}
