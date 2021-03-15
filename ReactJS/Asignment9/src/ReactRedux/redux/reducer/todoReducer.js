import { ADD_TODO3 } from "../../actionTypes3";

const initialState = {
    todos: []
}
//(state, action) => newState
function todoReducer3(state = initialState, action) {
    switch (action.type) {
        case ADD_TODO3:
            return {
                ...state,
                todos: [...state.todos, action.payload]
            }

        default:
            return state;
    }
}
export default todoReducer3;