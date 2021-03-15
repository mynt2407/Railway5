import React from 'react';
//import Axios from 'axios';
import EmployessApi1 from './FunctionApi';

class CreateEmployee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: ''
        };
    }
    changeName = (event) => {
        this.setState({
            name: event.target.value
        })
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const body = {
            name: this.state.name
        }

        EmployessApi1.create(body)
            .then(response => {
                console.log(response);
                event.target.reset();
            })
            .catch(error => console.log("Loi roi"))
    }

    render() {
        return (

            <form onSubmit={(e) => this.handleSubmit(e)}>
                <label>Create employee
                    <input onChange={(e) => this.changeName(e)} />
                </label>
                <input type="submit" value="Submit" />
            </form>

        )
    }
}
export default CreateEmployee;