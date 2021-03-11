import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game';
import { GameDTO } from '../dto/game-dto';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  readonly url: string = "";
  userId:number = 0;

  constructor(
    private http: HttpClient
  ) { }
  
  //A list with all the games in witch an user participate, as master of as player
  showUserGames(userId: number): Observable<Game[]>{
    const url = this.url +userId;
    return this.http.get<Game[]>(url)
  }

  //Get a game by id

  //Create a new game
  createGame(gameDTO: GameDTO): Observable<any>{
    const url = this.url;
    return this.http.post<any>(url, gameDTO);
  }

  //update the gameList[] input from the User, to add a new game to the user
  joinGame(userId: number, token: String): Observable<any>{
    const url = this.url;
    return this.http.patch<any>(url, token)
  }
}
