import { createSelector } from "@reduxjs/toolkit";
import store7 from "../store";

// selector
//todo nay trong store 
const todoSelector = state => state.todo;

const selectListTodo = createSelector(
    todoSelector,
    //todos nay trong state cua slice
    state => state.todos
)

const selectLoading = createSelector(
    todoSelector,
    //isLoading nay trong state cua slice
    state => state.isLoading
)

export const selectListTodos7 = () => {
    return selectListTodo(store7.getState());
}

export const selectLoadings7 = () => {
    return selectLoading(store7.getState());
}