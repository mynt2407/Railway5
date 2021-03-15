import {  GET_LIST_EMPLOYEE } from "../actionTypes";

const initialState = {
    todos: []
}
//(state, action) => newState
function todoReducer(state = initialState, action) {
    switch (action.type) {
        case GET_LIST_EMPLOYEE:
            return {
                ...state,
                todos: action.payload
            }

        default:
            return state;
    }
}
export default todoReducer;