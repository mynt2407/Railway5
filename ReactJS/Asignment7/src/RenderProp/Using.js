import React from 'react';
import RenderProps from './Render';
class UsingRenderProps extends React.Component {
    render() {
        return (
            <RenderProps
                callBackFunction={
                    (data) => (
                        <div>Hello {data}</div>
                    )
                }
            />
        )
    }
}
export default UsingRenderProps;