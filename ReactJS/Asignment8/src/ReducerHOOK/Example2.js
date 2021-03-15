import React, { useReducer } from 'react';

function Example2() {
    const [count, dispatch] = useReducer((prevState, action) => {
        switch (action.type) {
            case 'INCREMENT':
                return prevState + 1;

            case 'DECREMENT':
                return prevState - 1;
            default:
                throw new Error();
        }
    }, 0);
    return (
        <>
            <p>You clicked {count} times</p>
            <button
                onClick={() => dispatch({ type: 'INCREMENT' })}
            >+</button>

            <button
                onClick={() => dispatch({ type: 'DECREMENT' })}
            >-</button>
        </>
    )
}
export default Example2;