import React, { useContext } from 'react';
import MessagesContext from './MessagesContext';

function ChildrenComponent(props) {

    const messages = useContext(MessagesContext)
    return (
        <div>
            Messages from Grandparent: {messages} 
        </div>
    )
}
export default ChildrenComponent;