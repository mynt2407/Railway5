import { combineReducers } from "redux";
import InputReducer from "../CRUD/redux/reducer/InputReducer";
import todoReducer3 from "./redux/reducer/todoReducer";

const rootReducer = combineReducers({
    todo3: todoReducer3,
    input : InputReducer

})
export default rootReducer;