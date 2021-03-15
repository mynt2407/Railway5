import React from 'react';
import "./person.css"

function Person(props) {
    
    let match = props.match;
    console.log(match);

    return (
        <div className="person">
            Fullname : {props.firstName + " " + props.lastName}
            <p>Age: {props.age}</p>
        </div>
    )
}
export default Person;