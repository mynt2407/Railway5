import React from 'react';
import MyComponent from './MyComponent';
import withMouse from './withMouse';

class ComponentWithMouse extends React.Component {
    render() {
        const MyComponentWithMouse = withMouse(MyComponent);
        return (
            <MyComponentWithMouse />
        )
    }
}
export default ComponentWithMouse;