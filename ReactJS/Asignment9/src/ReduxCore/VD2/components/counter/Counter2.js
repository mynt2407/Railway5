import { useState } from "react";
import { Decrease2, Increase2 } from "../../redux/action/actionChange";
import { counterSelector2 } from "../../redux/selector/CounterSelector";
import store2 from "../../Store";

function Counter2() {

    const [counter, setCouter] = useState(counterSelector2());

    const increase = () => {
        store2.dispatch(Increase2())
    }

    const decrease = () => {
        store2.dispatch(Decrease2())
    }

    const updateData = () => {
        store2.subscribe(() => setCouter(counterSelector2()))
    }

    updateData();

    return (
        <>
            <p>Value: {counter} times...</p>
            <button onClick={increase}>Increase</button>
            <button onClick={decrease}>Decrease</button>
        </>
    )
}
export default Counter2;