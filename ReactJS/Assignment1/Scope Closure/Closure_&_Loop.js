var timer = function (i) {
    setTimeout(function timer() {
        console.log(i);
    }, i * 1000);
};
for (var i = 1; i <= 6; i++) {
    timer(i);
}
