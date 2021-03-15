import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import Api from "../../api/Api";
import { LIST_EMPLOYEE } from "../actionTypes1";

export const getListTodoAsyncAction = createAsyncThunk(

    //Create async thunk de call api
    LIST_EMPLOYEE,
    async () => {
        const todos = await Api.getAll();
        return todos;
    }
)
const todoSlide = createSlice({
    name: "todo",
    initialState: {
        todos: [],
        isLoading: false
    },

    reducers: {
    },

    extraReducers: {
        //Dinh nghia action va setState tai day 
        [getListTodoAsyncAction.fulfilled]: (state, action) => {
            state.todos = action.payload;
            state.isLoading = false
        },
        [getListTodoAsyncAction.pending]: (state, action) => {
            state.isLoading = true
        }
    }
})
export const { actions, reducer } = todoSlide;
export default todoSlide;