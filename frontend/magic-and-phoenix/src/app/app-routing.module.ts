import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { MasterMainViewComponent } from './components/master-main-view/master-main-view.component';
import { EditableCharacterSheetComponent } from './components/editable-character-sheet/editable-character-sheet.component';
import { PlayerCharacterSheetComponent } from './components/player-character-sheet/player-character-sheet.component';

const routes: Routes = [
{
  path: "login",
  component: LoginComponent
},
{
  path: "register",
  component: RegisterComponent
},
{
  path: "select-game",
  component: MainViewComponent
},
{
  path: "game/:gameId/master/select-character",
  component: MasterMainViewComponent
},
{
  path: "game/:gameId/master/select-character/:characterId",
  component: EditableCharacterSheetComponent
},
{
  path: "game/:gameId",
  component: PlayerCharacterSheetComponent
},
{
  path:"**",
  component: LoginComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
