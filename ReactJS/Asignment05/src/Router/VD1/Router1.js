import React from "react";
import { Switch, Route, Link } from "react-router-dom";
import Home from "./Home";
import About from "./About";
import PersonList from "./PersonList";
import Error from "./Error";


function Example1() {
    
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about">About</Link>
                    </li>
                    <li>
                        <Link to="/person">Person</Link>
                    </li>
                </ul>
            </nav>
            <Switch>
                <Route path="/" component = {Home} exact/>
                <Route path="/about" component = {About} exact />
                <Route path="/person" component = {PersonList} />
                <Route component ={Error}/>
            </Switch>
        </div>
    )
}
export default Example1;