import { LIST_EMPLOYEE, HIDDEN_LOADING, SHOW_LOADING } from "../actionTypes";

const initialState = {
    todos: [],
    isLoading: false
}
//(state, action) => newState
function todoReducer(state = initialState, action) {
    switch (action.type) {
        case LIST_EMPLOYEE:
            return {
                ...state,
                todos: action.payload
            }

        case SHOW_LOADING:
            return {
                ...state,
                isLoading: true
            }

        case HIDDEN_LOADING:
            return {
                ...state,
                isLoading: false
            }
        default:
            return state;
    }
}
export default todoReducer;