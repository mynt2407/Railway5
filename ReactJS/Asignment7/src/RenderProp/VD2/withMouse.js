import React from 'react';
import Mouse from './Mouse';

function WithMouse(WrappedComponent) {
    class HOC extends React.Component {
        render() {
            return (
                <Mouse render={
                    coordinate => {
                        <WrappedComponent coordinate={coordinate} {...this.state} />
                    }
                }
                />
            )
        }
    }
    return HOC;
}
export default WithMouse;