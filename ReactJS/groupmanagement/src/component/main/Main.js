import React from "react";
import "../../css/main.css";
import Menu from "./Menu";
import { Route, Switch } from "react-router-dom";
import HomePage from "../HomePage";
import AccountPage from "../AccountPage";
import GroupPage from "../group/GroupPage";
import HomeIcon from '@material-ui/icons/Home';
import SupervisorAccountIcon from '@material-ui/icons/SupervisorAccount';
import PersonIcon from '@material-ui/icons/Person';

function Main(props) {
    const menuList = [
        {
            icon: <HomeIcon />,
            name: "Home",
            path: "/",
            component: HomePage,
            isExact: true
        },
        {
            icon: <PersonIcon />,
            name: "Account Management",
            path: "/accounts",
            component: AccountPage,
            isExact: true
        },
        {
            icon: <SupervisorAccountIcon />,
            name: "Group Management",
            path: "/groups",
            component: GroupPage,
            isExact: true
        }
    ];

    const route =
        <Switch>
            {menuList.map(item => {
                return (
                    <Route
                        path={item.path}
                        component={item.component}
                        exact={item.isExact}
                    />
                );
            })}
        </Switch>

    return (
        <div className="mainContainer">
            <Menu width={props.logoWidth} menuList={menuList} />
            { route}
        </div>
    );
}

export default Main;