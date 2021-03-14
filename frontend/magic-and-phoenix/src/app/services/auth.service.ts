import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginData } from '../interfaces/login-data';
import { User } from '../interfaces/user';
import { CookieService } from "ngx-cookie-service";
import { Auth } from '../interfaces/auth';
import { tap } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url: string = "http://localhost:8082/api/auth/"
  private _auth: Auth | undefined;

  constructor(
    private http: HttpClient,
    private cookies: CookieService
  ) { }

  login(user: LoginData):Observable<any> {
    const url = `${this.url}signin`;
  
    return this.http.post<any>(url, user);

    // //Esto servia, para guardar la variable del login. pero si cierro el navegador y vuelvo a abrir se estropea
    // //por eso voy a llamar los datos con el token que si se guarda
    // .pipe(
    //   tap(resp => {
    //     this._auth = {username: resp.username, userId: resp.id}
    //   })
    // );
    
  }
  getUserId():Observable<number>{
    let token = this.cookies.get("token");
    const url = `${this.url}user-id/${token}`;
    return this.http.get<number>(url);
  }
  getUsername():Observable<any>{
    let token = this.cookies.get("token");
    const url = `${this.url}username/${token}`;
    return this.http.get(url,
      {responseType: 'text'});
  }
  register(user: User):Observable<any> {
    const url = `${this.url}signup`;
    return this.http.post<any>(url,user);
  }
  setToken(token:string) {
    this.cookies.set("token", token);
  }
  getToken(){
    return this.cookies.get("token");
  }
  deleteToken(){
    return this.cookies.delete("token");
  }
}
