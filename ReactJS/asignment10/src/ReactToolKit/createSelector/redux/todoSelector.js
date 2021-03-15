import { createSelector } from "@reduxjs/toolkit";
import store6 from "./Store";

// selector
const todoSelector = state => state.todo;
const selectListTodo = createSelector(
    todoSelector,
    state => state
)
const selecListTodos = () => {
    return selectListTodo(store6.getState());
}
export default selecListTodos;