import React from "react";

export const themes = {
    light: {
        foreground: '#ffffff',
        background: '#FF0000',
    },
    dark: {
        foreground: '#ffffff',
        background: '#222222',
    }
}

export const ThemeContext = React.createContext(themes.dark)
//default value dark