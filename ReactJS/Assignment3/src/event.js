import React from 'react'
import Student from './Student';

class Event1 extends React.Component {
   
    clickTo = () => {
        console.log("Hello My Nguyen");
    }

    render() {
        return (
            <div>
                <p onClick={this.clickTo}>Hello baybe</p>
            </div>
        )
    }

}

function Event2() {
    const characters = ['a', 'b', 'c', 'd'];
    const listCharater = characters.map((number) => <li>{number}</li>);
    return (
        <div>
            <ul>
                {
                    listCharater
                }
            </ul>
        </div>
    )
}
// function Event3() {
//     const listMembers = [
//         'Nguyễn Ngọc Duy',
//         'Tống Quang Anh',
//         'Đinh Thu Loan',
//         'Hà Văn Tiến',
//         'Nguyễn Hải Đăng',
//         'Nguyễn Tiến Quang',
//         'Nguyễn Chiến Thắng'
//     ];
//     const addlistMember = listMembers.map((element) => <li>{element}</li>);
//     return (
//         <div>
//             <ol>
//                 {
//                     addlistMember
//                 }
//             </ol>
//         </div>
//     )
// }



export default { Event1, Event2};
