import React from 'react'; import ParentComponent from './ParentComponent';
import { ThemeContext, themes } from './ThemeContext'

class GrandParentComponent3 extends React.Component {

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

        return (
            <ThemeContext.Provider value={themeAndMethod}>
                <ParentComponent />
            </ThemeContext.Provider>
        );
    }
}

export default GrandParentComponent3;


