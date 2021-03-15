import React from 'react';
import styled from "styled-components"

class StyledProps extends React.Component {
    render() {

        const H1 = styled.h1`
        background-color: green;
       color: ${props => props.textColor};
       font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
       padding: 10px;
       `
        return (
            <div>
                <H1 textColor = "whitesmoke">Full Name: Neo Nguyen</H1>
            </div>
        )
    }
}
export default StyledProps;