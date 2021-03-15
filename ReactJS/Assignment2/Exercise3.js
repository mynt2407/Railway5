"use strict";
var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
exports.__esModule = true;
exports.exercise3 = void 0;
var exercise3 = /** @class */ (function () {
    function exercise3() {
    }
    exercise3.prototype.Question1 = function () {
        var arr1 = [2, 4, 6, 8, 10];
        var arr2 = __spreadArrays(arr1, [5, 7, 9]);
        console.log(arr2);
    };
    exercise3.prototype.Question3 = function () {
        var cold = ["autumn", "winter"];
        var warm = ["spring", "summer"];
        var seasons = __spreadArrays(cold, warm);
        console.log(seasons);
    };
    return exercise3;
}());
exports.exercise3 = exercise3;
