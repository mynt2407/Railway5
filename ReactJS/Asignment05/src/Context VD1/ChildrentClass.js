import React from "react";
import MessageContext from "./MessageContext";

class ChildComponent extends React.Component {
    render() {
        return (
            <div>Message from Grandparent: {this.context}</div>
        );
    }
}

ChildComponent.contextType = MessageContext;
export default ChildComponent;