import React from 'react';
import EmployessApi from './api/FunctionApi';
import TodoList1 from './components/TodoList1';
import getListEmployeeAc1 from './redux/actionCreator/todoActionCreator';
import store1 from './redux/store1';

class CallApiEmployees extends React.Component {

    getListEmployee = async () => {
        try {
            const todo = await EmployessApi.getAll();
            store1.dispatch(getListEmployeeAc1(todo))
        } catch (error) {
            console.log("Loi roi em iu");
        }
    }
    componentDidMount() {
        this.getListEmployee();
    }
    render() {
        return (
            <>
                <TodoList1 />
            </>
        )
    }
}
export default CallApiEmployees;
