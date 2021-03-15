import React from 'react';
import Mouse from './Mouse';

class MyComponent extends React.Component {
    render() {
        return (
            <Mouse>
                {coordinate =>
                    <div>
                        The Mouse position is {coordinate.x} : {coordinate.y}
                    </div>
                }
            </Mouse>
        )
    }
}
export default MyComponent;