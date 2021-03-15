import React from 'react';

class Mentee extends React.Component {

    render() {
        return (
            <div onClick={this.props.click}>
                
                    <li>
                        {this.props.fullname}
                    </li>
               
            </div>
        )
    }
}
export default Mentee;