import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Game } from 'src/app/models/game';
import { Character } from '../../interfaces/character';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-create-character-sheet',
  templateUrl: './create-character-sheet.component.html',
  styleUrls: ['./create-character-sheet.component.sass']
})
export class CreateCharacterSheetComponent implements OnInit {

  //MetaData
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  userId: number = 1; 
  px: number = 40;

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


  //Hay que quitarle el tipo a todos los inputs y meterle una validacion para que solo acepte numeros
  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private characterService: CharacterService
  ) {
    this.userField = new FormControl('', [Validators.required])
    this.nameField = new FormControl('', [Validators.required])
    this.racialLineageField = new FormControl('', [Validators.required])
    this.countryField = new FormControl('', [Validators.required])
    this.professionField = new FormControl('', [Validators.required])

    this.physicalField = new FormControl('4', [Validators.required, Validators.max(10), Validators.min(4)])
    this.skillField = new FormControl('4', [Validators.required, Validators.max(10), Validators.min(4)])
    this.mentalField = new FormControl('4', [Validators.required, Validators.max(10), Validators.min(4)])
    this.socialField = new FormControl('4', [Validators.required, Validators.max(10), Validators.min(4)])

    this.athleticsField = new FormControl('0', [Validators.required, Validators.max(5), Validators.min(0)])
    this.knowledgeField = new FormControl('0', [Validators.required, Validators.max(5), Validators.min(0)])
    this.interpretationField = new FormControl('0', [Validators.required, Validators.max(5), Validators.min(0)])
    this.perceptionField = new FormControl('0', [Validators.required, Validators.max(5), Validators.min(0)])
    this.cautionField = new FormControl('0', [Validators.required, Validators.max(5), Validators.min(0)])
    this.conjurationField = new FormControl('0', [Validators.required, Validators.max(5), Validators.min(0)])

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

  increaseAttribute():void {

  }
  decreaseAttribute(): void {

  }

  increaseCommonHability(): void{

  }
  decreaseCommonHability(): void {

  }


  createCharacter(form: FormGroup): void {

    let gameId: number = 0;

    if(this.gameId != null){
      gameId = parseInt(this.gameId.valueOf());
    }

    let character = {
      userId:         this.userId,
      gameId:         gameId,
      name:           form.value.name,
      racialLineage:  form.value.racialLineage.toUpperCase(),
      country:        form.value.country.toUpperCase(),
      profession:     form.value.profession.toUpperCase(),
      px:             this.px,
      physical:       form.value.physical,
      skill:          form.value.skill,
      mental:         form.value.mental,
      social:         form.value.social,
      athletics:      form.value.athletics,
      knowledge:      form.value.knowledge,
      interpretation: form.value.interpretation,
      perception:     form.value.perception,
      caution:        form.value.caution,
      conjuration:    form.value.conjuration
    }

    this.characterService.createCharacter(character).subscribe(resp => {
      console.log(resp)
    })

  }
}
