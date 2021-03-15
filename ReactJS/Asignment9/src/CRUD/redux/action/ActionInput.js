import { ADD, DELETE, EDIT } from "../ActionTypeInput"

export const actionAddInput = data => {
    return {
        type: ADD,
        payload: data
    }
}

// export const actionEditInput = (data, index) => {
//     return {
//         type: EDIT,
//         payload: data,
//         index: index
//     }
// }
// export const actionDeleteInput = (index) => {
//     return {
//         type: DELETE,
//         index: index
//     }
// }