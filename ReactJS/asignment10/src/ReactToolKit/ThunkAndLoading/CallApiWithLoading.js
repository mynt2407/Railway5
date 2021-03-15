import React, { useEffect, useState } from 'react';
import TodoList5 from './components/TodoList';
import WithLoading from './hoc/withLoading';
import { getListTodoAsyncAction } from './redux/reducer/todoSlice';
import { selectListTodos7, selectLoadings7 } from './redux/selector/todoSelector';
import store7 from './redux/store';

function CallApiWithThunk() {

    const [todos, setTodos] = useState(selectListTodos7());
    const [isLoading, setLoading] = useState(selectLoadings7());

    const updateListAndLoading = () =>
        store7.subscribe(() => {
            setTodos(selectListTodos7())
            setLoading(selectLoadings7())
        })
    updateListAndLoading();

   const  getListEmployee = () => {
        //dispatch 1 async action
        store7.dispatch(getListTodoAsyncAction())
    }
    useEffect(() => {
        getListEmployee()
    }, []);

    const TodoListWithLoading = WithLoading(TodoList5)

    return (
        <>
            <TodoListWithLoading
                todos={todos}
                isLoading={isLoading}
            />
        </>
    )
}
export default CallApiWithThunk;
