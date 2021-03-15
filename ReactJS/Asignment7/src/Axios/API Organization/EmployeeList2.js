import React from 'react';
//import Axios from 'axios';
import EmployessApi1 from './FunctionApi';

class ListEmployee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
    }

    getListEmployee = function () {

        // Phuong thuc da duoc viet san trong FunctionApi

        EmployessApi1.getAll()
            .then(data => {
                this.setState(
                    {
                        employees: data
                    });
            })
            .catch(error => console.log("Loi roi"));
    }

    componentDidMount() {
        this.getListEmployee();
    }

    render() {
        const employeesList = this.state.employees.map(
            employee =>
                <li key={employee.id}>
                    {employee.name}
                </li>
        )
        return (
            <ul>
                {employeesList}
            </ul>
        )
    }

}
export default ListEmployee;