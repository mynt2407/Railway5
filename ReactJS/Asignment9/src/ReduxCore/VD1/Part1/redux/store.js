import { createStore } from 'redux';
import counterReducer1 from './reducer/todoCounter';


const store = createStore(counterReducer1)
export default store;