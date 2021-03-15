import React, { Component } from 'react'
import { Prompt } from 'react-router-dom';
/* Import Components */
import Button from '../components/Button';
import CheckBox from '../components/CheckBox';
import Input from '../components/Input';
import Select from '../components/Select';
import TextArea from '../components/TextArea';


class FormContainer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            newUser: {
                name: "",
                age: "",
                gender: "",
                skills: [],
                about: ""
            },
            genderOption: ["Male", "Female", "Other"],
            skillOption: ["Programing", "Development", "Design", "Tester"],

            isShow: false
        };
    }

    handleFullName = (event) => {
        let value = event.target.value;
        this.setState(
            prevState => ({
                newUser: {
                    ...prevState.newUser,
                    name: value
                },
                isShow: event.target.value.length > 0
            }),
        );
    }

    handleInput = (event) => {
        let value = event.target.value;
        let name = event.target.name;

        this.setState(
            prevState => ({
                newUser: {
                    ...prevState.newUser,
                    [name]: value
                },
                isShow: event.target.value.length > 0
            })
        );
    }
    handleAge = (event) => {
        let value = event.target.value;
        this.setState(
            prevState => ({
                newUser: {
                    ...prevState.newUser,
                    age: value
                },
                isShow: event.target.value.length > 0
            }),
        );
    }

    handleCheckBox = (event) => {
        const newSelection = event.target.value;
        let newSelectionArray;

        if (this.state.newUser.skills.indexOf(newSelection) > -1) {
            newSelectionArray = this.state.newUser.skills.filter(
                s => s !== newSelection
            );
        } else {
            newSelectionArray = [...this.state.newUser.skills, newSelection];
        }
        this.setState(prevState => ({
            newUser: {
                ...prevState.newUser,
                skills: newSelectionArray
            },
            isShow: event.target.value.length > 0
        })

        );
    }


    handleTextArea = (event) => {
        let value = event.target.value;
        this.setState(
            prevState => ({
                newUser: {
                    ...prevState.newUser,
                    about: value
                },
                isShow: event.target.value.length > 0
            }),
        );

    }

    handleFormSubmit = (e) => {
        e.preventDefault();

        let userData = this.state.newUser;

        fetch("http://example.com", {
            method: "POST",
            body: JSON.stringify(userData),
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json"
            }
        }).then(response => {
            response.json().then(data => {
                console.log("Successful" + data);
            });
        });
    }

    handleClearForm = (e) => {
        e.preventDefault();
        this.setState({
            newUser: {
                name: "",
                age: "",
                gender: "",
                skills: [],
                about: ""
            }
        });
    }
    // submit = (event) => {
    //     event.preventDefault();
    //     event.target.reset();
    //     this.setState({
    //         isShow: false
    //     });
    // }


    render() {
        return (
            <form className="container-fluid" onSubmit={(e) => this.submit(e)}>

                <Prompt
                    when={this.state.isShow}
                    message={location => `Are you sure want to go ${location.pathname} ?`}
                />

                {/* Name of User */}
                <Input
                    inputType={"text"}
                    title={"FullName"}
                    name={"name"}
                    value={this.state.newUser.name}
                    placeholder={"Enter your name"}
                    handleChange={this.handleInput}
                /> {""}

                {/* Age */}
                <Input
                    inputType={"number"}
                    name={"age"}
                    title={"Age"}
                    value={this.state.newUser.age}
                    placeholder={"Enter your age"}
                    handleChange={this.handleAge}
                />{" "}

                {/* Selection gender */}
                <Select
                    title={"Gender"}
                    name={"gender"}
                    options={this.state.genderOption}
                    value={this.state.newUser.gender}
                    placeholder={"Select Gender"}
                    handleChange={this.handleInput}
                />{" "}

                {/* Checkbox Skill */}
                <CheckBox
                    title={"Skills"}
                    name={"skills"}
                    options={this.state.skillOption}
                    selectedOptions={this.state.newUser.skills}
                    handleChange={this.handleCheckBox}
                />{""}

                {/* About you */}
                <TextArea
                    title={"About you"}
                    rows={10}
                    value={this.state.newUser.about}
                    name={"currentPetInfo"}
                    handleChange={this.handleTextArea}
                    placeholder={"Describe your past experience and skill"}
                />

                {/* Button submit */}
                <Button
                    action={this.submit}
                    type={"primary"}
                    title={"Submit"}
                    style={buttonStyle}

                />
               
                {/* Clear the form */}
                <Button
                    action={this.handleClearForm}
                    type={"secondary"}
                    title={"Clear"}
                    style={buttonStyle}
                />
            </form>
        )
    }
}
const buttonStyle = {
    margin: "10px 10px 10px 10px"
};
export default FormContainer;