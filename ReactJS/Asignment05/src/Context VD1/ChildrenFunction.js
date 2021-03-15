import React from "react";
import MessageContext from "./MessageContext";

function ChildComponent(props) {

    return (
      <div>
          <MessageContext.Consumer>
              {context => <h1>New Message from Grandparents : {context}</h1>}
          </MessageContext.Consumer>
      </div>
    )
}
export default ChildComponent;