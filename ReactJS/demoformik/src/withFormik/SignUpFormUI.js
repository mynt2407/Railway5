import React from 'react';
import "./style.css";

function SignUpFormUI(props) {
    const { values, touched, errors, handleSubmit, getFieldProps } = props;
    return (
        <form onSubmit={handleSubmit}>
            {/* firstName */}
            <label htmlFor="firstName">First Name</label>
            <input
                id="firstName"
                name="firstName"
                type="text"
                {...getFieldProps('firstName')}
            />
            {touched.firstName && errors.firstName ?
                <div>{errors.firstName}</div>
                :
                null
            }
            {/* lastName */}
            <label htmlFor="lastName">Last Name</label>
            <input
                id="lastName"
                name="lastName"
                type="text"
                {...getFieldProps('lastName')}
            />
            {touched.lastName && errors.lastName ?
                <div>{errors.lastName}</div>
                :
                null
            }
            {/* email */}
            <label htmlFor="email">Email Address</label>
            <input
                id="email"
                name="email"
                type="email"
                {...getFieldProps('email')}
            />
            {touched.email && errors.email ?
                <div>{errors.email}</div>
                :
                null
            }
            {/* submit */}
            <button type="submit">Submit</button>
        </form>
    );

}
export default SignUpFormUI;