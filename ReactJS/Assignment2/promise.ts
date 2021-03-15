function callApiCreateUser() {
    return new Promise(function (resolve, reject) {
        reject("Create user fail");
        // resolve("Create user successfully!"); 
    })
}
function callApiCreateGroup() {
    return new Promise(function (resolve, reject) {
        reject("Group Name is exist!");
    })
}
function callApiAddUserToGroup() {
    return new Promise(function (resolve, reject) {
        resolve("Add user to group success!");
    })
}
callApiCreateUser()
    .then(
        function (messages) {
            console.log(messages);
            return callApiCreateGroup();
        },

        //Loi local: kho xu ly

        // function (messages) {
        //     console.log("2");
        //     console.log(messages);
        //     return null;
        // }
    )

    .then(
        function (messages) {
            console.log(messages);
            return callApiAddUserToGroup();
        })
    .then(function (messages) {
        console.log(messages);
    })
    .catch(function (messages) {
        console.log(messages);
    })