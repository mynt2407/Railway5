import React from 'react';
import MesssageContext from './MessageContext';
import { ThemeContext } from './ThemeContext'

function ChildComponent(props) {
    return (
        <MesssageContext.Consumer>
            {
                message => (
                    <ThemeContext.Consumer>
                        {
                            ({ theme, changeTheme }) =>
                                <div>
                                    <h1 style={{ backgroundColor: theme.background, color: theme.foreground }}> Message from Grandparents: {message}</h1>
                                    <button style={{ backgroundColor: theme.background, color: theme.foreground }}>Cháu đã hiểu</button>
                                    <button onClick={changeTheme}>Change Theme</button>
                                </div>
                        }
                    </ThemeContext.Consumer>
                )
            }

        </MesssageContext.Consumer>
    );
}

export default ChildComponent;

