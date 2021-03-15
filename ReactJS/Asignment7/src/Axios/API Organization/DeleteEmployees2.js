import React from 'react';
//import Axios from 'axios';
import EmployessApi1 from './FunctionApi';

class DeleteEmployee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
    }

    getListEmployee = function () {
       
        EmployessApi1.getAll()

            .then(data => {
                this.setState(
                    {
                        employees: data
                    });
            })
            .catch(error => console.log("Loi roi1"))
    }

    componentDidMount() {
        this.getListEmployee();
    }

    deleteById(id) {

        EmployessApi1.deleteById(id)

            .then(response => {
                this.getListEmployee();
            })
            .catch(error => console.log("Loi roi2"))
    }

    render() {
        const employeesList = this.state.employees.map(
            employee =>
                <li key={employee.id} onClick={() => { this.deleteById(employee.id) }}>
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
export default DeleteEmployee;