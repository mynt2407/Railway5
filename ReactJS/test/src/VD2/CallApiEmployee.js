import React from 'react';
import TodoList from './components/TodoList';
import { getListEmployeeAc2 } from './redux/actionCreator/todoActionCreator';
import store from './redux/store';

class CallApiEmployees2 extends React.Component {

    getListEmployee = () => {
        //dispatch 1 async action
        store.dispatch(getListEmployeeAc2())
    }
    componentDidMount() {
        this.getListEmployee()
        console.log('1');
    }
    render() {
        return (
            <>
                <TodoList />
            </>
        )
    }
}
export default CallApiEmployees2;
