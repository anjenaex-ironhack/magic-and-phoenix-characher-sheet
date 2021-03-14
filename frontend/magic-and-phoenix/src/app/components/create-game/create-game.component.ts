import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GameDTO } from '../../dto/game-dto'
import { GameService } from '../../services/game.service';
import { AuthService } from '../../services/auth.service';

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
  name: string = "";
  userId: number = 0;

  constructor(
    private router: Router,
    private gameService: GameService,
    private authService: AuthService
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
      
    })

    alert(`token generated: ${form.value.token}`)
    
    this.router.navigateByUrl("select-game");
  }

}
