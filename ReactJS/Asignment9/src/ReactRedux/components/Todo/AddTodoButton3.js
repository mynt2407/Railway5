import React from 'react'
import { bindActionCreators } from 'redux';
import { actionAdd3 } from '../../redux/action/actionAdd3';
import { connect } from "react-redux";

class AddTodoButton3 extends React.Component {
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

    // handleAdd = () => {
    //     store2.dispatch(actionAdd(this.state.input));
    //     this.setState({
    //         input: ""
    //     });
    // }

    handleAdd = () => {
        this.props.actionAdd3(this.state.input);
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

// Trong truong hop co nhieu dispatch thi khai bao 1 thang mapDispatchToProps chua nhieu thang dispatch nho ben trong
const mapDispatchToProps = dispatch => {
    return bindActionCreators(
        { actionAdd3 }, dispatch
    );
}

//truyền vào connect tham số thứ 2 là mapDispatchToProps để mapping trực tiếp dispatch mà không phải khai báo store và action nào nữa
export default connect(null,  mapDispatchToProps )(AddTodoButton3);