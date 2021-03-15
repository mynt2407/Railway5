import React from 'react';
import Logo from './Logo';
import NavTop from './NavTop';
import '../../../src/css/header.css'

function Header(props) {
    return (
        <div className = "headerContainer">
            <Logo width={props.logoWidth} />
            <NavTop />
        </div>
    )
}
export default Header;