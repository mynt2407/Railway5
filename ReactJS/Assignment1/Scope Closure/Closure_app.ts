//tinh binh phuong trong Toan
function makeEx(x) {
    var exponent = x;
    return function (y) {
        return Math.pow(y, exponent);
    }
}
var square = makeEx(2);
console.log(square(3));


//Can bac hai
function canBacHai(a) {
    var number = a;
    return function (b) {
        return Math.pow(b, a);
    }
}

var canbachai = canBacHai(0.5);
console.log(canbachai(9));
