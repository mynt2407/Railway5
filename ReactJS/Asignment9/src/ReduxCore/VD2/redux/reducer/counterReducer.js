import { DECREASE2, INCREASE2 } from "../../actionTypes2";

const initialState = {
    value: 0
}
//(state, action) => newState
function counterReducer2(state = initialState, action) {

    switch (action.type) {
        case INCREASE2:
            return {
                ...state,
                value: state.value + 1
            };
            
        case DECREASE2:
            return {
                ...state,
                value: state.value - 1
            }
        default:
         return state;
    }
}
export default counterReducer2;