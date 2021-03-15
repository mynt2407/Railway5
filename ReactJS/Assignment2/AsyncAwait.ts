async function callApiCreateUser1() {
    return "create user successfully";
}

async function callApiCreateGroup1() {
    return "create group successfully";
}
async function callApiAddUserToGroup1() {
    return "Add user to group successfully ";
}

async function createAndAddUserToGroup() {
    //call API
    let resultCreateUser = await callApiCreateUser1();
    console.log(resultCreateUser);

    //call API
    let resultCreateGroup = await callApiCreateGroup1();
    console.log(resultCreateGroup);

    //call API
    let resultAddUserToGroup = await callApiAddUserToGroup1();
    console.log(resultAddUserToGroup);

}
createAndAddUserToGroup();