import { useState } from "react";
import selectData2 from "../../redux/selector/TodoSelector";
import store2 from "../../Store";
import Todo2 from "./Todo2";


function TodoList2() {
    const [todos, updateTodos] = useState(selectData2())
    const todoList = todos.map((item, index) =>

        <Todo2
            key={index}
            todo={item}
        />)
        
    const updateList = () => store2.subscribe(() => updateTodos(selectData2()));
    updateList();

    return (
        <ul>
            {todoList}
        </ul>
    )
}
export default TodoList2;