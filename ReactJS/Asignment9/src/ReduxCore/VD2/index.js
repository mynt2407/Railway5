import { combineReducers } from "redux";
import counterReducer2 from "./redux/reducer/counterReducer";
import todoReducer2 from "./redux/reducer/todoReducer";

const rootReducer = combineReducers({
    todo2: todoReducer2,
    counter2: counterReducer2
})
export default rootReducer;