import React from "react";
import { Switch, Route, NavLink, Redirect } from "react-router-dom";
import About from "../VD2/About";
import Error from "../VD2/Error";
import Home from "../VD2/Home";
import PersonList from "../VD2/PersonList";
import PersonDetail from "../VD2/PersonDetail"
import CreatePerson from "./CreatePerson";



function Example2() {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <NavLink exact activeStyle={{ color: 'red' }} to="/">Home</NavLink>
                    </li>
                    <li>
                        <NavLink exact activeStyle={{ color: 'red' }} to="/about">About</NavLink>
                    </li>
                    <li>
                        <NavLink exact activeStyle={{ color: 'red' }} to="/persons">Person</NavLink>
                    </li>
                    <li>
                        <NavLink exact activeStyle={{ color: 'green' }} to="/create">Create Person</NavLink>
                    </li>
                </ul>
            </nav>

            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/about" component={About} exact />
                <Route path="/persons/:id" component={PersonDetail} />
                <Route path="/persons" component={PersonList} />
                <Route path="/create" component={CreatePerson}/>
                {/* thay cho Error page. Neu khong tim duoc page thi tra ve trang home  */}
                <Redirect to="/" />
                {/* <Route component={Error} /> */}


                {/* <Route path="/" exact>
                    <Home />
                </Route>

                <Route path="/about1" exact>
                    <About />
                </Route>

                <Route path="/person1" >
                    <PersonList />
                </Route>

                <Route >
                    <Error />
                </Route> */}

            </Switch>
        </div>
    )
}
export default Example2;