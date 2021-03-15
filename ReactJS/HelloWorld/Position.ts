import { PositionName } from "./PositionName";

export class Position {

    private static counter: number = 0;

    private id: number;
    private name: PositionName;

    constructor(name: PositionName) {
        this.id = ++Position.counter;
        this.name = name;
    }


    /**
     * Getter id
     * @return {number}
     */
    public getId(): number {
        return this.id;
    }

    /**
     * Getter name
     * @return {PositionName}
     */
    public getName(): PositionName {
        return this.name;
    }

    /**
     * Setter id
     * @param {number} value
     */
    public setId(value: number) {
        this.id = value;
    }

    /**
     * Setter name
     * @param {PositionName} value
     */
    public setName(value: PositionName) {
        this.name = value;
    }

}