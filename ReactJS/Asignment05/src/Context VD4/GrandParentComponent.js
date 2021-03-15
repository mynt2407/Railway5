import React from 'react';
import ParentComponent from './ParentComponent';
import { ThemeContext, themes } from './ThemeContext'
import MessageContext from './MessageContext'

class GrandParentComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            theme: themes.dark
        }
    }

    changeTheme = () => {
        this.setState(state => ({
            theme: state.theme === themes.dark ? themes.light : themes.dark
        }));
    }

    render() {
        const themeAndMethod = {
            theme: this.state.theme,
            changeTheme: this.changeTheme
        };

        const message = "Cố học đi cháu";

        return (
            <MessageContext.Provider value={message}>
                <ThemeContext.Provider value={themeAndMethod}>
                    <ParentComponent />
                </ThemeContext.Provider>
            </MessageContext.Provider>
        );
    }
}

export default GrandParentComponent;


