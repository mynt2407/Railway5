import React from "react";
import { Switch, Route, Link } from "react-router-dom";
import CreateEmployee from "./CreateEmployees";
import DeleteEmployee from "./DeleteEmployees";
//import ListEmployee from "./EmployeeList";
import Error from "./Error";
import Home from "../Home";
import ListEmployee2 from "../VD2/EmployeeList";


function Example1(props) {

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
                <Route path="/view" component={ListEmployee2 } exact />
                <Route path="/create" component={CreateEmployee } exact />
                <Route path="/delete" component={DeleteEmployee } exact /> 
                <Route component={Error} />
            </Switch>
        </div>
    )
}
export default Example1;