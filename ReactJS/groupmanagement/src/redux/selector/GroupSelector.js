import { createSelector } from "@reduxjs/toolkit";
import store from "../Store";

// selector
const groupSelector = state => state.group;

const selectListEmployee = createSelector(
    groupSelector,
    state => state.groups
)

const selectLoading = createSelector(
    groupSelector,
    //isLoading nay trong state cua slice
    state => state.isLoading
)

export const selectListEmployees = () => {
    return selectListEmployee(store.getState());
}

export const selectLoadings = () => {
    return selectLoading(store.getState());
}