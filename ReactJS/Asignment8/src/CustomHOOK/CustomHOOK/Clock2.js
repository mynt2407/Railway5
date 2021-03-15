import React  from 'react';
import useClock from './UseClcok';
import styled from 'styled-components'

function Clock2() {

    //Goi Custom HOOk de su dung
    const [time, ampm] = useClock();

    const Timer = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    width: 150px;
    height: 150px;
    border: solid 5px rgb(0, 128, 0);
    background-color: wheat;
    `
    return (
        <Timer>
            <b>{time}</b>
            <b>{ampm}</b>
        </Timer>
    )
}
export default Clock2;