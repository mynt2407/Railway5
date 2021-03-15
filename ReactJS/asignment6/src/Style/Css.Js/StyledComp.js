import React from 'react';
import styled from "styled-components"

class StyledComp extends React.Component {
    render() {

        const H1 = styled.h1`
        background-color: red;
       color: whitesmoke;
       font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
       padding: 10px;
       `
        return (
            <div>
                <H1>Full Name: Neo Nguyen</H1>
            </div>
        )
    }
}
export default StyledComp;