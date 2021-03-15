import { ErrorMessage, Field, Form, Formik } from 'formik';
import React from 'react';
import '../../formikTag/VD1/style.css';
import * as Yup from 'yup';
import EmployeeApi from './api/EmployeeApi';


function SignUpYup() {

    return (
        <Formik
            initialValues={
                {
                    firstName: '',
                    lastName: '',
                    email: ''
                }
            }
            validationSchema={Yup.object({
                firstName: Yup.string()
                    .min(5, 'Must be 5 characters or greater')
                    .required('Required'),

                lastName: Yup.string()
                    .min(5, 'Must be 5 characters or greater')
                    .required('Required'),

                email: Yup.string()
                    .email('Invalid email address')
                    .required('Required')

                    //call api
                    .test('checkUniqueEmail', 'This email has already exist', async email =>{
                        const isExists = await EmployeeApi.existsByEmail(email);
                        console.log(isExists);
                        return !isExists;
                    })
            })}

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

    )
}

export default SignUpYup;