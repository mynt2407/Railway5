import React from 'react';
import Person from './Person';

function PersonList(props) {
    const personList = props.persons.map(
        person => 
        <Person
            key={person.id}
            firstName={person.firstName}
            lastName={person.lastName}
            age={person.age}
        >
        </Person>
    )
    return (
        <div>
            {personList}
        </div>
    )
}
export default PersonList;