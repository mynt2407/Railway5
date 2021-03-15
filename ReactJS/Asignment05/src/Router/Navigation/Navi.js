import React from "react";
import { Switch, Route, Link, Redirect, useHistory } from "react-router-dom";
import Home from "../VD2/Home";
import "./navi.css"
import Page1 from "./Page1";
import Page2 from "./Page2";
import Page3 from "./Page3";
import Page4 from "./Page4";

function Navigation1(props) {

    //su dung HOOK cho don gian

    const history = useHistory();
    console.log(history);
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>

                    <br />
                    <div className="container">
                        <div className="item">
                            <li>
                                <Link to="page1"> Page1 (Link)</Link>
                            </li>
                            <li>
                                <Link to="page2"> Page2 (Link)</Link>
                            </li>
                            <li>
                                <Link to="page3"> Page3 (Link)</Link>
                            </li>
                            <li>
                                <Link to="page4"> Page4 (Link)</Link>
                            </li>
                        </div>

                        <div className="item">
                            <li>
                                <button onClick={() => history.push("/page1")}>
                                    Page1 (history.push())
                                </button>
                            </li>

                            <li>
                                <button onClick={() => history.push("/page2")}>
                                    Page2 (history.push())
                                </button>
                            </li>

                            <li>
                                <button onClick={() => history.push("/page3")}>
                                    Page3 (history.push())
                                </button>
                            </li>

                            <li>
                                <button onClick={() => history.push("/page4")}>
                                    Page4 (history.push())
                                </button>
                            </li>
                        </div>


                        <div className="item">
                            <li>
                                <button onClick={() => history.replace("/page1")}>
                                    Page1 (history.replace())
                                </button>
                            </li>

                            <li>
                                <button onClick={() => history.replace("/page2")}>
                                    Page2 (history.replace())
                                </button>
                            </li>

                            <li>
                                <button onClick={() => history.replace("/page3")}>
                                    Page3 (history.replace())
                                </button>
                            </li>

                            <li>
                                <button onClick={() => history.replace("/page4")}>
                                    Page4 (history.replace())
                                </button>
                            </li>
                        </div>
                    </div>


                    <button onClick={() => console.log(history)}>Print History</button>

                </ul>
            </nav>

            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/page1" component={Page1} exact />
                <Route path="/page2" component={Page2} exact />
                <Route path="/page3" component={Page3} exact />
                <Route path="/page4" component={Page4} exact />
                <Redirect to="/" />
            </Switch>

        </div>
    )
}
export default Navigation1;