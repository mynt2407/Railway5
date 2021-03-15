import React from 'react';
import LinearProgress from '@material-ui/core/LinearProgress';
//import CircularIndeterminate from './IconLoading';

function WithLoading(WrappedComponent) {

    class HOC extends React.Component {
        render() {
            if (this.props.isLoading) {
                return (
                    <LinearProgress/>
                    // <CircularIndeterminate/>
                )
            }
            return <WrappedComponent {...this.props}/>
        }
    }
    return HOC;
}
export default WithLoading;