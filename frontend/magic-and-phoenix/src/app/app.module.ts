import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { PlayerCharacterSheetComponent } from './components/player-character-sheet/player-character-sheet.component';
import { EditableCharacterSheetComponent } from './components/editable-character-sheet/editable-character-sheet.component';
import { MasterMainViewComponent } from './components/master-main-view/master-main-view.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    MainViewComponent,
    PlayerCharacterSheetComponent,
    EditableCharacterSheetComponent,
    MasterMainViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
