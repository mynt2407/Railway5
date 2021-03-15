import { useState } from "react";
import { selectListTodos } from "../redux/selector/todoSelector";
import store3 from "../redux/store";
import Todo3 from "./Todo";

function TodoList3() {
    const [todos, updateTodos] = useState(selectListTodos());
    const todoList = todos.map((item, index) =>

        <Todo3
            key={index}
            todo={item.todo}
        />);
        
    const updateList = () => store3.subscribe(() => updateTodos(selectListTodos()));
    updateList();

    return (
        <ul>
            {todoList}
        </ul>
    )
}
export default TodoList3;