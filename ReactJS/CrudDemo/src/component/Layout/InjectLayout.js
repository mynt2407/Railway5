import React from 'react';


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