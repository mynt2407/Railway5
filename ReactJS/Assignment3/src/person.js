import React from 'react';
import './person.css'

// class Person extends React.Component{
//     render() {
//         return (
//             <div className = "person">
//     <h1>FullName: Nguyen Thi My</h1>
//     <h3>Age: 25</h3>
//             </div>
//         )
//     }

// }

// function Person(props) {
//     return (
//         <div className = "person">
//             <h1>Fullname: {props.fullName}</h1>
//             <h3>Age: {props.age}</h3>
//             <h3>Year of birth: {new Date().getFullYear() - props.age}</h3>
//         </div>
//     );
// }

// class Person extends React.Component{
//     constructor(props){
//         super(props);
//         this.firstName = "Nguyen Thi";
//         this.lastName = "My 1111"
//     }
//     getFullName = () => {
//         return this.firstName + " " + this.lastName;
//     }
//     render(){
//         return (
//             <div className = "person">
//                 <h1>FullName: {this.getFullName()}</h1>
//                  <h3>Age: 25</h3> </div> 
//         )
//     }
// }

function Person() {
    const firstName = "Nguyen Ngoc";
    const lastName = "Duy";
    const getFullName = () => {
        return firstName + " " + lastName;
    }
    return (
        <div className = "person">
            <h1>FullName: {getFullName()}</h1>
             <h3>Age: 25</h3> </div> 
    )
}
export default Person;