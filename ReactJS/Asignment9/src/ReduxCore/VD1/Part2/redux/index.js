import { combineReducers } from "redux";
import todoReducer from "./reducer/todoReducer";

const rootReducer = combineReducers({
    todo: todoReducer
    //counter: counterReducer
})
export default rootReducer;