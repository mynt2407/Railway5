import { createSlice } from "@reduxjs/toolkit";

//counterSlice: trong do vua khoi tao state, vua dinh nghia action va thuc hien setState luon 
const counterSlide = createSlice({
    name: 'counter1',
    initialState: 0,
    reducers: {
        increamented: state => state + 1,
        decreamented: state => state - 1
    }
})

export const { actions, reducer } = counterSlide;
export const { increamented, decreamented } = actions;

export default counterSlide;