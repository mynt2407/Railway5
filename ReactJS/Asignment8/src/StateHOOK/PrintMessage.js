import React, { useState } from 'react';

function PrintMessage() {
    const [messages, setMessages] = useState("")
    return (
        <>
            <label>Input: </label>
            <input
                value={messages}
                placeholder="Enter everything"
                type="text"
                onChange={(event) => setMessages(event.target.value)}
            />
            <ul>
                <li><b style={{color: 'red'}}>{messages}</b></li>
            </ul>
        </>
    )
}
export default PrintMessage;