import React from 'react';
import Person from "./Person";

class PersonList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            persons: [
                {
                    id: 1,
                    firstName: "My",
                    lastName: "Nguyen Thi",
                    age: 20
                },
                {
                    id: 2,
                    firstName: "Neo",
                    lastName: "Nguyen",
                    age: 25
                },
                {
                    id: 1,
                    firstName: "Duy",
                    lastName: "Nguyen Ngoc",
                    age: 30
                }
            ]
        }
    }
    render() {
        const personList = this.state.persons.map(
            person => 
                <Person
                    key={person.id}
                    id={person.id}
                    firstName={person.firstName}
                    lastName={person.lastName}
                    age={person.age}
                  
                />
            )
        return (
            <div>
                { personList}
            </div>
        )
    }
}
export default PersonList;