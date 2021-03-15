import React from 'react';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import "../../VD1/style.css";
import EmployeeApi from '../api/EmployeeApi';


function SignupFormikApi() {

    //validate fistName
    const validateFirstname = value => {
        let errorMessage;
        if (!value.firstName) {
            errorMessage.firstName = 'Required';
        } else if (value.firstName.length < 3) {
            errorMessage.firstName = 'Must be 3 characters or greater';
        }
        return errorMessage;
    }

    //validate lastName
    const validateLastName = value => {
        let errorMessage;
        if (!value.lastName) {
            errorMessage.lastName = 'Required';
        } else if (value.lastName.length < 3) {
            errorMessage.lastName = 'Must be 3 characters or greater';
        }
        return errorMessage;
    }
    //validate email
    //Ham bat dong bo 
    const validateEmail = async value => {
        let errorMessage;
        if (!value) {
            errorMessage = 'Required';
        } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value)) {
            errorMessage = 'Invalid email address';
        } else {
            const isExists = await EmployeeApi.existsByEmail(value);
            console.log(isExists);
            if (isExists) {
                errorMessage = 'This email is already registered';
            }
        }
        return errorMessage;
    };

    return (
        <Formik
            initialValues={
                {
                    firstName: '',
                    lastName: '',
                    email: ''
                }
            }

            onSubmit={
                values => {
                    alert(JSON.stringify(values, null, 2));
                }
            }

            //dien xong form thi moi validate
            validateOnChange={false}
            validateOnBlur={false}
        >

            <Form>
                {/* firstName */}
                <label htmlFor="firstName">First Name</label>
                <Field name='firstName' type='text' placeholder="Enter Firstname" validate={validateFirstname}/>
                <ErrorMessage style={{ color: 'red' }} name='firstName' />

                {/* lastName */}
                <label htmlFor="lastName">Last Name</label>
                <Field name='lastName' type='text' placeholder="Enter Lastname" validate={validateLastName} />
                <ErrorMessage name='lastName' />

                {/* Email */}
                <label htmlFor="email">Email</label>
                <Field name='email' type='email' placeholder="Enter email" validate={validateEmail}/>
                <ErrorMessage name='email' />

                {/* note */}
                <label htmlFor="note">Note</label>
                <Field name="note" as='textarea' placeholder="Say something if you want" />

                {/* job */}
                <label htmlFor="job">Job</label>
                <Field name="job" as='select'>
                    <option value="">Select a job type</option>
                    <option value="designer">Designer</option>
                    <option value="developer">Developer</option>
                    <option value="product">Product Manager</option>
                    <option value="other">Other</option>
                </Field>

                {/* submit */}
                <button type="submit" >Submit</button>
            </Form>
        </Formik>
    );
};

export default SignupFormikApi;

