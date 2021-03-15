import { combineReducers } from "redux";
import todoReducer from "./reducer/todoReducer";

const rootReducer3 = combineReducers({
    todo: todoReducer
})
export default rootReducer3;