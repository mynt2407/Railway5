import React from 'react';
import LinearIndeterminate from './Icon2';
import CircularIndeterminate from './IconLoading';

function WithLoading(WrappedComponent) {

    class HOC extends React.Component {
        render() {
            if (this.props.isLoading) {
                return (
                    <LinearIndeterminate/>
                    // <CircularIndeterminate/>
                )
            }
            return <WrappedComponent {...this.props}/>
        }
    }
    return HOC;
}
export default WithLoading;