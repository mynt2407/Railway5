import React from 'react';
import MyComponent from './MyComponent';
import WithMouse from './withMouse';

class Example2 extends React.Component {
    render() {
        const MyComponentWithMouse = WithMouse(MyComponent);
        return (
            <MyComponentWithMouse />
        )
    }
}
export default Example2;