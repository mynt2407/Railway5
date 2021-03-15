import React, { useEffect, useState } from 'react';

function CleanUp() {
    const [count, setCount] = useState(0);

    //sử dụng UseEffect thay cho ComponentDidMount và DidUpdate 
    useEffect(() => {
        document.title = `You click ${count} times`;
    });
    return (
        <>
            <p>You click {count} times</p>
            <button
                onClick={() => setCount(count + 1 )}>
                Click me
                </button>
        </>
    )
}
export default CleanUp;