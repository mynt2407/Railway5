import React from "react";
import { NavLink } from "react-router-dom";

function MenuItem(props) {
    return (
        <div>
            <NavLink to={props.path} activeStyle={{ color: "red" }} exact>
                {props.icon}
                {props.name}
            </NavLink>
        </div>
    );
}

export default MenuItem;