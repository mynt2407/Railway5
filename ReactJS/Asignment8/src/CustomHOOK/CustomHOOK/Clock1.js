import React from 'react';
import styled from 'styled-components'
import useClock from './UseClcok';

function Clock1() {

    //Goi Custom HOOk de su dung
    const [time, ampm] = useClock();

    const Timer = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    width: 150px;
    height: 150px;
    border: solid 5px rgb(128, 0, 32);
    background-color: rgb(255, 113, 47);
    `
    return (
        <Timer>
            <b>{time}</b>
            <b>{ampm}</b>
        </Timer>
    )
}
export default Clock1;