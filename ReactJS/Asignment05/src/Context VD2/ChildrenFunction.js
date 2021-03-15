import React from "react";
import { ThemeContext } from "./ThemeContext";

function ChildComponent(props) {

    return (

        <ThemeContext.Consumer>
            {
                theme =>
                    <div>
                        <h3 style={{ backgroundColor: theme.background, color: theme.foreground }}>Message from Grandparents:</h3>
                    </div>
            }
        </ThemeContext.Consumer>

    )
}
export default ChildComponent;