import { useState } from "react";
import { decreamented, increamented } from "../redux/counterSlide";
import store5 from "../redux/Store";

function Counter5() {

//lay state duoc luu theo ten reducer trong store 
    const [counter, setCouter] = useState(store5.getState().counter);

    //incremented, decremented la action 
    const increase = () => {
        store5.dispatch(increamented())
    }

    const decrease = () => {
        store5.dispatch(decreamented())
    }

    const updateData = () => {
        store5.subscribe(() => setCouter(store5.getState().counter))
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
export default Counter5;