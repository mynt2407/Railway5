import React from 'react'
import Mentee from './Mentee';

class DeleteListMentee extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            mentees: [
                {
                    id: 1,
                    fullname: "Nguyễn Ngọc Duy"
                },
                {
                    id: 2,
                    fullname: "Tống Quang Anh"
                },
                {
                    id: 3,
                    fullname: "Đinh Thu Loan"
                },
                {
                    id: 4,
                    fullname: "Hà Văn Tiến"
                },
                {
                    id: 5,
                    fullname: "Nguyễn Hải Đăng"
                },
                {
                    id: 6,
                    fullname: "Nguyễn Tiến Quang"
                }
            ]
        }

    }


    deleteMentee = id => {
        //get index
        const menteeIndex = this.state.mentees.findIndex(m => { return m.id === id });

        //get state
        const localMentee = [...this.state.mentees]

        //delete person
        localMentee.splice(menteeIndex, 1)

        //update person in state 
        this.setState(
            {
                mentees: localMentee
            }
        );

    }

    render() {
        const menteeList = this.state.mentees.map(
            mentee =>
                <Mentee
                    key={mentee.id}
                    fullname={mentee.fullname}
                    click={() => { this.deleteMentee(mentee.id) }}>
                </Mentee>
        );

        return (
            <div>
                {menteeList}
            </div>
        );
    }

}
export default DeleteListMentee;