import React from 'react';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import "../VD1/style.css";


function SignupFormikSelector() {

    return (
        <Formik
            initialValues={
                {
                    firstName: '',
                    lastName: '',
                    email: ''
                }
            }

            validate={
                values => {
                    const errors = {};

                    // firstname
                    if (!values.firstName) {
                        errors.firstName = 'Required';
                    } else if (values.firstName.length < 3) {
                        errors.firstName = 'Must be 3 characters or greater';
                    }

                    // lastname
                    if (!values.lastName) {
                        errors.lastName = 'Required';
                    } else if (values.lastName.length < 3) {
                        errors.lastName = 'Must be 3 characters or greater';
                    }

                    // email
                    if (!values.email) {
                        errors.email = 'Required';
                    } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
                        errors.email = 'Invalid email address';
                    }

                    return errors;
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
                <Field name='firstName' type='text' placeholder="Enter Firstname" />
                <ErrorMessage style={{ color: 'red' }} name='firstName' />

                {/* lastName */}
                <label htmlFor="lastName">Last Name</label>
                <Field name='lastName' type='text' placeholder="Enter Lastname" />
                <ErrorMessage name='lastName' />

                {/* Email */}
                <label htmlFor="email">Email</label>
                <Field name='email' type='email' placeholder="Enter email" />
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

export default SignupFormikSelector;

