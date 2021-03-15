import React from "react";

class Copy extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            time: "",
            timer: false,
            counter: 0
        };
        this.handleCopy = this.handleCopy.bind(this);
    }

    handleCopy(event) {
        event.preventDefault();
        this.setState(prevState => ({
            counter: prevState.counter + 1
        }));

        alert("Don't copy it!");
    }

    render() {
        return (
            <>
                <p onCopy={this.handleCopy}>Copy me!</p>
                <p>Copy count: {this.state.counter}</p>
            </>
        );
    }
}
export default Copy;