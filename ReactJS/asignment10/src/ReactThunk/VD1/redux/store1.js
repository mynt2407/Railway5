import { createStore } from 'redux';
import rootReducer from '.';

//rootReducer chua nhieu Reducer. Do store chi quan ly 1 thang Reducer
const store1 = createStore(rootReducer)
export default store1;