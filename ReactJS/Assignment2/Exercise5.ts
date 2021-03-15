//Exercise 5: Parameter
//Question 1: khai báo 1 function multiply() có 2 tham số a,b. Và có b có default value

var multiply = (a: number, b: number = 1) => {
    return a * b;
}
console.log(multiply(5, 3));
console.log(multiply(5));

//Question 2: khai báo 1 function multiply() có tham số không giới hạn 

var numbers: number[] = [];
var multiply1 = (...numbers) => {
    for (let index = 0; index < numbers.length; index++) {
        var a = numbers[index] * numbers[index + 1];
    }
}
console.log(multiply1(2, 4));
console.log(multiply1(2));
console.log(multiply1(3, 5, 5, 6));


// Question 3: khai báo 1 function printInformation() có 2 tham số name, email.
// Và có email là optional parameter
var printInformation = (name: string, email?: string) => {
    if (email != null || email != undefined) {
        console.log(`Tôi là ${name} email của tôi là ${email}`);
    } else {
        console.log(`Tôi là ${name} và tôi chưa có email `);
    }
}
printInformation("Nam", "nam123@gmail.com");
printInformation("Nam");