import React from 'react';
import Layout from '../container/Layout';
import Main from '../container/Main';
import Footer from './Footer';
import Header from './header/Header';

function InjectLayout(props) {

    const logoWidth = 150;
    const header = <Header logoWidth={logoWidth} />
    const main = <Main logoWidth={logoWidth} />

    return (
        <Layout
            top={header}
            center={main}
            bottom={Footer()}
        />
    )
}

export default InjectLayout;