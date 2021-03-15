"use strict";
exports.__esModule = true;
exports.exercise1 = void 0;
var exercise1 = /** @class */ (function () {
    function exercise1() {
    }
    exercise1.prototype.Question1 = function () {
        var date = [20, 10, 2020];
        var day = date[0], year = date[2];
        console.log(day);
        console.log(year);
    };
    exercise1.prototype.Question2 = function () {
        var people = {
            firstName: "nguyen",
            lastName: "a",
            age: 20
        };
        var f = people.firstName, l = people.lastName;
        console.log(f);
        console.log(l);
    };
    return exercise1;
}());
exports.exercise1 = exercise1;
