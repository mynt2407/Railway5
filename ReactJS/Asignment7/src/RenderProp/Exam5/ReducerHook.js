import React, { useReducer } from 'react';

function Reducer() {
    const [count, dispatch] = useReducer((state, action) => {
        switch (action.type) {
            case 'INCREMENT':
                return state + 2;
            case 'DECREMENT':
                return state - 1;
            default:
                throw new Error();
        }
    }, 0);
    return (
        <div>
            <h2>You click {count} times</h2>
            <button onClick={() => dispatch({ type: 'INCREMENT' })}>+</button>
            <button onClick={() => dispatch({ type: 'DECREMENT' })}>-</button>
        </div>
    )

}
export default Reducer;