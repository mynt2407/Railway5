// Khai báo biến fullName và function hello() để in ra fullName theo 3
// cách
// a) Khai báo fullName là Global scope
// b) Khai báo fullName là Function scope
// c) Khai báo fullName là Lexical Scop
//a
var fullName = "Nguyen Van A";
function hello() {
    console.log(fullName);
}
hello();
//b
// fullName = "Nguyen Van B";
// var fullName;
// function hello() {
//     console.log(fullName);
// }
// hello();
//c
// var fullName = "Nguyen Van C";
// console.log(fullName);
// var fullName = "Nguyen Van C";
// console.log(fullName);
