import { StylesProvider } from '@material-ui/core';
import React from 'react';
import styles from "./style.module.css"

class StyleModule extends React.Component {
    render(){
        console.log(styles);
        return(
            <div className = {styles.fullname}>Full Name: Neo Nguyen</div>
        )
    }
}
export default StyleModule;