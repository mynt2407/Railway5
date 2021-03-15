import React, { Fragment } from 'react';
import styled from "styled-components"

//import './Clock.css'

const HasDay = styled.div`
    padding: 10px;
    margin: 20px;
    display: inline-block;
    border-radius: 50%;
    width: 150px;
    height: 150px;
    left: 0;
    top: 0;
    border: solid 2px red;
`
const HourAndMinute = styled(HasDay)`
border: solid 2px green;
`;
// const Basic = styled(HasDay)`
// border: solid 2px springgreen;
// `;
// const HasMinute = styled(HasDay)`
// border: solid 2px tomato;
// `;
//with HasDay style. Has Hour and minute, day, month
const DefaultClock = ({ date }) => (
    <Fragment>
        {date.getHours()}
        {date.getMinutes()}
    </Fragment>
);

//
const HasDayClock = ({ date }) => {
    const hours = date.getHours()
    const minutes = date.getMinutes()
    const monthYear = date.getSeconds()
    return (
        <Fragment>
            {hours}
            {minutes}
            {monthYear}
        </Fragment>
    )
}
class Watch extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            date: new Date()
        }
    }

    componentDidMount = () => (this.TICK = setInterval(this.update, 1000))
    componentWillUnmount = () => clearInterval(this.TICK)
    update = () => this.setState({ 
        date: new Date()
    })

    render() {

        return (
            <div>
                <HasDay>
                    <HourAndMinute>
                        {this.state.render(this.state.date)}
                    </HourAndMinute>
                </HasDay>
            </div>
        )
    }
}
const ClockEx = { Watch, HasDayClock, DefaultClock }
export default ClockEx;








