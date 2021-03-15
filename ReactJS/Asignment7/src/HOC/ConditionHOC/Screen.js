import React from "react";
import { Switch, Route, Link, Redirect } from "react-router-dom";
import Home from "../../Axios/Home";
import EmployeeContainer from "../VD1/EmployeeContainer";
import UserContainer from "../VD1/UserContainer";
import LoginContext from "./LoginContext";

class Screen extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isLogin: true
        }
    }

    render() {
        return (
            <LoginContext.Provider value={this.state.isLogin}>

                <div>
                    <nav>
                        <ul>
                            <li>
                                <Link to="/">Home</Link>
                            </li>
                            <li>
                                <Link to="/employees">Employees List (Protected)</Link>
                            </li>
                            <li>
                                <Link to="/users">User List </Link>
                            </li>
                        </ul>
                    </nav>
                    <Switch>
                        <Route path="/" component={Home} exact />
                        <Route path="/employees" component={EmployeeContainer} exact />
                        <Route path="/users" component={UserContainer} exact />
                        <Redirect to="/" />
                    </Switch>
                </div>
            </LoginContext.Provider>
        )
    }
}
export default Screen;