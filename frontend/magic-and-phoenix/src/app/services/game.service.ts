import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  readonly url: string = "";

  constructor(
    private http: HttpClient
  ) { }

  showUserGames(id: number): Observable<Game[]>{
    const url = this.url;
    return this.http.get<Game[]>(url)
  }
}
