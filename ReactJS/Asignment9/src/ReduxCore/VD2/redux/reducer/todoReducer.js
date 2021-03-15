import { ADD_TODO2 } from "../../actionTypes2";

const initialState = {
    todos: []
}
//(state, action) => newState
function todoReducer2(state = initialState, action) {
    switch (action.type) {
        case ADD_TODO2:
            return {
                ...state,
                todos: [...state.todos, action.payload]
            }

        default:
            return state;
    }
}
export default todoReducer2;