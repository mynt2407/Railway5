function callAPICreateUser(data, status) {
    if (status == "error") {
        console.log("Loi khi call API Cretae User");
    } else {
        callAPICreateGroup(data, status);
    }

    //success
    function callAPICreateGroup(data, status) {
        if (status == "error") {
            console.log("Loi!");
        } else {
            callAPIAddUserToGroup(data, status);
        }
        
        //success
        function callAPIAddUserToGroup(data, status) {
            //success
            if (status == "success") {
                console.log("End!");

            }
        }
    }
}