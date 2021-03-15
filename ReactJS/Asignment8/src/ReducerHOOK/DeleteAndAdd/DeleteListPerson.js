import React, { useState } from 'react';
import DeleteAdd from './DeleteOrAdd';

class DeletePerson extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            persons:
                [
                    {
                        id: 1,
                        fullname: "Nguyễn Ngọc Duy",
                        age: 25
                    },
                    {
                        id: 2,
                        fullname: "Tống Quang Anh",
                        age: 23
                    },
                    {
                        id: 3,
                        fullname: "Đinh Thu Loan",
                        age: 20
                    },
                    {
                        id: 4,
                        fullname: "Hà Văn Tiến",
                        age: 20
                    },
                    {
                        id: 5,
                        fullname: "Nguyễn Hải Đăng",
                        age: 22
                    },
                    {
                        id: 6,
                        fullname: "Nguyễn Tiến Quang",
                        age: 21
                    }
                ]
        }

    }
    deletePerson = id => {
        //convert to index
        const index = this.state.persons.findIndex(p => { return p.id === id })

        //getLocalPerson
        const localPerson = { ...this.state.persons }

        //Xoa person theo Id, su dung slice
        localPerson.slice(index, 1)

        //update state hien tai
        this.setState({
            persons: localPerson
        })
    }


    render() {

        const personList = this.state.persons.map(
            person =>
                <DeleteAdd
                    key={person.id}
                    id={person.id}
                    fullname={person.fullname}
                    age={person.age}
                    click={() => this.deletePerson(person.id)}
                />
        )
        return (
            <>
                {personList}
            </>
        )

    }
}
export default DeletePerson;