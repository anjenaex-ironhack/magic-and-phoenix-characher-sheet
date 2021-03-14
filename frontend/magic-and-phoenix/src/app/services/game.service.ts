import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game';
import { GameDTO } from '../dto/game-dto';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  readonly url: string = "http://localhost:8081/";


  constructor(
    private http: HttpClient
  ) { }

  //A list with all the games in witch an user participate as player
  showUserGames(userId: number): Observable<GameDTO[]> {
    const url = `${this.url}games/user-id/${userId}`;
    return this.http.get<GameDTO[]>(url);
  }

  //A list with all the games in witch an user participate as master
  showMasterGames(userId: number): Observable<GameDTO[]> {
    const url = `${this.url}games/master-id/${userId}`;
    return this.http.get<GameDTO[]>(url);
  }

  //Create a new game
  createGame(game: any): Observable<any> {
    const url = `${this.url}game`;
    return this.http.post<any>(url, game);
  }

  //Find a list of game by game name to have the posibility to join
  findGameToJoin(name: string): Observable<GameDTO[]> {
    const url = `${this.url}/games/name/${name}`;
    return this.http.get<GameDTO[]>(url);
  }

  //update the gameList[] input from the User, to add a new game to the user
  joinGame(gameId: number, userId: number): Observable<any> {
    const url = `${this.url}/game/${gameId}/add-player`;
    const userIdDTO = {
      userId: userId
    }
    return this.http.patch<any>(url, userIdDTO)
  }
}
