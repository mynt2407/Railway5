import React, { Fragment } from 'react';
import ClockEx from './Clock';

class UsingClock extends React.Component {
    render() {
        return (
            <Fragment>
                <ClockEx.DefaultClock render={
                    time => (time.date)
                }
                />
                <ClockEx.HasDayClock render={
                    time => (time.date)
                }
                />
            </Fragment>
        )}
}
export default UsingClock;