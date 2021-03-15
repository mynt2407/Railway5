import React, { Component } from 'react';
import ArlertHello from './Event/ArlertHello';
import Copy from './Event/Copy';
//import LoginController from './Render Element/Login';
import FormContainer from './FormContainer';


class App extends Component {
    render() {
        return (
            <div>
                <p>Hello World</p>
                <FormContainer />
                {/* <Copy />
                <LoginController /> */}
                {/* <ArlertHello/> */}

            </div>
        );
    }
}
export default App;  