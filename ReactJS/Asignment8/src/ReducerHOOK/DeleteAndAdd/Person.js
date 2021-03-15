import React from 'react';

class Person extends React.Component {

    render() {
        return (
            <div onClick={this.props.click}>
                
                    <li>
                        {this.props.id}
                        {this.props.fullname}
                        {this.props.age}
                    </li>
               
            </div>
        )
    }
}
export default Person;