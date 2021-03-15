import { DECREASE, INCREASE } from "../actionType";

const initialState = {
    value: 0
}
//(state, action) => newState
function counterReducer1(state = initialState, action) {

    switch (action.type) {
        case INCREASE:
            console.log('1');
            return {
                ...state,
                value: state.value + 1
            };
            
        case DECREASE:
            return {
                ...state,
                value: state.value - 1
            }
        default:
         return state;
    }
}
export default counterReducer1;