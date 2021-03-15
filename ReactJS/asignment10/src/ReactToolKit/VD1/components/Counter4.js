import { useState } from "react";
import { decremented, incremented } from "../redux/counterReducer";
import store4 from "../redux/Store";

function Counter4() {

//lay state duoc luu theo ten reducer trong store 
    const [counter, setCouter] = useState(store4.getState().counter);

    //incremented, decremented la action 
    const increase = () => {
        store4.dispatch(incremented())
    }

    const decrease = () => {
        store4.dispatch(decremented())
    }

    const updateData = () => {
        store4.subscribe(() => setCouter(store4.getState().counter))
    }

    updateData();

    return (
        <>
            <p>Click: {counter} times...</p>
            <button onClick={increase}>Increase</button>
            <button onClick={decrease}>Decrease</button>
        </>
    )
}
export default Counter4;