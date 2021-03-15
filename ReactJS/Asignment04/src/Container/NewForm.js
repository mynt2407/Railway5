import React from 'react'
import { Link, Route, Switch } from 'react-router-dom';
import FormContainer from './FormContainer';
import OtherPage from './OtherPage';

function NewForm() {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/otherPage">Other Page</Link>
                    </li>
                    
                    <li>
                        <Link to="/form">FormContainer</Link>
                    </li>


                </ul>
            </nav>

            <Switch>
                <Route path="/form" component={FormContainer} exact />
                <Route path="/otherPage" component={OtherPage} exact />
            </Switch>
        </div>
    )
}
export default NewForm;