import { configureStore } from "@reduxjs/toolkit";
import todoSlice from "../redux/reducer/todoSlice"

const store7 = configureStore({
    reducer: {
        todo: todoSlice.reducer
    }
})
export default store7;