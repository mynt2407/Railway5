import React from 'react';

class Counter extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        }
    }

    increase = () => {
        const {count} = this.state
        this.setState({
            count: count + 1
        })
    }

    decrease = () => {
        const {count} = this.state
        this.setState({
            count: count - 1
        })
    }

    render() {
        const {count} = this.state
        return (
            <div >
                {this.props.render({
                    increase: this.increase,
                    decrease: this.decrease,
                    count : count
                })}
            </div>
        )
    }
}
export default Counter;