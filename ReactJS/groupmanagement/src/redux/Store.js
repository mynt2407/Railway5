import { configureStore } from "@reduxjs/toolkit";
import GroupReducer from "./reducer/GroupSlice";

const store = configureStore({
    reducer: {
        group: GroupReducer.reducer
    }
})
export default store;