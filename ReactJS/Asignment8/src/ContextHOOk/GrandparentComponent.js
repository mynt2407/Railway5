import React from 'react';
import ChildrenComponent from './ChildrenComponent';
import MessagesContext from './MessagesContext';

function GrandparentComponent () {
    const message = " Co hoc di chau";
    return(
        <MessagesContext.Provider value = {message}>
            <ChildrenComponent/>
        </MessagesContext.Provider>
    )
}
export default GrandparentComponent;