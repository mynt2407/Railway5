import { useState } from "react";
import { decreaseCounter, increaseCounter } from "../redux/actionCounter/ActionCounter";
import selectData from "../redux/selector/todoSelector";
import store from "../redux/store";


function Counter1() {

    const [counter, setCouter] = useState(selectData());

    const increase = () => {
        store.dispatch(increaseCounter())
    }

    const decrease = () => {
        store.dispatch(decreaseCounter())
    }

    const updateData = () => {
        store.subscribe(() => setCouter(selectData()))
    }

    updateData();

    return (
        <>
            <p>Value: {counter} times</p>
            <button onClick={increase}>Increase</button>
            <button onClick={decrease}>Decrease</button>
        </>
    )
}
export default Counter1;