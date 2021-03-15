import React from 'react';
import Axios from 'axios';

class ListEmployee extends React.Component {
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