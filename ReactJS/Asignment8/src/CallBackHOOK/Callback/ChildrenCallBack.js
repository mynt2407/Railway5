import React, { useMemo, useState } from 'react';

function ChildrenCallBack(props) {
    const [a, setA] = useState(0);
    const [b, setB] = useState(0);

    console.log('render Childrent');
    const sumResult = useMemo(() => props.sum(a, b), [a, b]
    )

    return (
        <>
            {/* Caculator sum a, b */}

            <label>Input a: </label>
            <input
                type="number"
                value={a}
                onChange={(e) => setA(e.target.value)}
            />
            <br />

            <label>Input b: </label>
            <input
                type="number"
                value={b}
                onChange={(e) => setB(e.target.value)}
            />

            <br />
            <label>Sum : {sumResult}</label>
        </>)
}
export default React.memo(ChildrenCallBack);
//export default ChildComponent;