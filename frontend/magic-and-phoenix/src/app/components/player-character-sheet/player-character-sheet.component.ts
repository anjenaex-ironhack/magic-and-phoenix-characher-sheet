import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { Game } from 'src/app/models/game';
import { CharacterService } from 'src/app/services/character.service';
import { CharacterAttributes } from 'src/app/utils/character-attributes';
import { CharacterCommonAbilities } from 'src/app/utils/character-common-abilities';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-player-character-sheet',
  templateUrl: './player-character-sheet.component.html',
  styleUrls: ['./player-character-sheet.component.sass']
})
export class PlayerCharacterSheetComponent implements OnInit {


  //MetaData
  gameId: string | null = this.activatedRoute.snapshot.paramMap.get('gameId');
  characterId: string | null = this.activatedRoute.snapshot.paramMap.get('characterId');
  userId: number = 1;
  username: string = "";
  px: number = 40;

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
    this.init();
    
  }

  init() {

    this.authService.getUserId().subscribe(resp => {
      this.userId =  resp;
      this.getCharacter(this.characterId);
      
    });
    this.authService.getUsername().subscribe(resp => {
      this.username = resp;
    });
    
  }
  logout():void {
    this.authService.deleteToken();
  
  
    this.router.navigateByUrl("/login");
  }

  increasePhysical(): void {
    let physical: number[] = CharacterAttributes.increaseAttribute(this.physicalActualValue, 10, this.px)
    this.form.controls.physical.setValue(physical[0]);
    this.px = physical[1];
    this.physicalActualValue = this.form.value.physical;
    console.log(this.physicalActualValue)
  }
  decreasePhysical(): void {
    let physical: number[] = CharacterAttributes.decreaseAttribute(this.physicalActualValue, this.physicalStartingValue, this.px)
    this.form.controls.physical.setValue(physical[0]);
    this.px = physical[1];
    this.physicalActualValue = this.form.value.physical;
  }
  increaseSkill(): void {
    let skill: number[] = CharacterAttributes.increaseAttribute(this.skillActualValue, 10, this.px)
    this.form.controls.skill.setValue(skill[0]);
    this.px = skill[1];
    this.skillActualValue = this.form.value.skill;
  }
  decreaseSkill(): void {
    let skill: number[] = CharacterAttributes.decreaseAttribute(this.skillActualValue, this.skillStartingValue, this.px)
    this.form.controls.skill.setValue(skill[0]);
    this.px = skill[1];
    this.skillActualValue = this.form.value.skill;
  }
  increaseMental(): void {
    let mental: number[] = CharacterAttributes.increaseAttribute(this.mentalActualValue, 10, this.px)
    this.form.controls.mental.setValue(mental[0]);
    this.px = mental[1];
    this.mentalActualValue = this.form.value.mental;
  }
  decreaseMental(): void {
    let mental: number[] = CharacterAttributes.decreaseAttribute(this.mentalActualValue, this.mentalStartingValue, this.px)
    this.form.controls.mental.setValue(mental[0]);
    this.px = mental[1];
    this.mentalActualValue = this.form.value.mental;
  }
  increaseSocial(): void {
    let social: number[] = CharacterAttributes.increaseAttribute(this.socialActualValue, 10, this.px)
    this.form.controls.social.setValue(social[0]);
    this.px = social[1];
    this.socialActualValue = this.form.value.social;
  }
  decreaseSocial(): void {
    let social: number[] = CharacterAttributes.decreaseAttribute(this.socialActualValue, this.socialStartingValue, this.px)
    this.form.controls.social.setValue(social[0]);
    this.px = social[1];
    this.socialActualValue = this.form.value.social;
  }

  increaseAthletics(): void {
    let ability: number[] = CharacterCommonAbilities.increaseCommonAbility(this.athleticsActualValue, 5, this.px)
    this.form.controls.athletics.setValue(ability[0]);
    this.px = ability[1];
    this.athleticsActualValue = this.form.value.athletics;
  }
  decreaseAthletics(): void {
    let ability: number[] = CharacterCommonAbilities.decreaseCommonAbility(this.athleticsActualValue, 0, this.px)
    this.form.controls.athletics.setValue(ability[0]);
    this.px = ability[1];
    this.athleticsActualValue = this.form.value.athletics;
  }

  increaseKnowledge(): void {
    let ability: number[] = CharacterCommonAbilities.increaseCommonAbility(this.knowledgeActualValue, 5, this.px)
    this.form.controls.knowledge.setValue(ability[0]);
    this.px = ability[1];
    this.knowledgeActualValue = this.form.value.knowledge;
  }
  decreaseKnowledge(): void {
    let ability: number[] = CharacterCommonAbilities.decreaseCommonAbility(this.knowledgeActualValue, 0, this.px)
    this.form.controls.knowledge.setValue(ability[0]);
    this.px = ability[1];
    this.knowledgeActualValue = this.form.value.knowledge
  }
  increaseInterpretation(): void {
    let ability: number[] = CharacterCommonAbilities.increaseCommonAbility(this.interpretationActualValue, 5, this.px)
    this.form.controls.interpretation.setValue(ability[0]);
    this.px = ability[1];
    this.interpretationActualValue = this.form.value.interpretation;
  }
  decreaseInterpretation(): void {
    let ability: number[] = CharacterCommonAbilities.decreaseCommonAbility(this.interpretationActualValue, 0, this.px)
    this.form.controls.interpretation.setValue(ability[0]);
    this.px = ability[1];
    this.interpretationActualValue = this.form.value.interpretation;
  }
  increasePerception(): void {
    let ability: number[] = CharacterCommonAbilities.increaseCommonAbility(this.perceptionActualValue, 5, this.px)
    this.form.controls.perception.setValue(ability[0]);
    this.px = ability[1];
    this.perceptionActualValue = this.form.value.perception;
  }
  decreasePerception(): void {
    let ability: number[] = CharacterCommonAbilities.decreaseCommonAbility(this.perceptionActualValue, 0, this.px)
    this.form.controls.perception.setValue(ability[0]);
    this.px = ability[1];
    this.perceptionActualValue = this.form.value.perception;
  }
  increaseCaution(): void {
    let ability: number[] = CharacterCommonAbilities.increaseCommonAbility(this.cautionActualValue, 5, this.px)
    this.form.controls.caution.setValue(ability[0]);
    this.px = ability[1];
    this.cautionActualValue = this.form.value.caution;
  }
  decreaseCaution(): void {
    let ability: number[] = CharacterCommonAbilities.decreaseCommonAbility(this.cautionActualValue, 0, this.px)
    this.form.controls.caution.setValue(ability[0]);
    this.px = ability[1];
    this.cautionActualValue = this.form.value.caution;
  }
  increaseConjuration(): void {
    let ability: number[] = CharacterCommonAbilities.increaseCommonAbility(this.conjurationActualValue, 5, this.px)
    this.form.controls.conjuration.setValue(ability[0]);
    this.px = ability[1];
    this.conjurationActualValue = this.form.value.conjuration;
  }
  decreaseConjuration(): void {
    let ability: number[] = CharacterCommonAbilities.decreaseCommonAbility(this.conjurationActualValue, 0, this.px)
    this.form.controls.conjuration.setValue(ability[0]);
    this.px = ability[1];
    this.conjurationActualValue = this.form.value.conjuration;
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
      px: this.px,
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

        this.px = resp.px;

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

  deleteCharacter(characterId: string | null): void {
    this.characterService.deleteCharacter(characterId).subscribe(resp => {
      console.log( `character with name ${this.name}`);
    })
  }

}
