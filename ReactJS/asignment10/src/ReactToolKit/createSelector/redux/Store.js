import { configureStore } from "@reduxjs/toolkit";
import todoSlice from "./todoSlide";

const store6 = configureStore({
    reducer: {
        todo: todoSlice.reducer
    }
})
export default store6;