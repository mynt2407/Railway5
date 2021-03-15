"use strict";
exports.__esModule = true;
exports.Position = void 0;
var Position = /** @class */ (function () {
    function Position(name) {
        this.id = ++Position.counter;
        this.name = name;
    }
    /**
     * Getter id
     * @return {number}
     */
    Position.prototype.getId = function () {
        return this.id;
    };
    /**
     * Getter name
     * @return {PositionName}
     */
    Position.prototype.getName = function () {
        return this.name;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Position.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter name
     * @param {PositionName} value
     */
    Position.prototype.setName = function (value) {
        this.name = value;
    };
    Position.counter = 0;
    return Position;
}());
exports.Position = Position;
