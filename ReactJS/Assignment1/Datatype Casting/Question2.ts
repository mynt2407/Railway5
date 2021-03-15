//Question 2
// Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//     có số 0 ở đầu cho đủ 5 chữ số)

let random = Math.floor(Math.random() * (99999 - 0 + 1)) + 0;
console.log(random);
let numberString :string = random.toString();
let x= numberString.length;

switch (x) {
    case 1:
        console.log("0000" + x);
        break;

    case 2:
        console.log("000" + x);
        break;
    case 3:
        console.log("00" + x);
        break;
    case 4:
        console.log("0" + x);
        break;
    default:
        console.log(x);
        break;
}

// Question 3:
// Lấy 2 số cuối của số ở Question 2 và in ra
let y: string = numberString.charAt(4);
let z: string = numberString.charAt(5);
let k: string = y + z;
console.log(k);
