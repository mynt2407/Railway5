import React from "react";
import MessageContext from "./MessageContext";
import ParentComponent from "./ParentComponent";

function GrandParentComponent(props) {
    const message = "Co hoc di chau";
    return (
        <MessageContext.Provider value={message}>
            <ParentComponent />
        </MessageContext.Provider>

    )
}
export default GrandParentComponent;