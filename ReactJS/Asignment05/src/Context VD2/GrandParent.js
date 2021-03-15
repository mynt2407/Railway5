import React from "react";
import ChildComponent from "./ChildrenFunction";
import { ThemeContext, themes } from "./ThemeContext";

class GrandParentComponent2 extends React.Component {
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
        return (
            <ThemeContext.Provider value={this.state.theme}>
                <ChildComponent/>
                <button onClick={this.changeTheme}>Change Theme</button>
            </ThemeContext.Provider>
        )
    }

}
export default GrandParentComponent2;