import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { MasterMainViewComponent } from './components/master-main-view/master-main-view.component';
import { EditableCharacterSheetComponent } from './components/editable-character-sheet/editable-character-sheet.component';
import { PlayerCharacterSheetComponent } from './components/player-character-sheet/player-character-sheet.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { PlayerMainViewComponent } from './components/player-main-view/player-main-view.component';
import { CreateCharacterSheetComponent } from './components/create-character-sheet/create-character-sheet.component';

const routes: Routes = [

  //login
{
  path: "login",
  component: LoginComponent
},
  //register
{
  path: "register",
  component: RegisterComponent
},
  //This patch show the games of a player, also the posibility to create a new one
{
  path: "select-game",
  component: MainViewComponent
},
{
  path: "game/:gameId/master/character-selection",
  component: MasterMainViewComponent
},
//This patch show a character sheet to the master, and can be edited
{
  path: "game/:gameId/master/character/:characterId",
  component: EditableCharacterSheetComponent
},
// this patch show a character list to the player, you can also create one
{
  path: "game/:gameId/character-selection",
  component: PlayerMainViewComponent
},
{
  path: "game/:gameId/character/create",
  component: CreateCharacterSheetComponent
},
// This patch show the character to the player, can only be updated in relation to the px
{
  path: "game/:gameId/character/:characterId",
  component: PlayerCharacterSheetComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
