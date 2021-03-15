import React from 'react';
import { useFormik } from 'formik';
import "./style.css";

function SignupForm() {

    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            email: ''
        },
        validate: values => {
            const errors = {};
            // firstname
            if (!values.firstName) {
                errors.firstName = 'Required';
            } else if (values.firstName.length < 5) {
                errors.firstName = 'Must be 5 characters or greater';
            }
            // lastname
            if (!values.lastName) {
                errors.lastName = 'Required';
            } else if (values.lastName.length < 5) {
                errors.lastName = 'Must be 5 characters or greater';
            }
            // email
            if (!values.email) {
                errors.email = 'Required';
            } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
                errors.email = 'Invalid email address';
            }

            return errors;
        },
        onSubmit: values => {
            alert(JSON.stringify(values, null, 2));
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
            <button type="submit">Submit</button>
        </form>
    );
};

export default SignupForm;

