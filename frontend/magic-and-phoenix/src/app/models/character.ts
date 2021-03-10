import { Game } from "./game";
import { User } from "./user";

export class Character {
    public get gameIdList(): Game[] {
        return this._gameIdList;
    }
    public set gameIdList(value: Game[]) {
        this._gameIdList = value;
    }
    public get conjuration(): number {
        return this._conjuration;
    }
    public set conjuration(value: number) {
        this._conjuration = value;
    }
    public get caution(): number {
        return this._caution;
    }
    public set caution(value: number) {
        this._caution = value;
    }
    public get perception(): number {
        return this._perception;
    }
    public set perception(value: number) {
        this._perception = value;
    }
    public get interpretation(): number {
        return this._interpretation;
    }
    public set interpretation(value: number) {
        this._interpretation = value;
    }
    public get knowledge(): number {
        return this._knowledge;
    }
    public set knowledge(value: number) {
        this._knowledge = value;
    }
    public get athletics(): number {
        return this._athletics;
    }
    public set athletics(value: number) {
        this._athletics = value;
    }
    public get social(): number {
        return this._social;
    }
    public set social(value: number) {
        this._social = value;
    }
    public get skill(): number {
        return this._skill;
    }
    public set skill(value: number) {
        this._skill = value;
    }
    public get mental(): number {
        return this._mental;
    }
    public set mental(value: number) {
        this._mental = value;
    }
    public get physical(): number {
        return this._physical;
    }
    public set physical(value: number) {
        this._physical = value;
    }
    public get px(): number {
        return this._px;
    }
    public set px(value: number) {
        this._px = value;
    }
    public get profession(): String {
        return this._profession;
    }
    public set profession(value: String) {
        this._profession = value;
    }
    public get country(): String {
        return this._country;
    }
    public set country(value: String) {
        this._country = value;
    }
    public get racialLineage(): String {
        return this._racialLineage;
    }
    public set racialLineage(value: String) {
        this._racialLineage = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get user(): User {
        return this._user;
    }
    public set user(value: User) {
        this._user = value;
    }

    constructor(

        //MetaData
        private _id: number,
        private _gameIdList: Game[],

        //Basic info
        private _user: User,
        private _name: string,
        private _racialLineage: String,
        private _country: String,
        private _profession: String,

        //Px, can only be giving by the master
        private _px: number,

        //Attributes
        private _physical: number,
        private _skill: number,
        private _mental: number,
        private _social: number,

        //The list with the common aptitudes

        private _athletics: number,
        private _knowledge: number,
        private _interpretation: number,
        private _perception: number,
        private _caution: number,
        private _conjuration: number


    ){

    }
}

