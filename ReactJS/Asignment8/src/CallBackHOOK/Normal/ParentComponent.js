import React, { useState } from 'react';
import ChildComponent from './ChildrenComponent';

function ParentComponent() {

    const [counter, setCounter] = useState(0);

    const sum = (a, b) => {
        console.log("Caculating...");
        return a + b;
    }

    return (
        <>
            <ChildComponent sum ={sum} />

            {/* Counter */}
            <h2>Counter : {counter}</h2>
            <button
                onClick={(e) => setCounter(counter + 1)}
            >Click me</button>
        </>
    )
}
export default ParentComponent;