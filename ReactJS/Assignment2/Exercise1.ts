
export class exercise1 {
    public Question1(): void {
        var date: number[] = [20, 10, 2020];
        var [day, , year] = date;
        console.log(day);
        console.log(year);
    }

    public Question2(): void {
        const people = {
            firstName: "nguyen",
            lastName: "My",
            age: 20
        };
        var { firstName: f, lastName:l } = people;
        console.log(f);
        console.log(l);
    }
}