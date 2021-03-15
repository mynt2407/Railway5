import React from 'react';

class RenderProps extends React.Component {
    render() {
        const data = "My Nguyen Thi";
        return ( 
            <div>
                {this.props.callBackFunction(data)}
            </div>
        )
    }
}
export default RenderProps;