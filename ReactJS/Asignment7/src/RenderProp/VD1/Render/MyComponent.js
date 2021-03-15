import React from 'react';
import Mouse from './Mouse';
class MyComponent extends React.Component {
    render() {
        return (
            <Mouse render={
                coordinate => (
                    <div>
                        The Mouse position is {coordinate.x} :{coordinate.y}
                    </div>
                )}
            />
        )
    }
}
export default MyComponent;