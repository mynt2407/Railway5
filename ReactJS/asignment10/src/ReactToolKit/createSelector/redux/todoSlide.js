import { createSlice } from "@reduxjs/toolkit";

//counterSlice: trong do vua khoi tao state, vua dinh nghia action va thuc hien setState luon 
const todoSlice = createSlice({
    name: 'todo',
    initialState: [],
    reducers: {
        //khai bao 1 action co payload
        addTodo: {
            reducer: (state, action) => {
                state.push(action.payload)
            },
            prepare: (input) => {
                return {
                    payload: input
                }
            }
        }
    }
}, [])

export const { actions, reducer } = todoSlice;
export const { addTodo } = actions;

export default todoSlice;