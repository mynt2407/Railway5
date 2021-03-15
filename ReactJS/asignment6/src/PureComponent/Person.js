import React from 'react';
import "./person.css"
class Person extends React.PureComponent {

    renderName = () => {
        return `${this.props.firstName} ${this.props.lastName}`
    }

    render() {
        console.log("Child render");
        return (
            <div className="person">
                <h1>Full Name: {this.renderName()}</h1>
            </div>
        )
    }
}
export default Person;