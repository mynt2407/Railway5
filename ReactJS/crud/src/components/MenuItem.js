import React from "react";
import { NavLink } from "react-router-dom";
import  '../../src/css/main.css'

function MenuItem(props) {
    return (
        <div>
            <NavLink activeStyle={{ color: 'red' }} to={props.path}  className ="itemMenu">
                {props.icon}
                {props.name}
            </NavLink>
        </div>
    )
}
export default MenuItem;