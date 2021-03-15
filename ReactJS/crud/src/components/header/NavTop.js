import React from 'react';
import ArrowDropDownIcon from '@material-ui/icons/ArrowDropDown';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import NotificationsIcon from '@material-ui/icons/Notifications';
import ReorderIcon from '@material-ui/icons/Reorder';
import '../../../src/css/header.css'

function NavTop(props) {

    return (
        <span >
            <span >
                <ReorderIcon />
            </span>

            <span >
                <NotificationsIcon />
            </span>

            <span >
                <AccountCircleIcon />
            </span>

            <span >
                <ArrowDropDownIcon />
            </span>

        </span>
    )
}
export default NavTop;