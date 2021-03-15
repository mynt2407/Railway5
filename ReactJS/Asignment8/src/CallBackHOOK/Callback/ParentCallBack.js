import React, { useCallback, useState } from 'react';
import ChildComponent from './ChildrenCallBack';

function ParentCallBack() {

    const [counter, setCounter] = useState(0);

    const sum = (a, b) => {
        console.log("Caculating...");
        return a + b;
    }

    //Đánh dấu hàm sumCallBack là hàm gọi sau. Do vậy nó sẽ không bị re-render khi function cha render
    const sumCallBack = useCallback(() => { sum() }, [])
    return (
        <>
            <ChildComponent sum={sumCallBack} />

            {/* Counter */}
            <h2>Counter : {counter}</h2>
            <button
                onClick={(e) => setCounter(counter + 1)}
            >Click me</button>
        </>
    )
}
export default ParentCallBack;