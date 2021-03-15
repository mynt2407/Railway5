import { useState } from "react";
import store6 from "../redux/Store";
import selecListTodos from "../redux/todoSelector";
import Todo from "./Todo";

function TodoList() {
    const [todos, updateTodos] = useState(selecListTodos())
    const todoList = todos.map((item, index) =>

        <Todo
            key={index}
            todo={item}
        />)
        
    const updateList = () => store6.subscribe(() => updateTodos(selecListTodos()))
    updateList();

    return (
        <ul>
            {todoList}
        </ul>
    )
}
export default TodoList;