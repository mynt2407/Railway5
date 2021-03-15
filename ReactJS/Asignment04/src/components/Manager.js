import React from "react";
import { Prompt } from "react-router-dom";

class CreatePerson extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isShow: false
        };
    }

    submit = (event) => {
        event.preventDefault();
        event.target.reset();
        this.setState({
            isShow: false
        });
    }

    changeName = (event) => {
        this.setState({
            isShow: event.target.value.length > 0
        });
    }

    render() {
        return (
            <form onSubmit ={(e) => this.submit(e)}>
                <Prompt
                    when={this.state.isShow}
                    // message={location => `Are you sure want to go ${location.pathname} ?`}
                    message = "Do you want to finish this form before move other page? "
                />
                <label>
                    Name:
                <input type="text" onChange={(e) => this.changeName(e)} />
                </label>

                <input type="submit" value="Submit" />
            </form>
        )
    }

}
export default CreatePerson;