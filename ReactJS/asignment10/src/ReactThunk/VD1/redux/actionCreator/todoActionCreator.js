import { GET_LIST_EMPLOYEE } from "../actionTypes1";

const getListEmployeeAc1 = todo => {
    return {
        type: GET_LIST_EMPLOYEE,
        payload: todo
    }
}
export default getListEmployeeAc1;