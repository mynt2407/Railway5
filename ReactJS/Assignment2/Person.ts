class Person {
    private name: string;
    private country: string;
    private isMale: boolean;

    constructor(name: string, country: string, isMale: boolean) {
        this.name = name;
        this.country = country;
        this.isMale = isMale;
    }


    public getName(): string {
        return this.name;
    }


    public getCountry(): string {
        return this.country;
    }


    public getIsMale(): boolean {
        return this.isMale;
    }


    public setName(value: string) {
        this.name = value;
    }


    public setCountry(value: string) {
        this.country = value;
    }


    public setIsMale(value: boolean) {
        this.isMale = value;
    }
}
export const persons: Person[] = [
    new Person("A", "Vietnam", true),
    new Person("B", "USA", false),
    new Person("C", "Vietnam", false)
]