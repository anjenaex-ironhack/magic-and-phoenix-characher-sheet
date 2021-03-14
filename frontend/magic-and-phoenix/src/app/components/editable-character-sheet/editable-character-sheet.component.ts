import { Component, OnInit } from '@angular/core';
import { FormControl, FormControlName, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { CharacterService } from 'src/app/services/character.service';
import { CharacterAttributes } from 'src/app/utils/character-attributes';
import { CharacterCommonAbilities } from 'src/app/utils/character-common-abilities';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-editable-character-sheet',
  templateUrl: './editable-character-sheet.component.html',
  styleUrls: ['./editable-character-sheet.component.sass']
})
export class EditableCharacterSheetComponent implements OnInit {

  playerName ="";
  //MetaData
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  characterId: string | null = this.activatedRoute.snapshot.paramMap.get('characterId');
  userId: number = 0;  

  //Basic info Moment dependant Attributes
  name: string = "Name not found";
  racialLineaje: string = "Racial lineaje not found";
  country: string = "Country not found";
  profession: string = "Profession not found";

  //Attribute Moment dependant Attributes
  physicalStartingValue: number = 4;
  physicalActualValue: number = this.physicalStartingValue;
  skillStartingValue: number = 4;
  skillActualValue: number = this.skillStartingValue;
  mentalStartingValue: number = 4;
  mentalActualValue: number = this.mentalStartingValue;
  socialStartingValue: number = 4;
  socialActualValue: number = this.socialStartingValue;
  //Common Abilities Moment depdendan Attributes
  athleticsStartingValue: number = 0;
  athleticsActualValue: number = this.athleticsStartingValue;
  knowledgeStartingValue: number = 0;
  knowledgeActualValue: number = this.knowledgeStartingValue;
  interpretationStartingValue: number = 0;
  interpretationActualValue: number = this.interpretationStartingValue;
  perceptionStartingValue: number = 0;
  perceptionActualValue: number = this.perceptionStartingValue;
  cautionStartingValue: number = 0;
  cautionActualValue: number = this.cautionStartingValue;
  conjurationStartingValue: number = 0;
  conjurationActualValue: number = this.conjurationStartingValue;



  //FormData
  form: FormGroup;

  pxField: FormControl;

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
    private characterService: CharacterService,
    private authService: AuthService
  ) {

    this.pxField = new FormControl('', [Validators.required])

    this.nameField = new FormControl(this.name, [Validators.required])
    this.racialLineageField = new FormControl(this.racialLineaje, [Validators.required])
    this.countryField = new FormControl(this.country, [Validators.required])
    this.professionField = new FormControl(this.profession, [Validators.required])

    this.physicalField = new FormControl(this.physicalActualValue, [Validators.required, Validators.max(10), Validators.min(4)])
    this.skillField = new FormControl(this.skillActualValue, [Validators.required, Validators.max(10), Validators.min(4)])
    this.mentalField = new FormControl(this.mentalActualValue, [Validators.required, Validators.max(10), Validators.min(4)])
    this.socialField = new FormControl(this.socialActualValue, [Validators.required, Validators.max(10), Validators.min(4)])

    this.athleticsField = new FormControl(this.athleticsActualValue, [Validators.required, Validators.max(5), Validators.min(0)])
    this.knowledgeField = new FormControl(this.knowledgeActualValue, [Validators.required, Validators.max(5), Validators.min(0)])
    this.interpretationField = new FormControl(this.interpretationActualValue, [Validators.required, Validators.max(5), Validators.min(0)])
    this.perceptionField = new FormControl(this.perceptionActualValue, [Validators.required, Validators.max(5), Validators.min(0)])
    this.cautionField = new FormControl(this.cautionActualValue, [Validators.required, Validators.max(5), Validators.min(0)])
    this.conjurationField = new FormControl(this.conjurationActualValue, [Validators.required, Validators.max(5), Validators.min(0)])

    this.form = new FormGroup({

      px: this.pxField,

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
    this.getCharacter(this.characterId);
    this.init
  }

  init() {

    this.authService.getUserId().subscribe(resp => {
      this.userId =  resp;
    });
    this.authService.getUsername().subscribe(resp => {
      this.name = resp;
    });
    
  }
  logout():void {
    this.authService.deleteToken();
    this.router.navigateByUrl("/login");
  }

  updateCharacter(form: FormGroup): void {

    let gameId: number = 0;

  if(this.gameId != null){
  gameId = parseInt(this.gameId.valueOf());
}

    let characterId: string | null = this.characterId;
    let characterIdNumber: number = 0;

    if (this.characterId != null) {
      characterIdNumber = parseInt(this.characterId.valueOf());
    }

    let character = {
      userId: this.userId,
      gameId: gameId,
      name: form.value.name,
      racialLineage: form.value.racialLineage.toUpperCase(),
      country: form.value.country.toUpperCase(),
      profession: form.value.profession.toUpperCase(),
      px: form.value.px,
      physical: form.value.physical,
      skill: form.value.skill,
      mental: form.value.mental,
      social: form.value.social,
      athletics: form.value.athletics,
      knowledge: form.value.knowledge,
      interpretation: form.value.interpretation,
      perception: form.value.perception,
      caution: form.value.caution,
      conjuration: form.value.conjuration
    }

    this.characterService.updateCharacter(characterIdNumber, character).subscribe(resp => {
      console.log(resp);
    })

  }

  getCharacter(characterId: string | null): void {
      //llamar al servicio character. que me traiga un character por id
      //rellenar la el campo character Id con la id recibida.
      //rellenar todos los campos de los formularios, con la informacion recibida
      this.characterService.getCharacterById(this.characterId).subscribe(resp => {

        this.form.controls.px.setValue(resp.px);

        this.form.controls.name.setValue(resp.name);
        this.form.controls.racialLineage.setValue(resp.racialLineage);
        this.form.controls.country.setValue(resp.country);
        this.form.controls.profession.setValue(resp.profession);

        this.form.controls.physical.setValue(resp.physical);
        this.physicalActualValue = resp.physical;
        this.form.controls.skill.setValue(resp.skill);
        this.skillActualValue = resp.skill;
        this.form.controls.mental.setValue(resp.mental);
        this.mentalActualValue = resp.mentalM
        this.form.controls.social.setValue(resp.social);
        this.socialActualValue = resp.social;

        this.form.controls.athletics.setValue(resp.athletics);
        this.athleticsActualValue = resp.athletics;
        this.form.controls.knowledge.setValue(resp.knowledge);
        this.knowledgeActualValue = resp.knowledge;
        this.form.controls.interpretation.setValue(resp.interpretation);
        this.interpretationActualValue = resp.interpretation;
        this.form.controls.perception.setValue(resp.perception);
        this.perceptionActualValue = resp.perception;
        this.form.controls.caution.setValue(resp.caution);
        this.cautionActualValue = resp.caution;
        this.form.controls.conjuration.setValue(resp.conjuration);
        this.conjurationActualValue = resp.conjuration;
      })
  }


}