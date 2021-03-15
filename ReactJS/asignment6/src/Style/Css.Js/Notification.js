import React from 'react';
import styled from "styled-components"

const BasicNotification = styled.p`
background: lightblue;
    padding: 5px;
    margin: 5px;
    color: black;
`;

const SuccessNotification = styled(BasicNotification)`
background : pink
`;

const ErrorNotification = styled(SuccessNotification)`
background : red;
`;

function Notification() {
    return (
        <div>
            <BasicNotification>Basic</BasicNotification>
            <SuccessNotification>Success</SuccessNotification>
            <ErrorNotification>Error</ErrorNotification>
        </div>
    )
}
export default Notification;