import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url: string = "http://localhost:8082/api/auth/"

  constructor(
    private http: HttpClient
  ) { }

  login(user: User):Observable<any> {
    const url = `${this.url}/login`;
    return this.http.post(url, user);
  }
}
