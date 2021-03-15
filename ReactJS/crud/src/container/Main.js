import React from 'react';
import HomeIcon from '@material-ui/icons/Home';
import PersonIcon from '@material-ui/icons/Person';
import PeopleAltIcon from '@material-ui/icons/PeopleAlt';
import ReorderIcon from '@material-ui/icons/Reorder';
import { Route, Switch } from 'react-router-dom';
import Menu from '../components/Menu';
import HomePage from '../components/Page/HomePage'
import AccountPage from '../components/Page/AccountPage'
import GroupPage from '../components/Page/GroupPage'
import CategoryPage from '../components/Page/CategoryPage'
import  '../../src/css/main.css'

function Main(props) {
    const menuList = [
        {
            icon: <HomeIcon />,
            path: "/",
            component: HomePage,
            name: "Home",
            isExact: true
        },
        {
            icon: <PersonIcon />,
            path: "/accounts",
            component: AccountPage,
            name: "Accounts",
            isExact: true
        },
        {
            icon: <PeopleAltIcon />,
            path: "/groups",
            component: GroupPage,
            name: "Groups",
            isExact: true
        },
        {
            icon: <ReorderIcon />,
            path: "/categorys",
            component: CategoryPage,
            name: "Category",
            isExact: true
        },
    ]
    const route =
        <Switch>
            {menuList.map(item => {
                return (
                    <Route
                        path={item.path}
                        component={item.component}
                        exact={item.isExact}
                    />
                )
            })
            }
        </Switch>
    return (
        <div className ="mainContainer">
            <Menu width={props.logoWidth} menuList={menuList} />
            {route}
        </div>
    )
}
export default Main;