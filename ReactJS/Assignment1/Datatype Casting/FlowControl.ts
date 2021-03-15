// Question 1:
// Khai báo 1 array có các chữ từ "a" tới "e"
// Hãy in ra các element trong array theo
//  Index
//  Value 

//in ra element
let chars: string[] = ["a", "b", "c", "d", "e"];
chars.forEach(function(value){
    console.log(value);
});

//in ra index
for (let index = 0; index < chars.length; index++) {
    const element = chars[index];
    console.log(index);
}