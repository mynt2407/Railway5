import React, { useState } from 'react';

class NoCleanUp extends React.Component {
    constructor(props) {
        super(props)
        this.state = { count: 0 }
    }

    componentDidMount() {
        document.title = `You click ${this.state.count} times`;
        console.log(document.title);
    }

    componentDidUpdate() {
        document.title = `You click ${this.state.count} times`;
    }

    render() {
        return (
            <>
                <p>You click {this.state.count} times</p>
                <button
                    onClick={() => this.setState({ count: this.state.count + 1 })}
                >Click me
                </button>
            </>
        )
    }
}
export default NoCleanUp;