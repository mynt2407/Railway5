import React from 'react'

class Person2 extends React.Component {
    constructor(props){
        super(props);
        this.state={
            fullName: ""
        }
    }

    changeName = (event) =>{
        this.setState(
            {
                fullName: event.target.value
            }
        );
    }
    render(){
        return (
            <div>
                <h1>FullName: {this.state.fullName} </h1>
                <input type="text" onChange = {this.changeName}></input>
            </div>
        )
    }
}
export default Person2;