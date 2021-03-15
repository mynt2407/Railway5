import React from 'react';
import axiosClient from './axiosCreate';

class ListEmployee2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
    }

    getListEmployee = function () {

        axiosClient.get(`/api/v1/employees`)
            .then(response => {
                this.setState(
                    {
                        employees: response.data
                    });
            })
            .catch(error => console.log("Loi roi"))
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
export default ListEmployee2;