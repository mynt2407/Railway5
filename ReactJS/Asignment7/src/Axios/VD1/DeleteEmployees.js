import React from 'react';
import Axios from 'axios';

class DeleteEmployee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
    }

    getListEmployee = function () {
        const baseURL = `https://5f47b29395646700168d9bd1.mockapi.io`;

        Axios.get(`${baseURL}/api/v1/employees`)
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

    deleteById(id) {
        const baseURL = `https://5f47b29395646700168d9bd1.mockapi.io`;

        Axios.delete(`${baseURL}/api/v1/employees/${id}`)
            .then(response => {
                this.getListEmployee();
            })
            .catch(error => console.log("Loi roi"))
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