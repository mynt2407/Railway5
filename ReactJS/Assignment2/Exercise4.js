// export class exercise4 {
//     public Question1(): void {
//         var function1 =  a =>{
//             return a + 100;
//             console.log(function1);
//         }
//         function1(10);
//     }
// }
//B1: Ko có keyword function
var case1 = function (a) {
    return a + 100;
};
console.log(case1(10));
var hello = function (name) { return console.log("Chao " + name); };
hello("My");
//B2: Không có dấu {} và keyword return trong function body
var anyString = ["sql", "sql Server", "java"];
anyString.map(function (val, key) {
    console.log(val.toUpperCase());
});
// Question 2:
// Convert function sau về Arrow Function ngắn nhất có thể:
// picture a
var function1 = function (a, b) { return (a + b + 100); };
console.log(function1(20, 3));
// picture c
var function3 = function (a) {
    return a + 10;
};
console.log(function3(1));
