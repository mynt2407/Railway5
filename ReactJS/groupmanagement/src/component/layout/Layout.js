import "../../css/layout.css";
import React from "react";

function Layout(props) {

    return (
        <div className="layoutContainer">
            <div>
                {props.top}
            </div>
            <div>
                {props.center}
            </div>
            <div>
                {props.bottom}
            </div>

        </div>
    );
}

export default Layout;