import React from "react";
import Boiling from "./Boiling";

class Caculator extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            temperature: " "
        };
    }
    handleChange = e => {
        this.setState({
            temperature: e.target.value
        });
    }
    render() {
        return (
            <fieldset>
                <legend>Enter temperature in Celius:</legend>
                <input value={this.state.temperature} onChange={this.handleChange}></input>
                <Boiling celsius={parseFloat(this.state.temperature)}></Boiling>
            </fieldset>
        );
    }

}
export default Caculator;