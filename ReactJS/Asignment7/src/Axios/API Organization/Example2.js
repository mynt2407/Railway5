import React from "react";
import { Switch, Route, Link } from "react-router-dom";

import Home from "../Home";
import CreateEmployee from "./CreateEmployees2";
import ListEmployee from "./EmployeeList2";
import DeleteEmployee from "./DeleteEmployees2";
import Error from "./Error";


function Example2(props) {

    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/view">Employees List</Link>
                    </li>
                    <li>
                        <Link to="/create">Create Employees</Link>
                    </li>
                    <li>
                        <Link to="/delete">Delete Employees</Link>
                    </li>
                </ul>
            </nav>
            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/view" component={ListEmployee} exact />
                <Route path="/create" component={CreateEmployee} exact />
                <Route path="/delete" component={DeleteEmployee} exact />
                <Route component={Error} />
            </Switch>
        </div>
    )
}
export default Example2;