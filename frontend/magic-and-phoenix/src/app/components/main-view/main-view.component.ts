import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from 'src/app/models/game';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GameService } from '../../services/game.service';
import { GameDTO } from 'src/app/dto/game-dto';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.sass']
})
export class MainViewComponent implements OnInit {

  name: string = "Antonio";
  gameListAsMaster: GameDTO[] = [];
  gameListAsPlayer: GameDTO[] = [];
  gameListToJoin: GameDTO[] = [];

  //Este id tiene que venir del login
  userId: number =  1;

  form: FormGroup;
  findGameForm: FormGroup;

  tokenField: FormControl;
  nameField: FormControl;

  constructor(
    private gameService: GameService,
    private router:Router
  ) {
    this.tokenField = new FormControl('', [Validators.required]);
    this.nameField = new FormControl('', [Validators.required]);

    this.form = new FormGroup ({
      token: this.tokenField
    })

    this.findGameForm = new FormGroup({
      name : this.nameField
    })
   }

  ngOnInit(): void {
    this.showGameListAsMaster(this.userId);
    this.showGameListAsPlayer(this.userId);
  }

  checkGameToJoin(name: string): boolean {

    let check: boolean = true;

    this.gameListAsMaster.forEach(resp => {
      if(resp.name === name) {
        alert("you are the master of this game!!!!");
        check = false;
      }
    });
    this.gameListAsPlayer.forEach(resp => {
      if(resp.name === name){
        alert("you already joined this game :D");
      check = false;
      }  
    });

    return check;
  }

  findGameToJoin(findGameForm: FormGroup): void{
    
    let name: string = findGameForm.value.name;

    if(this.checkGameToJoin(name)) {
      this.gameService.findGameToJoin(name).subscribe(resp => {
        this.gameListToJoin =  resp;
      })
    }else {
      
    }
    
  }

  joinGame(form: FormGroup, index: number): void {

    let token = form.value.token;

    if(this.gameListToJoin[index].token === token) {
      this.gameService.joinGame(this.gameListToJoin[index].id, this.userId).subscribe(resp => {
        console.log(resp)
      })
      this.gameListAsPlayer.push(this.gameListToJoin[index]);
    }else {
      alert("wrong token");
    }

  }

  showGameListAsPlayer(userId: number):void{

    this.gameService.showUserGames(this.userId).subscribe(resp => {
      this.gameListAsPlayer = resp
      
    });
    
  }

  showGameListAsMaster(userId: number):void{

    this.gameService.showMasterGames(this.userId).subscribe(resp => {
      this.gameListAsMaster = resp
      
    });
    
  }

  goToCreateGame(): void {
    this.router.navigateByUrl("create-game")
  }
  
}
