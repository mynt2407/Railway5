import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const groupSelector = (state) => state.group;

const selectListGroupSelector = createSelector(
    groupSelector,
    state => state.groups);

const selectPageSelector = createSelector(
    groupSelector,
    state => state.page);

const selectSizeSelector = createSelector(
    groupSelector,
    state => state.size);

const selectTotalElementSelector = createSelector(
    groupSelector,
    state => state.totalElement);

const selectMinTotalMemberSelector = createSelector(
    groupSelector,
    state => state.minTotalMember);

const selectMaxTotalMemberSelector = createSelector(
    groupSelector,
    state => state.maxTotalMember);

const selectLoadingSelector = createSelector(
    groupSelector,
    state => state.isLoading);

/** function */
export const selectListGroup = (state) => {
    return selectListGroupSelector(state);
}

export const selectPage = (state) => {
    return selectPageSelector(state);
}

export const selectSize = (state) => {
    return selectSizeSelector(state);
}

export const selectTotalElement = (state) => {
    return selectTotalElementSelector(state);
}

export const selectMinTotalMember = (state) => {
    return selectMinTotalMemberSelector(state);
}

export const selectMaxTotalMember = (state) => {
    return selectMaxTotalMemberSelector(state);
}

export const selectLoading = (state) => {
    return selectLoadingSelector(state);
}