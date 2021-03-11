import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Game } from '../models/game';
import { Observable } from 'rxjs';
import { CharacterDTO } from '../dto/character-dto';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  url: string = ""
  userId: string = ""

  constructor(
    private http: HttpClient
  ) { }
    
  //Show a list with all the characters by game and user id
  getCharacterList(): Observable<any>{
    const url = this.url;
    return this.http.get<Game[]>(url)
  }

  //Create a new character
  createCharacter(characterDTO: CharacterDTO): Observable<any>{
    const url = this.url;
    return this.http.post<any>(url, characterDTO);
  }
  
}
