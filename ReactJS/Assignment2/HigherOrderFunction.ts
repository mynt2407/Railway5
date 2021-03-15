// VD1
export class exercise8 {
    public Question1(): void {
        const caculate = (a, b, opeation) => {
            return opeation(a, b);
        }
        const multiplier = (a, b) => a * b;
        const sum = (a, b) => a + b;

        let result1 = caculate(2, 3, multiplier);
        let result2 = caculate(2, 3, sum);
        console.log(result1);
        console.log(result2);

    }
}
