import React from 'react';

function EmployeeList(props) {

    const employeesList = props.employees.map(
        employee =>
            <li key={employee.id}>
                {employee.name}
            </li>
    );
    return (
        <ul>
            {employeesList}
        </ul>
    );
}
export default EmployeeList;