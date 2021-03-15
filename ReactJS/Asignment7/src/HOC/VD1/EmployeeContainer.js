import React from 'react';
import withAuth from '../ConditionHOC/withAuth';
import EmployeeList from './EmployeeList';
import EmployessApi1 from './FunctionApi';
import WithLoading from './withLoading';

class EmployeeContainer extends React.Component {
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
        const EmployeeHasLoading = WithLoading(EmployeeList);
        return (
            <EmployeeHasLoading
                isLoading={this.state.employees.length === 0}
                employees={this.state.employees}
            />
        )
    }

}
//export default EmployeeContainer;
export default withAuth(EmployeeContainer);