import React, { useState } from 'react';

function Example1() {
    //Khai bao state va ham setState (setCount). Gia tri khoi tao state = 0
    const [count, setCount] = useState(0);
    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={() => setCount(count + 1)}>Click me</button>
        </div>
    )
}
export default Example1;