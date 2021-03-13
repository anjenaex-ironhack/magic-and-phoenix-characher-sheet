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
  //Show a list with all the characters by game
  getCharacterListByGameId(gameId: string | null): Observable<any>{
    const url= `${this.url}characters/game/${gameId}`;
    return this.http.get<any>(url);
  }
  getCharacterById(characterId: string | null ): Observable<any>{
    const url = `${this.url}character/${characterId}`;
    return this.http.get<any>(url);
  }

  //Create a new character
  createCharacter(character: Character): Observable<Character>{
    const url = `${this.url}character`;
    return this.http.post<Character>(url, character);
  }

  //Update character
  updateCharacter(characterId: number, character: Character ): Observable<Character>{
    const url = `${this.url}character/${characterId}`;
    return this.http.put<Character>(url, character);
  }

  //Update px camp from a character by character id
  updateCharacterPx(characterId: number, px: number){
    const url = `${this.url}character/px/${characterId}`;
    const pxDTO = {px: px};
    return this.http.patch(url, pxDTO);
  }
  
}
