import { ADD, DELETE, EDIT } from "../ActionTypeInput";

const initialState = {
    inputs: []
}
//(state, action) => newState
function InputReducer(state = initialState, action) {
    
  //  let copyState = [...state]

    switch (action.type) {
        case ADD:
            return {
                ...state,
                inputs: [...state.inputs, action.payload]
            }

        // case EDIT:
        //     copyState[action.index] = action.data;
        //     return
        //     copyState;

        // case DELETE:
        //     return {
        //         ...state,
        //         inputs: [...state.inputs, action.payload]
        //     }

        default:
            return state;
    }
}
export default InputReducer;