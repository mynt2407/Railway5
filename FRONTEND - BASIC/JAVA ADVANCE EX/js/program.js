$(function() {
    $(".header").load("header.html");
    $(".main").load("main.html");
    $(".footer").load("footer.html");
});

function clickUsers() {
    $(".main").load("viewList.html");
    initGroup();
}

function clickhome() {
    $(".main").load("main.html");
}
var groups = [];
var counter = 0;

function Group(id, name) {
    this.id = ++counter;
    this.name = name;
    // this.member = member;
    // this.fullname = fullname;
    // this.createDate = createDate;
}

function initGroup() {
    var url = "http://localhost:8080/api/v1/groups";

    //Call API from server

    $.get(url, function(data, status) {
        //error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        groups = data.content;
        console.log(groups);
        filltoTable();
    });
}

function filltoTable() {

    $('tbody').empty();

    var body = "";
    //dung for de in ra thang index (STT) 
    for (let index = 0; index < groups.length; index++) {
        const item = groups[index];
        body += '<tr>' +
            '<td>' + '<form style="padding-left: 10px;"><input id="input' + index + '" type="checkbox" value=""> </form>' + '</td>' +
            '<td>' + (index + 1) + '</td>' +
            '<td onclick = "viewDetailGroup(' + item.id + ')"  style = "color: blue;" >' + item.name + '</td>' +
            // '<td>' + '<a href= "../html/viewdetail.html">' + item.name + '</a>' + '</td>' +
            '<td>' + item.member + '</td>' +
            '<td>' + item.fullname + '</td>' +
            '<td>' + (item.createDate == null ? "" : item.createDate) + '</td>' +
            '</tr>';
    }

    $('tbody').append(body);
}


function openCreateModal() {
    resetForm();
    showModal();
}

function resetForm() {
    $("#id").val("");
    $("#name").val("");
    $("#error_name").val("");

}

// Modal name duoc dinh nghia o file ViewList
function hideModal() {
    $(".modal").modal('hide');
}

function showModal() {
    $(".modal").modal('show');
}

function SaveCreateGroup() {

    //lay data tu model ra
    var name = $("#name").val();

    //khai báo employee dưới dạng json
    var group = { name: name };
    console.log(name);

    $.ajax({
        url: 'http://localhost:8080/api/v1/groups',
        type: 'POST',
        data: JSON.stringify(group), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function(data, textStatus, xhr) {
            hideModal();
            //showSuccessAlert();
            initGroup();
        },
        // in ra message tu duong link api

        error(error, textStatus, errorThrown) {
            console.log(error);
            if (error.status == 400) {
                document.getElementById("error_name").innerHTML = error.responseJSON.errors[0].message;
            } else {
                console.log(error);
            }

        }
    });
}


function openUpdateTable(id) {
    var group = "";
    var url = "http://localhost:8080/api/v1/groups" + id;

    //Call API from server

    $.get(url, function(data, status) {
        //error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        group = data;
        console.log(group);
    });
}


//View detail group
function viewDetailGroup(id) {
    // display detail page
    $(".main").load("viewdetail.html", function() {
        // get data
        GetGroupById(id);
    });
}


function GetGroupById(id) {
    var url = 'http://localhost:8080/api/v1/groups/' + id;

    //Call API from server
    $.get(url, function(data, status) {
        //error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        fillToDetailForm(data);

    });
}

function fillToDetailForm(data) {
    document.getElementById("groupId").innerHTML = data.id;
    document.getElementById("groupName").innerHTML = data.name;
    document.getElementById("Creator").innerHTML = data.creator.fullname;
    document.getElementById("CreateDate").innerHTML = data.createDate;
    document.getElementById("Member").innerHTML = data.member;
}

//Bấm vào pen để edit name
function openUpdateModal() {

    var id = document.getElementById("groupId").innerHTML;
    var url = 'http://localhost:8080/api/v1/groups/' + id;

    var group = "";

    showModal();

    //Call API from server
    $.get(url, function(data, status) {
        //error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        group = data;
        console.log(group);
        document.getElementById("idGroup").innerHTML = group.id;
        document.getElementById("name").value = group.name;
    });

}

function updateNewName() {
    //lấy data vừa nhập vào
    var id = document.getElementById("idGroup").innerHTML;
    var name = document.getElementById("name").value;

    //validate ==> return
    var group = { name: name };

    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/' + id,
        type: 'PUT',
        data: JSON.stringify(group), //parse sang file Json của body
        contentType: "application/json", //data ném lên là file(text, json, xml)
        //datatype: 'json'. kiểu trả về server dưới dạng json
        success: function(result) {
            // success
            hideModal();
            //showSuccessAlert();
            //initGroup();
        },
        
        // in ra message tu duong link api

        error(error, textStatus, errorThrown) {
            if (error.status == 400) {
                document.getElementById("error_name").innerHTML = error.responseJSON.errors[0].message;
            } else {
                console.log(error);
            }

        }
    });

}

function confirmDelete(index) {
    var deleteIds = [];

    for (let index = 0; index < 10; index++) {
        var input = document.getElementById("input" + index);

        if (input === null || input === undefined) {
            break;
        }

        if (input.checked == true) {
            deleteIds.push(groups[index].id);
        }
    }


    var result = confirm("Do you want to delete?");
    if (result) {
        deleteGroups(deleteIds);
    }
}

function deleteGroups(deleteIds) {

    $.ajax({
        url: 'http://localhost:8080/api/v1/groups?ids=' + deleteIds,
        type: 'DELETE',
        success: function(result) {
            // ifsuccess
            //showSuccessAlert();
            initGroup();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

function checkAll() {

    // get value check
    var isCheck = document.getElementById("inputTotal").checked

    for (let index = 0; index < 10; index++) {
        var input = document.getElementById("input" + index);

        if (input === null || input === undefined) {
            break;
        }
        input.checked = isCheck;
    }

}