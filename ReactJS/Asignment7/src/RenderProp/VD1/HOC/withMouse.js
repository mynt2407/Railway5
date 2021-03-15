import React from 'react';
function withMouse(WrappedComponent) {
    
    class HOC extends React.Component {
        constructor(props) {
            super(props);
            this.state = {
                x: 0,
                y: 0
            }
        }

        handleMouseMove = (event) => {
            console.log(event);
            this.setState({
                x: event.clientX,
                y: event.clientY
            });
        }

        render() {
            return (
                <div onMouseMove={this.handleMouseMove}>
                    <WrappedComponent {...this.props} coordinate={this.state} />
                </div>
            )
        }
    }
    return HOC;
}
export default withMouse;