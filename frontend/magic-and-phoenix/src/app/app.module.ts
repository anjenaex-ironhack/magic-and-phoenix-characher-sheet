import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

//import cookies service
import { CookieService } from 'ngx-cookie-service';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { PlayerCharacterSheetComponent } from './components/player-character-sheet/player-character-sheet.component';
import { EditableCharacterSheetComponent } from './components/editable-character-sheet/editable-character-sheet.component';
import { MasterMainViewComponent } from './components/master-main-view/master-main-view.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { PlayerMainViewComponent } from './components/player-main-view/player-main-view.component';
import { CreateCharacterSheetComponent } from './components/create-character-sheet/create-character-sheet.component';
import { CreateGameComponent } from './components/create-game/create-game.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    MainViewComponent,
    PlayerCharacterSheetComponent,
    EditableCharacterSheetComponent,
    MasterMainViewComponent,
    NotFoundComponent,
    PlayerMainViewComponent,
    CreateCharacterSheetComponent,
    CreateGameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
