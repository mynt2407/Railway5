import { createAction, createReducer } from "@reduxjs/toolkit"

//Create action by toolkit
export const incremented = createAction("incremented")
export const decremented = createAction("decremented")

const counterReducer4 = createReducer(0,
    {
        [incremented]: state => state + 1,
        [decremented]: state => state - 1
    })
export default counterReducer4;