import { createStore } from 'redux';
import counterReducer1 from './redux/reducer/todoCounter';

const store = createStore(counterReducer1)
export default store;