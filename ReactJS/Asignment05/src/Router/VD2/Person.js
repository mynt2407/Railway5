import React from 'react';
import { Link } from 'react-router-dom';
import "./person.css"

function Person(props) {
    console.log(props);
    let match = props.match;
    console.log(match);

    return (
        <div className="person">
            <Link to={`${match.url + "/" + props.id}`} >
            Fullname : {props.firstName + " " + props.lastName}
            </Link>
            
            <p>Age: {props.age}</p>
        </div>
    )
}
export default Person;