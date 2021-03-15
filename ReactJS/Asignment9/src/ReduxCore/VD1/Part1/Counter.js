import { useState } from "react";
import store from "./Store";

function Counter() {
    
    const [counter, setCouter] = useState(store.getState().value)
    const increase = () => {
        store.dispatch({
            type: 'increase'
        })
    }

    const decrease = () => {
        store.dispatch({
            type: 'decrease'
        })
    }

    const updateData = () => {
        store.subscribe(() => setCouter(store.getState().value));
    }

    updateData();

    return (
        <>
            <p>Value: {counter}</p>
            <button onClick={increase}>Increase</button>
            <button onClick={decrease}>Decrease</button>
        </>
    )
}
export default Counter;