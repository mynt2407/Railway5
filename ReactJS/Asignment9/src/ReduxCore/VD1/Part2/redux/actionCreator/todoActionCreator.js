import { ADD_TODO } from "../actionTypes";

const addTodoAction = todo => {
    return {
        type: ADD_TODO,
        payload: todo
        //payload: lay data tu o input
    }
}
export default addTodoAction;