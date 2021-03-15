$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavihome() {
    $(".main").load("home.html");
}

function clickNaviViewList() {
    $(".main").load("viewListEmployee.html");
    initEmployee();
}

var employees = [];
var counter = 0;

function Employee(id, name) {
    this.id = ++counter;
    this.name = name;
}

function Employee(name) {
    this.name = name;
}

function initEmployee() {

    var url = "http://localhost:8080/api/v1/departments";
    //Call API from server

    $.get(url, function(data, status) {
        //error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        employees = data;
        console.log(data);
        initTable();
    });
}

function initTable() {

    $('tbody').empty();

    employees.forEach(function(item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.name + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModel(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip"  onclick="confirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });

}

function openAddModal() {
    resetForm();
    ShowModal();
}

function HideModal() {
    $('#myModal').modal('hide');
}

function ShowModal() {
    $('#myModal').modal('show');
}

function addEmployee() {

    //lấy data từ Modal ra
    var name = $("#name").val();

    //khai báo employee dưới dạng json
    var employee = { name: name };
    console.log(name);

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(employee), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function(data, textStatus, xhr) {
            HideModal();
            showSuccessAlert();
            initEmployee();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

    // validate ==> return

    // var url = "http://localhost:8080/api/v1/departments";
    // var newEmployee = new Employee(name);
    // console.log(newEmployee);
    // $.post(url, newEmployee, function(data, status) {
    //     initEmployee();
    //     HideModal();
    // })
}

function resetForm() {
    $("#id").val("");
    $("#name").val("");
}

function openUpdateModel(id) {

    // get index employee
    var index = employees.findIndex(x => x.id == id);
    // fill data for index
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;
    ShowModal();

    // // Cách 2: gọi theo J Query

    // $("#id").val() = employees[index].id;
    // $("#name").val() = employees[index].name;
    // $("#department").val() = employees[index].department;
    // $("#phone").val() = employees[index].phone;
}

function saveNewInfor() {

    //lấy data vừa nhập vào
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    //validate ==> return
    var employee = { name: name };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(employee), //parse sang file Json của body
        contentType: "application/json", //data ném lên là file(text, json, xml)
        //datatype: 'json'. kiểu trả về server dưới dạng json
        success: function(result) {
            // success
            HideModal();
            showSuccessAlert();
            initEmployee();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

    // var index = employees.findIndex(x => x.id == id);

    // //  update employees
    // employees[index].name = name;


    // HideModal();
    // initEmployee();
    // showSuccessAlert();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();

    } else {
        saveNewInfor();
    }
}


function confirmDelete(id) {

    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Do you want to delete " + name + " ?");
    if (result) {
        deleteEmployees(id);
    }
}

function deleteEmployees(id) {

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        success: function(result) {
            // success
            showSuccessAlert();
            initEmployee();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

    // TODO validate
    // employees.splice(index, 1);
    // console.log(employees);
    // initTable();
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}