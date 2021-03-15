import { bindActionCreators } from "redux";
import React from 'react';
import { connect } from "react-redux";
import "../css/Screen.css";
import { actionAddInput } from '../../CRUD/redux/action/ActionInput';
import ListInput from "./ListInput";
import NoList from "./NoList";

class Screen extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            input: ""
        };
    }
    handleChange = (e) => {
        this.setState({
            input: e.target.value
        })
    }
    handleKeyPress = (e) => {
        if (e.key === "Enter") {
            this.submitMessage()
        }
    }
    submitMessage = () => {
        this.props.actionAddInput(this.state.input);
        this.setState({
            input: ''
        })
    }

    render() {
        return (
            <div id="toDoApp">

                <label id="toDoTitle" for="basic-input">
                    <h2 className="text-monospace">Add new things To Do:</h2>
                </label>

                <div id="toDoAdd" className="input-group">
                    <input className="form-control" type="text"
                        placeholder="Thing to do"
                        value={this.state.input}
                        onChange={this.handleChange}
                        onKeyPress={this.handleKeyPress} />
                    <span className="input-group-append">
                        <button className="form-control"
                            onClick={this.submitMessage}>
                            Add
                </button>
                    </span>
                </div>

                {this.props.inputs.length > 0 ? (
                    <ListInput />
                ) : <NoList />
                }
            </div>
        )
    }
}

const mapDispatchToProps = dispatch => {
    return bindActionCreators(
        { actionAddInput }, dispatch
    );
}
const mapGlobalStateToProps = state => {
    return {
        inputs: state.input.inputs
    }
}
export default connect(mapGlobalStateToProps, mapDispatchToProps)(Screen);
