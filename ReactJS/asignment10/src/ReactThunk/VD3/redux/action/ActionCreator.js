import EmployessApi from "../../api/Api";
import { HIDDEN_LOADING, LIST_EMPLOYEE, SHOW_LOADING } from "../actionTypes";

const listTodoAction = datas => {
    return {
        type: LIST_EMPLOYEE,
        payload: datas
    }
}
const showLoading = () => {
    return {
        type: SHOW_LOADING
    }
}
const hiddenLoading = () => {
    return {
        type: HIDDEN_LOADING
    }
}
export const getListEmployee3 = () => {
    //thunk function
    return async dispatch => {
        try {
            //show loading
            dispatch(showLoading());
            const datas = await EmployessApi.getAll();

            //hidden loading
            dispatch(hiddenLoading());

            //update data
            dispatch(listTodoAction(datas))

        } catch (error) {
            console.log(error);
        }
    }
    //thunk function để khi component gửi 1 dispatch sẽ không đến trực tiếp reducer mà phải qua 1 thằng Middleware để call API trước  
}