import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Game } from '../models/game';
import { Observable } from 'rxjs';
import { CharacterDTO } from '../dto/character-dto';
import { Character } from '../interfaces/character';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  url: string = "http://localhost:8080/";

  constructor(
    private http: HttpClient
  ) { }
    
  //Show a list with all the characters by game and user id
  getPlayerCharacterList(gameId: string | null, userId: number): Observable<any>{
    const url = `${this.url}characters/game/${gameId}/player/${userId}`;
    return this.http.get<any>(url);
  }

  //Create a new character
  createCharacter(character: Character): Observable<Character>{
    const url = `${this.url}character`;
    return this.http.post<Character>(url, character);
  }
  
}
