import EmployessApi from "../../api/FunctionApi";
import { GET_LIST_EMPLOYEE } from "../actionTypes";

const listTodoAction = todo => {
    return {
        type: GET_LIST_EMPLOYEE,
        payload: todo
    }
}

export const getListEmployeeAc2 = () => {
    //thunk function
    return async dispatch => {
        try {
            const todo = await EmployessApi.getAll();
            dispatch(listTodoAction(todo))
        } catch (error) {
            console.log(error);
        }
    }
    //thunk function để khi component gửi 1 dispatch sẽ không đến trực tiếp reducer mà phải qua 1 thằng Middleware để call API trước  
}