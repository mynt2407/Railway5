import React, { useMemo, useState } from 'react';

function MemoHook() {

    const [a, setA] = useState(0);
    const [b, setB] = useState(0);

    const [counter, setCounter] = useState(0);

    const sum = (a , b) => {
        console.log("Caculating...");
        return a + b;
    }

    const sumResult = useMemo(() => sum(a, b), [a, b]);

    return (
        <>
            {/* Caculator sum a, b */}
            <form>
                <label>Input a: </label>
                <input
                    type="number"
                    value={a}
                    onChange={(e) => setA(e.target.value)}
                />
                <br/>

                <label>Input b: </label>
                <input
                    type="number"
                    value={b}
                    onChange={(e) => setB(e.target.value)}
                />

                <br/>
                <label>Sum : {sumResult}</label>
            </form>

            {/* Counter */}
            <h2>Counter : {counter}</h2>

            <button
                onClick={(e) => setCounter(counter + 1)}
            >Click me</button>
        </>
    )
}
export default MemoHook;