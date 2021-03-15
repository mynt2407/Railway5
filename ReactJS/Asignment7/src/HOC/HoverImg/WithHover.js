import React from 'react';
function withHover(WrappedComponent, opacity = 0.5) {

    class HOC extends React.Component {
        constructor(props) {
            super(props);
            this.state = {
                isHovered: false
            }
        }
        handleMouseEnter = () => {
            this.setState({
                isHovered: true
            })
            console.log('1');
        }
        handleMouseLeave = () => {
            this.setState({
                isHovered: false
            })
            console.log('2');
        }
        
        render() {
            return (
                <div
                    style={{
                        opacity: this.state.isHovered ? opacity : 1,
                    }}
                    onMouseEnter={this.handleMouseEnter}
                    onMouseLeave={this.handleMouseLeave}
                >
                    <WrappedComponent {...this.props} />
                </div>
            )
        }

    }
    return HOC;
}
export default withHover;