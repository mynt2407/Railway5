import React from 'react';
import Axios from 'axios';

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
        console.log(event);
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const baseURL = `https://5f47b29395646700168d9bd1.mockapi.io`;

        const body = {
            name: this.state.name
        }

        Axios.post(`${baseURL}/api/v1/employees`, body)
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