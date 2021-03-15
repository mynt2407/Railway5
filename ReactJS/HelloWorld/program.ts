import { Account } from "./Account";
import { Department } from "./Department";
import { Position } from "./Position";
import { PositionName } from "./PositionName";

//department
let department = new Department(1, "abc");
console.log(department.getName());

//position
// Với enum thì cần để trong []
let position = new Position(PositionName.DEV);
console.log(PositionName[position.getName()]);

//account1
 let account = new Account("mynt24@gmail.com", "mynt", "Nguyễn Thị My", 1,3, new Date());
 console.log(account.getCreateDate());
 console.log(account.getAccountId());
 console.log(account.getEmail());
 //account2
 let account2 = new Account("mynguyen@gmail.com", "my.nguyen", "My Nguyễn Thị", 4,3, new Date());
 console.log(account2.getCreateDate());
 console.log(account2.getAccountId());
 console.log(account2.getEmail());
