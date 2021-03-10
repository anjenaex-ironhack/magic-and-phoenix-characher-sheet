import { User } from "./user";

export class Character {
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
        private _id: number,
        private _name: string,
        private _user: User
    ){

    }
}
