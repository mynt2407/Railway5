import React from 'react'
import Column1 from './Column1'
import Column2 from './Column2';
import Column3 from './Column3';
import './layout.css'
import './body.css'


class BodyVertical extends React.Component {
    render() {
        return (
            <div className="body">
                <Column1 className="item" />
                <Column2 className="item" />
                <Column3 className="item" />
            </div>
        )
    }
}
export default BodyVertical;