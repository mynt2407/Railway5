import { useState } from "react";
import selectListTodos from "../redux/selector/todoSelector";
import store from "../redux/store";
import Todo2 from "./Todo";

function TodoList2() {
    const [todos, updateTodos] = useState(selectListTodos());
    const todoList = todos.map((item, index) =>

        <Todo2
            key={index}
            todo={item.todo}
        />);
        
    const updateList = () => store.subscribe(() => updateTodos(selectListTodos()));
    updateList();

    return (
        <ul>
            {todoList}
        </ul>
    )
}
export default TodoList2;