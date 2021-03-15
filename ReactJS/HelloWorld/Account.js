"use strict";
exports.__esModule = true;
exports.Account = void 0;
var Account = /** @class */ (function () {
    function Account(email, username, fullname, departmentId, positionId, createDate) {
        this.accountId = ++Account.counter;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.createDate = createDate;
    }
    /**
     * Getter accountId
     * @return {number}
     */
    Account.prototype.getAccountId = function () {
        return this.accountId;
    };
    /**
     * Getter email
     * @return {string}
     */
    Account.prototype.getEmail = function () {
        return this.email;
    };
    /**
     * Getter username
     * @return {String}
     */
    Account.prototype.getUsername = function () {
        return this.username;
    };
    /**
     * Getter fullname
     * @return {String}
     */
    Account.prototype.getFullname = function () {
        return this.fullname;
    };
    /**
     * Getter departmentId
     * @return {number}
     */
    Account.prototype.getDepartmentId = function () {
        return this.departmentId;
    };
    /**
     * Getter positionId
     * @return {number}
     */
    Account.prototype.getPositionId = function () {
        return this.positionId;
    };
    /**
     * Getter createDate
     * @return {Date}
     */
    Account.prototype.getCreateDate = function () {
        return this.createDate;
    };
    /**
     * Setter accountId
     * @param {number} value
     */
    Account.prototype.setAccountId = function (value) {
        this.accountId = value;
    };
    /**
     * Setter email
     * @param {string} value
     */
    Account.prototype.setEmail = function (value) {
        this.email = value;
    };
    /**
     * Setter username
     * @param {String} value
     */
    Account.prototype.setUsername = function (value) {
        this.username = value;
    };
    /**
     * Setter fullname
     * @param {String} value
     */
    Account.prototype.setFullname = function (value) {
        this.fullname = value;
    };
    /**
     * Setter departmentId
     * @param {number} value
     */
    Account.prototype.setDepartmentId = function (value) {
        this.departmentId = value;
    };
    /**
     * Setter positionId
     * @param {number} value
     */
    Account.prototype.setPositionId = function (value) {
        this.positionId = value;
    };
    /**
     * Setter createDate
     * @param {Date} value
     */
    Account.prototype.setCreateDate = function (value) {
        this.createDate = value;
    };
    Account.counter = 0;
    return Account;
}());
exports.Account = Account;
