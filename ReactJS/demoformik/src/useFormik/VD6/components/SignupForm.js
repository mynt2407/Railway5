import React from 'react';
import { useFormik } from 'formik';
import "./style.css";
import EmployeeApi from '../api/EmployeeApi';

function SignupFormApi() {

    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            email: ''
        },
        validate: async values => {
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
            } else {
                try {
                    const isExists = await EmployeeApi.existsByEmail(values.email);
                    console.log(isExists);
                    if (isExists) {
                        errors.email = 'This email is already registered';
                    }
                } catch (error) {
                    console.log(error);
                }
            }

            return errors;
        },

        //submit len server

        onSubmit: async (values, { resetForm }) => {
            const body = {
                firstName: values.firstName,
                lastName: values.lastName,
                email: values.email
            }
            try {
                // call api
                await EmployeeApi.create(body);
                // message
                alert("Success");
                // reset form
                resetForm({});
            } catch (error) {
                console.log(error);
            }
        }
    });

    return (
        <form onSubmit={formik.handleSubmit}>
            {/* firstName */}
            <label htmlFor="firstName">First Name</label>
            <input
                id="firstName"
                name="firstName"
                type="text"
                {...formik.getFieldProps('firstName')}
            />
            {formik.touched.firstName && formik.errors.firstName ?
                <div>{formik.errors.firstName}</div>
                :
                null
            }
            {/* lastName */}
            <label htmlFor="lastName">Last Name</label>
            <input
                id="lastName"
                name="lastName"
                type="text"
                {...formik.getFieldProps('lastName')}
            />
            {formik.touched.lastName && formik.errors.lastName ?
                <div>{formik.errors.lastName}</div>
                :
                null
            }
            {/* email */}
            <label htmlFor="email">Email Address</label>
            <input
                id="email"
                name="email"
                type="email"
                {...formik.getFieldProps('email')}
            />
            {formik.touched.email && formik.errors.email ?
                <div>{formik.errors.email}</div>
                :
                null
            }
            {/* submit */}
            <button type="submit" disabled={formik.isSubmitting}>Submit</button>
        </form>
    );
};

export default SignupFormApi;

