import store2 from "../../Store"

const selectData2 = () => {
    return store2.getState().todo2.todos
}
export default selectData2;