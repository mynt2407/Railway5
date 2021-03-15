import React from 'react';
import { ThemeContext } from './ThemeContext'

function ChildComponent(props) {
    return (
        <ThemeContext.Consumer>
            {
                ({ theme, changeTheme }) =>
                    <div>
                        <h1 style={{ backgroundColor: theme.background, color: theme.foreground }}> Message from Grandparents:</h1>
                        <button style={{ backgroundColor: theme.background, color: theme.foreground }}>Cháu đã hiểu</button>
                        <button onClick={changeTheme}>Change Theme</button>
                    </div>
            }
        </ThemeContext.Consumer>
    );
}

export default ChildComponent;

