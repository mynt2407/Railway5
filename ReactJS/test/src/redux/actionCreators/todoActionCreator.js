import { GET_LIST_TODO } from "../actionTypes";

export const getListTodoAction = (todos) => {
    return {
        type: GET_LIST_TODO,
        payload: todos
    };
};