import { configureStore } from "@reduxjs/toolkit";
import counterReducer4 from "./counterReducer";

const store4 = configureStore({
    reducer: {
        counter: counterReducer4
    }
})
export default store4;