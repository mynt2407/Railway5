import React from 'react'
import store6 from '../redux/Store';
import {addTodo} from '../redux/todoSlide'

class AddTodoButton extends React.Component {
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
        store6.dispatch(addTodo(this.state.input));
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
export default AddTodoButton;