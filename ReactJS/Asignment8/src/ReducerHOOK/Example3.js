import React, { useReducer } from 'react';

function Example3() {
    const [count, dispatch] = useReducer((prevState, action) => {
        switch (action.type) {
            case 'INCREMENT':
                return prevState + action.value;

            case 'DECREMENT':
                return prevState - action.value;
            default:
                throw new Error();
        }
    }, 0);
    return (
        <>
            <p>You clicked {count} times</p>
            <button
                onClick={() => dispatch({ type: 'INCREMENT', value: 2 })}
            >+</button>

            <button
                onClick={() => dispatch({ type: 'DECREMENT', value: 1 })}
            >-</button>
        </>
    )
}
export default Example3;