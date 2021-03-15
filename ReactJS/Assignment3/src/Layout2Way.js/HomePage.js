import React from 'react'
import './layout.css'

class HomePage extends React.Component {
    render() {
        return (
            <div className="total">
                {this.props.top}
                {this.props.main}
                {this.props.bottom}
            </div>
        )
    }

}
export default HomePage;