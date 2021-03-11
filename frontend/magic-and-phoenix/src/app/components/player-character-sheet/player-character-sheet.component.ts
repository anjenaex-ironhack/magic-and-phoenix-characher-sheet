import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { Game } from 'src/app/models/game';

@Component({
  selector: 'app-player-character-sheet',
  templateUrl: './player-character-sheet.component.html',
  styleUrls: ['./player-character-sheet.component.sass']
})
export class PlayerCharacterSheetComponent implements OnInit {

   //MetaData
   characterId: number = 0;
   px: number = 0;
 
   form: FormGroup;
 
   userField: FormControl;
   nameField: FormControl;
   racialLineageField: FormControl;
   countryField: FormControl;
   professionField: FormControl;
 
   physicalField: FormControl;
   skillField: FormControl;
   mentalField: FormControl;
   socialField: FormControl;
 
   athleticsField: FormControl;
   knowledgeField: FormControl;
   interpretationField: FormControl;
   perceptionField: FormControl;
   cautionField: FormControl;
   conjurationField: FormControl;
 
 
 
   constructor(
     private router: Router
   ) {
     this.userField = new FormControl('', [Validators.required])
     this.nameField = new FormControl('', [Validators.required])
     this.racialLineageField = new FormControl('', [Validators.required])
     this.countryField = new FormControl('', [Validators.required])
     this.professionField = new FormControl('', [Validators.required])
 
     this.physicalField = new FormControl('', [Validators.required, Validators.max(10), Validators.min(4)])
     this.skillField = new FormControl('', [Validators.required, Validators.max(10), Validators.min(4)])
     this.mentalField = new FormControl('', [Validators.required, Validators.max(10), Validators.min(4)])
     this.socialField = new FormControl('', [Validators.required, Validators.max(10), Validators.min(4)])
 
     this.athleticsField = new FormControl('', [Validators.required, Validators.max(5), Validators.min(0)])
     this.knowledgeField = new FormControl('', [Validators.required, Validators.max(5), Validators.min(0)])
     this.interpretationField = new FormControl('', [Validators.required, Validators.max(5), Validators.min(0)])
     this.perceptionField = new FormControl('', [Validators.required, Validators.max(5), Validators.min(0)])
     this.cautionField = new FormControl('', [Validators.required, Validators.max(5), Validators.min(0)])
     this.conjurationField = new FormControl('', [Validators.required, Validators.max(5), Validators.min(0)])
 
     this.form = new FormGroup({
       user: this.userField,
       name: this.nameField,
       racialLineage: this.racialLineageField,
       country: this.countryField,
       profession: this.professionField,
 
       physical: this.physicalField,
       skill: this.skillField,
       mental: this.mentalField,
       social: this.socialField,
 
       athletics: this.athleticsField,
       knowledge: this.knowledgeField,
       interpretation: this.interpretationField,
       perception: this.perceptionField,
       caution: this.cautionField,
       conjuration: this.conjurationField
     })
    }

  ngOnInit(): void {
  }

  goBack(): void {
    this.router.navigateByUrl("game/:gameId/character-selection");
  }

  getCharacter(characterId: number): void {
      //llamar al servicio character. que me traiga un character por id
      //rellenar la el campo character Id con la id recibida.
      //rellenar todos los campos de los formularios, con la informacion recibida
  }

  //Todos los increase y decrease de create

  updateCharacter(character: Character) {
    //rellenar un character con los datos del formulario 
    //llamar al servicio character. que me actualice el character, con una peticion put.
    //que saque su id y los datos del character
    //Bonus. que al master se le actualice 
  }

}
