import React, { useState } from "react";
import selectListTodos1 from "../redux/selector/todoSelector";
import store1 from "../redux/store1";
import Todo1 from "./Todo1";

function TodoList1() {

    const [todos, updateTodos] = useState(selectListTodos1());
    console.log(store1.getState())

    const todoList = todos.map((item, index) =>
        <Todo1 
        key={index} 
        todo={item.todo} />
    );

    const updateList = () =>
        store1.subscribe(() => updateTodos(selectListTodos1()));

    updateList();

    return (
        <ul>
            {todoList}
        </ul>
    );
};

export default TodoList1;
