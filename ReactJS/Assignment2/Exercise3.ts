export class exercise3 {
    // Gop 2 array
    public Question1(): void {
        var arr1: number[] = [2, 4, 6, 8, 10];
        var arr2: number[] = [...arr1, 5, 7, 9];
        console.log(arr2);
    }

    public Question3(): void {
        let cold: string[] = ["autumn", "winter"];
        let warm: string[] = ["spring", "summer"];
        let seasons:string[] = [...cold,...warm];
        console.log(seasons);
    }
}