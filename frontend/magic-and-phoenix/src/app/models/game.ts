import { User } from "./user";


export class Game {
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get userList(): User[] {
        return this._userList;
    }
    public set userList(value: User[]) {
        this._userList = value;
    }
    public get master(): User {
        return this._master;
    }
    public set master(value: User) {
        this._master = value;
    }
    public get name(): String {
        return this._name;
    }
    public set name(value: String) {
        this._name = value;
    }
    constructor(
        private _id: number,
        private _name: String,
        private _master: User,
        private _userList: User[]
    ){
    }
}
