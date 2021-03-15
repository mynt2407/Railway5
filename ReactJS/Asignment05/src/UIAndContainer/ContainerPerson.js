import React from 'react';
import PersonList from './PersonList';

class ContainerPerson extends React.Component {

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
        return (
            <PersonList persons={this.state.persons} />
        )
    }
}
export default ContainerPerson;