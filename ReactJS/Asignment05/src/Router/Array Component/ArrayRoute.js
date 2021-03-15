import React from "react";
import { Link, Route, Router, Switch } from "react-router-dom";
import "./sidebar.css"

const routers = [
    {
        path: "/sandwiches",
        exact: true,
        component: Sandwiches
    },

    {
        path: "/tacos",
        component: Tacos,
        routers: [
            {
                path: "/tacos/bus",
                component: Bus
            },
            {
                path: "/tacos/cart",
                component: Cart
            }
        ]
    },

];
export default function RouteConfig() {
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link to="/tacos">Tacos</Link>
                    </li>

                    <li>
                        <Link to="/sandwiches">Sandwiches</Link>
                    </li>
                </ul>

                <Switch>
                    {routers.map((route, index) => (
                        <SubRouter key={index} {...route} />
                    ))}

                </Switch>
            </div>
        </Router>
    );
}

function SubRouter(route) {
    return (
        <Route
            path={route.path}
            render={props => (
                <route.component {...props} routes={route.routers} />
            )}
        />
    );
}
function Bus() {
    return <h3>Bus</h3>;
}

function Cart() {
    return <h3>Cart</h3>;
}

function Sandwiches() {
    return <h2>Sandwiches</h2>;
}

function Tacos({ routes }) {
    return (
        <div>
            <h2>Tacos</h2>
            <ul>
                <li>
                    <Link to="/tacos/bus">Bus</Link>
                </li>
                <li>
                    <Link to="/tacos/cart">Cart</Link>
                </li>
            </ul>

            <Switch>
                {routes.map((route, i) => (
                    <SubRouter key={i} {...route} />
                ))}
            </Switch>
        </div>
    );
}