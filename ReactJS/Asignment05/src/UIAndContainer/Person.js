import React from 'react';
import './person.css'
function Person(props) {
    return (
        <div className="person">
            <h2>FullName : {props.firstName + " " + props.lastName}</h2>
            <h4>Age: {props.age}</h4>
        </div>
    )
}
export default Person;