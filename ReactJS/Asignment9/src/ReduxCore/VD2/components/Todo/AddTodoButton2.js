import React from 'react'
import { actionAdd } from '../../redux/action/actionAdd';
import store2 from '../../Store';

class AddTodoButton2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            input: ""
        };
    }
    updateInput = (e) => {
        this.setState({
            input: e.target.value
        })
    }

    handleAdd = () => {
        store2.dispatch(actionAdd(this.state.input));
        this.setState({
            input: ""
        });
    }

    render() {
        return (
            <>
                <input
                    onChange={this.updateInput} value={this.state.input}
                />
                <button
                    onClick={this.handleAdd}
                >Click me</button>
            </>
        )
    }
}
export default AddTodoButton2;