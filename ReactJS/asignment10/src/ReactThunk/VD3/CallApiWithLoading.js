import React, { useEffect, useState } from 'react';
import TodoList3 from './components/TodoList';
import WithLoading from './hoc/withLoading';
import { getListEmployee3 } from './redux/action/ActionCreator';
import { selectListTodos, selectLoading } from './redux/selector/todoSelector';
import store3 from './redux/store';

function CallApiWithLoading() {

    const [todos, setTodos] = useState(selectListTodos());
    const [isLoading, setLoading] = useState(selectLoading());

    const updateListAndLoading = () =>
        store3.subscribe(() => {
            setTodos(selectListTodos())
            setLoading(selectLoading())
        })
    updateListAndLoading();

   const  getListEmployee = () => {
        //dispatch 1 async action
        store3.dispatch(getListEmployee3())
    }
    useEffect(() => {
        getListEmployee()
    }, []);

    const TodoListWithLoading = WithLoading(TodoList3)

    return (
        <>
            <TodoListWithLoading
                todos={todos}
                isLoading={isLoading}
            />
        </>
    )
}
export default CallApiWithLoading;
