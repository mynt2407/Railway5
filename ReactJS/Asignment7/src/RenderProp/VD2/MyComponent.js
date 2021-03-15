import React from 'react';

class MyComponent extends React.Component {
    render() {
        return (
            <div>
                The Mouse position is {this.props.coordinate.x} :{this.props.coordinate.y}
            </div>
        )
    }
}
export default MyComponent;