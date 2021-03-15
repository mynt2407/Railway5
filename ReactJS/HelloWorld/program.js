"use strict";
exports.__esModule = true;
var Account_1 = require("./Account");
var Department_1 = require("./Department");
var Position_1 = require("./Position");
var PositionName_1 = require("./PositionName");
//department
var department = new Department_1.Department(1, "abc");
console.log(department.getName());
//position
var position = new Position_1.Position(PositionName_1.PositionName.DEV);
console.log(PositionName_1.PositionName[position.getName()]);
//account1
var account = new Account_1.Account("mynt24@gmail.com", "mynt", "Nguyễn Thị My", 1, 3, new Date());
console.log(account.getCreateDate());
console.log(account.getAccountId());
console.log(account.getEmail());
//account2
var account2 = new Account_1.Account("mynguyen@gmail.com", "my.nguyen", "My Nguyễn thị", 4, 3, new Date());
console.log(account2.getCreateDate());
console.log(account2.getAccountId());
console.log(account2.getEmail());
