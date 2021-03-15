import store3 from "../store";

export const selectListTodos = () => {
    return store3.getState().todo.todos;
}
export const selectLoading = () => {
    return store3.getState().todo.isLoading;
}