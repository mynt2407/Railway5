import store from "../store"

const selectData =()=>{
    console.log(store.getState());
    return store.getState().value;
}
export default selectData;