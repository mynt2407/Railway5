import React from 'react';
import Person from './Person';

class RenderPerson extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            persons: [
                {
                    id: 1,
                    firstName: "Nguyen Van",
                    lastName: "A"
                },
                {
                    id: 2,
                    firstName: "Nguyen Van",
                    lastName: "B"
                },
                {
                    id: 3,
                    firstName: "Nguyen Van",
                    lastName: "C"
                }
            ]
        }
    }

    render() {
        return (
            <div className="person">
                <h1>Full Name: {this.renderName()}</h1>
            </div>
        )
    }

    componentDidMount() {
        setInterval(() => {
            this.setState((prevState) => {
                return { persons: [...prevState.persons] }
            })
        }, 1000
        )
    }

    render() {
        console.log("parent render");
        const personList = this.state.persons.map(
            person =>
                <Person
                    key={person.id}
                    id={person.id}
                    firstName={person.firstName}
                    lastName={person.lastName}
                />
        );
        return (
            <div>
                {personList}
            </div>
        )
    }
}
export default RenderPerson;