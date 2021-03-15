import { configureStore } from "@reduxjs/toolkit";
import counterSlide from "./counterSlide";

const store5 = configureStore({
    reducer: {
        counter: counterSlide.reducer
    }
})
export default store5;