export class GameDTO {
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get masterId(): number {
        return this._masterId;
    }
    public set masterId(value: number) {
        this._masterId = value;
    }
    public get token(): string {
        return this._token;
    }
    public set token(value: string) {
        this._token = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }


    constructor(
        private _id: number,
        private _name: string,
        private _masterId: number,
        private _token: string
    ){

    }
}
