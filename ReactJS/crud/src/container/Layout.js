import React from 'react';
import '../../src/css/layout.css'

function Layout(props) {
    return (
        <div className="container">

            <div >
                {props.top}
            </div>

            <div className="body">
                {props.center}
            </div>

            <div className="header">
                {props.bottom}
            </div>
            
        </div>
    )
}
export default Layout;