import store1 from "../store1";

const selectListTodos1 = () => {
    return store1.getState().todo.todos;
}
export default selectListTodos1;
