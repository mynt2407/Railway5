import React from "react";
import "../../../css/navtop.css";
import NotificationsIcon from '@material-ui/icons/Notifications';
import MenuIcon from '@material-ui/icons/Menu';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import ArrowDropDownIcon from '@material-ui/icons/ArrowDropDown';

function NavTop() {

    return (
        <div className="navTopContainer">
            <div className="iconMenu">
                <MenuIcon />
            </div>
            <div>
                <NotificationsIcon />
            </div>
            <div>
                <AccountCircleIcon />
            </div>
            <div>
                Nam
            </div>
            <div>
                <ArrowDropDownIcon />
            </div>
        </div>
    );
}

export default NavTop;