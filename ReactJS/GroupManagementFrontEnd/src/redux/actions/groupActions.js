import * as types from "../constants";
import GroupApi from '../../api/GroupApi';

const listGroupAction = (groups, page, totalElement, sortField, sortType, minTotalMember, maxTotalMember) => {
  return {
    type: types.GET_LIST_GROUP,
    payload: {
      groups,
      // paging
      page,
      totalElement,
      // sorting
      sortField,
      sortType,
      // filter
      minTotalMember,
      maxTotalMember
    }
  };
}

export const getListGroupAction = (page, size, sortField, sortType, search, minTotalMember, maxTotalMember) => {
  return async dispatch => {
    try {
      const json = await GroupApi.getAll(page, size, sortField, sortType, search, minTotalMember, maxTotalMember);
      const groups = json.content;
      const totalElement = json.totalElements;
      dispatch(listGroupAction(groups, page, totalElement, sortField, sortType, minTotalMember, maxTotalMember));
    } catch (error) {
      console.log(error);
    }
  }
}