import React, { useReducer } from 'react';

//dispatch giong nhu setState 
// prevState + action => new State
//preState la ham tich luy. Tuong tu accumulator

function Example1() {
    const [count, dispatch] = useReducer((prevState, action) => {
        return prevState + action
    }, 0);
    return (
        <>
            <p>You clicked {count} times</p>
            <button
                onClick={() => dispatch(1)}
            >Click me</button>
        </>
    )
}
export default Example1;