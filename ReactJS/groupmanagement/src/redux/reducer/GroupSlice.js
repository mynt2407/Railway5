import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import GroupApi from "../../api/FunctionApi";
import { GET_LIST_EMPLOYEE } from "../GroupActionTypes";

export const getListEmployeeAsyncAction = createAsyncThunk(

    GET_LIST_EMPLOYEE,
    async () => {
        const groups = await GroupApi.getAll();
        return groups;
        
    }
)
//(state, action) => newState
const GroupReducer = createSlice({
    name: "group",
    initialState: {
        groups: [],
        isLoading: false
    },

    reducers: {
    },

    extraReducers: {
        //Dinh nghia action va setState tai day 
        [getListEmployeeAsyncAction.fulfilled]: (state, action) => {
            state.groups = action.payload;
            state.isLoading = false
        },
        [getListEmployeeAsyncAction.pending]: (state, action) => {
            state.isLoading = true
        }
    }
})
export const { actions, reducer } = GroupReducer;
export default GroupReducer;
