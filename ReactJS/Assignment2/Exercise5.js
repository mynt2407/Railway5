//Exercise 5: Parameter
//Question 1: khai báo 1 function multiply() có 2 tham số a,b. Và có b có default value
var multiply = function (a, b) {
    if (b === void 0) { b = 1; }
    return a * b;
};
console.log(multiply(5, 3));
console.log(multiply(5));
//Question 2: khai báo 1 function multiply() có tham số không giới hạn 
var numbers = [];
var multiply1 = function () {
    var numbers = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        numbers[_i] = arguments[_i];
    }
    for (var index = 0; index < numbers.length; index++) {
        var a = numbers[index] * numbers[index + 1];
    }
};
console.log(multiply1(2, 4));
console.log(multiply1(2));
//console.log(multiply1(3, 5, 5, 6));
// Question 3: khai báo 1 function printInformation() có 2 tham số name, email.
// Và có email là optional parameter
var printInformation = function (name, email) {
    if (email != null || email != undefined) {
        console.log("T\u00F4i l\u00E0 " + name + " email c\u1EE7a t\u00F4i l\u00E0 " + email);
    }
    else {
        console.log("T\u00F4i l\u00E0 " + name + " v\u00E0 t\u00F4i ch\u01B0a c\u00F3 email ");
    }
};
printInformation("Nam", "nam123@gmail.com");
printInformation("Nam");
