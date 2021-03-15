import { createStore, applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';
import rootReducer3 from '.';

const composeEnhancer = typeof window === 'object' && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ ?   
window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({
}) : compose;
const enhancer = composeEnhancer(applyMiddleware(thunk));
const store3 = createStore(rootReducer3, enhancer);
export default store3;