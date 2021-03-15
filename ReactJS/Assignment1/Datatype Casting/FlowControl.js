// Question 1:
// Khai báo 1 array có các chữ từ "a" tới "e"
// Hãy in ra các element trong array theo
//  Index
//  Value 
var chars = ["a", "b", "c", "d", "e"];
chars.forEach(function (value) {
    console.log(value);
});
for (var index = 0; index < chars.length; index++) {
    var element = chars[index];
    console.log(index);
}
