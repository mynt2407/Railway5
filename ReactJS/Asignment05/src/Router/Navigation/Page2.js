import React from "react";
import { useHistory } from "react-router-dom";


function Page2() {
    const history = useHistory();

    const back = () => {
        history.goBack();
    }

    const forward = () => {
        history.goForward();
    }
    const go = (n) => {
        history.go(n);
    }
    return (
        <div>
            <h1 > Page 2</h1>
            <button onClick={back}>Back</button>
            <button onClick={forward}>Forward</button>
            <button onClick={() => go(-1)}>Go -1</button>
            <button onClick={() => go(-2)}>Go -2</button>
            <button onClick={() => go(1)}>Go 1</button>
            <button onClick={() => go(2)}>Go 2</button>
        </div>
    )
   
}
export default Page2;